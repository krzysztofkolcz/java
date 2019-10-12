# Item 11: Override clone judiciously 
http://thefinestartist.com/effective-java/11
```
public class SomeClass implements Cloneable{

    @Override
    public SomeClass clone(){
        return (SomeClass)super.clone();//zwraca objekt klasy SomeClass
    }
}

```

StackNoArrayClone - klasa, która nie klonuje tablicy elements. Oznacza to, że w tablicy nowego objektu
pozostają referencje do objektów tablicy starego objektu. To zachowanie jest błędne.
Należy sklonować tablicę 'elements'.
# Item 12: Comparable compareTo
```
public interface Comparable<T> {
   int compareTo(T t);
}
```

a.compareTo(b)
a < b -> wynik mniejszy od 0
a == b -> 0
a > b -> wynik wiekszy od 0

-dziedziczenie klasy implementujacej Comparable - lepiej nie dziedziczyc, tylko zrobi pole z objektem tej klasy
zaimplementowac swoj comparable, oraz zapewnic widok na objekt klasy po ktorej mielibysmy dziedziczyc.

# Item 13: Minimize the accessibility of classes and members
Najniższy możliwy stopień dostępu
Jeżeli klasa może byc package-private, powinna taka być.
Zmienną można zmienić z private na package-private, aby ułatwić testy. Jednak nie można bardziej podnosić poziomu dostępu.
Klasy z publicznymi mutowalnymi zmiennymi nie są thread-safe
Jeżeli nawet pole jest final i immutable, uczynienie go public uniemożliwia późniejszą zmianę reprezentaji danych wewnątrz klasy.
Również zmienne statyczne nie powinny być public, z wyjątkiem stałych, które powinny być:
-public static final
-immutable lub primitive

Tablice zawsze są mutable, błędem jest więc jeżeli w obiekcie są tablice, które są
-public static final
-jest metoda, która zwraca taką tablicę

Rozwiązania:
```
private static final Thing[] PRIVATE_VALUES = { ... };
public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
```
```
private static final Thing[] PRIVATE_VALUES = { ... };
public static final Thing[] values() {
    return PRIVATE_VALUES.clone();
}
```

# Item 14: In public classes, use accessor methods, not public fields
Zmienne klasy publicznej nie powinny być public jeżeli są mutable.
Jeżeli są immutable - jest to mniej szkodliwe, jednak kontrowersyjne.

Jeżeli klasa jest nested, lub package-private, zmienne mogą być publiczne.
Wpp wykorzystywać metody dostępowe.

Jeżeli pole jest już public, lepiej żeby było final.

# Item 15: Minimize mutability
Bez metod mutatorów - zmieniających stan obiektu
Uniemożliwić dziedziczenie - klasa final,
                            lub zrobić wszystkie konstruktory private, lub package-private
                            a zamiast publicznych konstruktorów - statyczne fabryki (static factories)
Wszystkie pola - final
Wszystkie pola - prywatne
Jeżeli klasa zawiera pola mutowalne - uniemożliwić dostęp do ich referencji z zewnątrz

Zamiast działać na obiekcie - metody zwracają nową instancję niemutowalnego obiektu.
```
public final class Complex {
    private final double re;
    private final double im;
    public Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }
    //...
}
```

Immutable objects - thread safe

Dostarczenie instancji klasy immutable - public static final - dla często używanych wartości zmiennych immutable:
public static final Complex ZERO = new Complex(0, 0);
Współdzielenie takiej zmiennej immutable zmniejsza użycie pamięci i częstotliwość działania garbage collector
Nie trzeeba/nie należy robić kopii takich obiektów

Klasy immutable są idealnymi kluczami dla Map, oraz elementami Set

Minus - wymagają obiektu, dla każdej odrębnej wartości.
Przykład - instancja BigInteger zawierająca milion bitów. Jeżeli chcemy zmienić jeden - duży narzut pamięci.
Zamist tego lepiej wykorzystać klasę mutowalną - BigSet.

Kolejny możliwy problem - operacja składająca się z wielu kroków, a w każdym tworzymy nowy obiekt.

## static factories
```
// Immutable class with static factories instead of constructors
public class Complex {
    private Complex(...) {
        ...
    }
    public static Complex valueOf(...) {
        return new Complex(...);
    }
    ...
}
```

## pola cache - niefinalne
Uściślenie - nie jest tak, że metody nie mogą zmieniać stanu obiektu i że wszystkie pola muszą być finalne.
Naprawdę jest tak - że metody nie mogą wytwarzać widocznych na zewnątrz zmian.
Niektóre klasy posiadają zmienne nonfinal, które przechowują/cacheują wyniki drogich obliczeń - np. hashCode.
'Lazy initialization'

## Serializacja klas immutable
jeżeli klasa implementuje serializeable i zawiera pola z obiektami mutable,
należy dostarczyć metody readObject lub readResolve
lub wykorzystać metody:
ObjectOutputStream.writeUnshared i ObjectInputStream.readUnshared

# Item 16: Composition over inheritance
Przykład problemu z dziedziczeniem klasa InstrumentedHashSet
## Wywołanie przepisanych metod pod spodem
Metoda klasy rodzica wykorzystuje inną metodę klasy rodzica.
Obie metody są przepisane w klasie dziedziczącej.
```
public class InstrumentedHashSetWrong <E> extends HashSet<E> {
    private int addCount = 0;
    ...
    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
}
```
addAll w HashSet wywołuje add, które jest @Override w InstrumentedHashSetWrong,
przez co addCount zostanie zwiększone w dwóch miejscach.


## Rozwój klasy rodzica.
Rodzic i klasa dziedzicząca.
Klasa dziedzicząca zapewnia bezpieczeństwo przy wstawianiu sprawdzając określone warunki.
W kolejnej iteracji klasa rodzica dodaje nową metode wstawiania.
Metoda ta nie jest przepisana w klasie dziedziczącej, powstaje więc problem - możliwość dodania 'nielegalnego' elementu

## Kompozycja zamiast dziedziczenia.
Problem z kompozycją - self problem java (nie do końca rozumiem - chyba trzymanie referencji do wewnętrznego obiektu)

# Item 17: Design and document for inheritance or else prohibit it

