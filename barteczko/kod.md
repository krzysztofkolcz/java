#ch01
kolejność inicjalizowania:
pola statyczne
inicjalizatory statyczne
niestatyczne pola otrzymują wartości domyślne, następnie przypisania
konstruktor

W inicjalizoatorach można się odwoływac tylko do pól poprzedzających inicjalizator.

```
public class InitOrder {
    private static int s = 100;
    private static final int C;
    private int a = 1;

    InitOrder() {
        report("Konstruktor: s, C, a, b mają wartości :", s, C, a, b);
    }

    private int b = 2;

    {
        report("Blok inicjacyjny: s, C, a =", s, C, a);
    }

    static {
        report("Statyczny blok inicjacyjny, s, C = ", s, C);
        C = 101; // opóźnione inicjowanie stałej!
    }

    private static void report(String msg, int ... args ) {
        System.out.print(msg + " ");
        for (int i : args) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        report("Wywołanie metody main");
        new InitOrder();
    }
}
```
InitOrder:
"Statyczny blok inicjacyjny, s, C = ", 100, 0
"Wywołanie metody main"
"Blok inicjacyjny: s, C, a =", 100, 101, 1
"Konstruktor: s, C, a, b mają wartości :", 100, 101, 1, 2

Gdy dodana zmienna statyczna:
```
public class InitOrder {
    private static InitOrder iord = new InitOrder();
    private static int s = 100;
    private static final int C;
    private int a = 1;
    private int b = 2;
    // ..
}
```

Blok inicjacyjny: s, C, a = 0 0 1
Konstruktor: s, C, a, b mają wartości : 0 0 1 2
Statyczny blok inicjacyjny, s =  100
Wywołanie metody main
Blok inicjacyjny: s, C, a = 100 101 1
Konstruktor: s, C, a, b mają wartości : 100 101 1 2

#ch02
Wszystkie metody w javie oprócz statycznych, prywatnych i finalnych są wirtualne.
Umożliwiają więc polimorfizm.

```
public class Vehicle {
    public String start(){}
}

public class Car extends Vehicle{
    public String start(){}
}

Car c = new Car();
Vehicle v = c;
String msg = v.start(); //wywołana metoda start() zdefiniowana w klasie Car - polimorfizm.
```

@Overriding - przedefiniowanie
Przeciążenie
Przesłanianie - metody statyczne

Wady dziedziczenia - słaba hermetyzacja. Zmiana interfaceu klasy bazowej wymusza zmianę w klasach wykorzystujących klasy dziedziczące.

#ch03
Throwable
    Error
    Exception
        RuntimeException
        ...

Wyjątki od Throwable, ale nie od Error i RuntimeException - kontrolowane
Wyjątki od Error i RuntimeException - niekontrolowane (bez konieczności zapewnienia obsługi)

wyjątki powstające w wielu różnych miejscach, których wymuszona obsługa byłaby uciążkliwa - niekontrolowane
wyjątki, po których aplikacja powinna się podnieść (np. koniec pliku) - kontrolowane

```
try {
    // instrukcje wykonywane w bloku try
} catch (TypWyj1 exc) {
    // obsluga wyjątku typu TypWyj1
} catch (TypWyj2 exc) {
    // obsluga wyjątku typu TypWyj2
} catch (MTypWyj1 | MTypWyj2 | ... | MTypWyjN exc) {
    // obsługa wyj. MTypWyj1 ... MTypWyjN
} catch (TypWyjN exc) {
    // obsluga wyjatku typu TypWyjN
} finally {
    // kod wykonywany niezależnie do tego czy wyjatek powstał czy nie
}
```

try z jedną lub więcej klauzulą catch i finally,
try bez catch, ale z finally.

Finally wykonane po return.
ch03.Finally01
```
Finally01 finally01 = new Finally01();
int result = finally01.testingMethod();
System.out.println(result);


    public int testingMethod() throws InterruptedException {
        try{
            return 120;
        }finally{
            Thread.sleep(5000);
            System.out.println("testingMethod Finally block");
        }
    }
```
Result:
testingMethod Finally block
120

Czyli najpierw wywoływana klauzula finally, dopiero potem kontynuowany jest przebieg programu po return.
(Również, jeżeli return jest w catch)


Jeżeli brak cachta - finally się wywołuje, ale program się wywali:
```
try{
  et.test02(); /* rzuca null pointer exception */
}finally{
  /* finally jest wywoływane, ale ponieważ nie ma obsługi wyjątku przez catch, reszta programu nie jest wykonywana */
  System.out.println("Finally - No catch");
}
//nie zostanie wywołane:
System.out.println("After Finally - No catch");
```

Zgłoszenie wyjątku:
```
throw new NumberFormatException("Wadliwy format liczby: " + liczba);
```

TODO - dokończyć 3.5

#ch04

## 4.7 Mixiny , wielodziedziczenie
Jeżeli w dwóch interfaceach które dziedziczy klasa są domyślne metody z tą samą sygnaturą,
wówczas klasa musi przedefiniować tą metodę.

np.:
```
public interface Bear {
    default String bear() { return "Bear"; }
    default String x(){ return "XBear"; }
}

public interface Cat {
    default String cat() { return "Cat"; }
    default String x(){ return "XCat"; }
}

public class Bintorung implements Bear,Cat{
    private String name;
    public Bintorung(String name) {
        this.name = name;
    }
    public String toString() {
        return "Nazywam się " + name + "\ni jestem Bintorung," + "\nczyli " + bear() + cat();
    }

    @Override
    public String x() {
        return "XBintorung";
    }
}
```

## 4.8 Właściwości metod domyślnych

Domyślne metody są polimorficzne:
```
interface BaseIf {
    default String get() { return this.getClass().getSimpleName(); }
}
class A implements BaseIf {}
class B implements BaseIf {}

BaseIf a = new A();
System.out.println(a.get());

BaseIf b = new B();
System.out.println(b.get());

Wynik:
A
B
```

Użycie super:
```
interface Father {
    default String getSex() { return "M"; }
}

class Child implements Mother, Father {
    public String getSex() { return "?"; }
    public String fatherSex() { return "Tata: " + Father.super.getSex(); }
}
```

Metoda domyślna implementowana na różnych poziomach hierarchii dziedziczenia - kolejność:
1. Metoda przedefiniowana w klasie obiektu
2. Metoda implementowana w nadklasie obiektu
3. Metoda najbliższego w hierarchii interfaceu

## 4.9 Metody prywatne w interfaceach
Od javy 9
-muszą mieć implementacje (nie abstrakcyjne)
-nie default
-statyczne lub niestatyczne

## 4.10 Klasy wewnętrzne
obiekt niestatycznej klasy wewnętrznej zawiera referencje do obiektu klasy otaczającej.


## 4.11 Klasy wewnętrzne
Tworzenie obiektu niestatycznej klasy wewnętrznej wymaga zawsze istnienia obiektu klasy otaczającej

```
public class Car{
    private int fuel;
    ...
    public class Inner{
        @Override
        public String toString() {
            return "Inner{} Car{" + "fuel=" + fuel + "}";
        }
    }
}

Car car = new Car();
car.setFuel(10);
Car.Inner inner = car.new Inner();
System.out.println(inner); //Wyświetli: "Inner{} Car{fuel=10}";
```

## 4.12 - Anonimowe klasy wewnętrzne
Bez nazwy
```
class Car extends Vehicle {
    private ActionListener fuelConsumer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ...
        }
    };
    private Timer fuelTimer = new Timer(1000, fuelConsumer);
    ....
}
```

Bez zmiennej:
```
class Car extends Vehicle {
    private Timer fuelTimer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ...
        }
    });
...
}
```
## 4.13 - TODO


#ch05_generics Generics

## 5.3 Restrykcje
Nie dozwolone:
new T();
instanceof(T)
używać w statycznych kontekstach (jeden dla wszystkich instancji typu sparametryzowanego)
używać w literałach klasowych
tworzyc tablic typu T - info o typie el. tablicy jest przechowywane przez JVM (sprawdzenie wstawianych el)
w obsłudze wyjątków - mechanizm fazy wywołania



## 5.4 Uniwersalne argumenty typu - TODO powtórzyć
Nie jest możliwe takie coś:
ArrayList<Integer> list1 = new ArrayList<Integer>();
ArrayList<Object> list2 = list1;

<? extends X> - typ może być typem X lub dowolnym podtypem (czemu to się nazywa 'ograniczenie z dołu'?)
<? super X> -  typ może być typem X lub dowolnym nadtypem
<?> - dowolny nieznany typ

kowariancja względem T - B jest podtypem A (B implements A), C<B> jest podtypem C<A>
Czyli?
<? extends X>
ArrayList<? extends Number> - jest nadtypem wszystkich typów ArrayList<T>,
gdzie parametrem typu T jest  Number lub pochodne od Number (czyli dziedziczące od Number)
Można napisać:
ArrayList<? extends Number> list = new ArrayList<Integer>


kontrwarjacja względem T - B jest podtypem A (B implements A), C<A> jest podtypem C<B>
Czyli raczej C<? super A> jest podtypem C<B>
<? super X>
Integer jest podtypem Number (Integer implements Number), czyli
ArrayList<? super Integer> list = new ArrayList<Number>;
(czyli ArrayList<Number> jest podtypem ArrayList<? super Integer>)

<?> - biwarjacja
ArrayList<?> - wszystkie możliwe typy.

Person
Employee extends Person
Manager extends Employee

Czyli dla
ArrayList<? super Manger>
podtypem jest
ArrayList<Person>
lub
ArrayList<Employee>

dla
ArrayList<? extends Person>
podtypem jest
ArrayList<Manager>
lub
ArrayList<Employee>

#ch06 Programowanie funkcyjne
Wstęp

#ch07 Lambda wyrażenia
Interfacey funkcyjne - jedna metoda
@FunctionalInterface - można, nie trzeba

#ch08
## 8.1
Aby traktować znaki specjalne jako literały - należy je poprzedzić odwrotnym ukośnikiem \

find - odnajuje kolejne wystąpienia wyrażenia regularnego
```
String regex = "[0-9]+";
String txt = "196570";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(txt);
boolean match = matcher.matches();

while (matcher.find()) {
    result += matcher.group() + " od " + matcher.start() + " do " + matcher.end();
}
```
Wykorzystanie matchera do innego tekstu:
```
txt = "111";
matcher.reset(txt);
```


group - odnajuje kolejną grupę, ale chyba tekst w całości musi pasować do wyrażenia regularnego

Dostęp do pliku
```
Path path = Paths.get("file.txt");
Charset cs = Charset.defaultCharset();
List<String> lines = Files.readAllLines(path, cs);
```

#ch09
##9.5 Przekształcanie kolekcji
### Tablice z kolekcji
List<String> list = new ArrayList<String>()

// Pierwszy sposób
Object[] tab1 = list.toArray();

// Drugi sposób
String[] tab2 = (String[]) list.toArray(new String[0]);

### Kolekcja z tablicy

List<T> asList(T ... args) z klasy Arrays

(Nie mogłem usunąć elementu listy na rozmowie)
tworzy ona tylko nową (niemodyfikowalną strukturalnie) listę,
zatem by uzyskać z tablicy kolekcję innego rodzaju niż lista,
trzeba zastosować dodatkowo konstruktor odpowiedniej klasy kolekcyjnej.

##9.11
```
tset = new TreeSet<>( (e1, e2) -> {
int r = e1.getLastName().compareTo(e2.getLastName());
if (r == 0) {
r = e1.getFirstName().compareTo(e2.getFirstName());
}
if (r == 0) {
r = e1.getSalary() - e2.getSalary();
}
return r;
});
```

##9.13
map.put(key,val) - jeżeli klucz istnieje, wartość zostaje zastąpiona nową wstawianą wartością

map.keySet
map.entrySet
map.values
Zwracają widoki na mapę. Modyfikacja elementu modyfikuje obiekt w mapie.

```
for (Map.Entry<String, Integer> e : map.entrySet()) {
    String key = e.getKey();
    Integer val = e.getValue();
    System.out.println("Key = " + key + ", Val = " + val);
}
```
Metoda interfaceu Map:
```
default void forEach(BiConsumer<? super K,? super V> action)
```
```
map.forEach( (key, val) -> System.out.println("Key = " + key + ", Val = " + val));
```
```
map.putIfAbsent
map.getOrDefault
map.replace(key, newVal) - zastępuje wartość dla klucza, jeżeli istnieje
map.replace(key, oldVal, newVal) - zastępuje wartość dla odwzorowania key -> oldVal jeżeli istnieje
```

Synchronizowane kolekcje
```
public static Collection synchronizedCollection(Collection c);
public static Set synchronizedSet(Set s);
public static List synchronizedList(List list);
public static Map synchronizedMap(Map m);
public static SortedSet synchronizedSortedSet(SortedSet s);
public static SortedMap synchronizedSortedMap(SortedMap m);

List list = Collections.synchronizedList(new ArrayList());
```

Iterowanie po kolekcji również powinno być synchronizowane:
```
Collection c = Collections.synchronizedCollection(jakasKol);
synchronized(c) {
    Iterator i = c.iterator(); 
    while (i.hasNext()) {
        // ... i.next() itp.;
    }
}
```

#ch10
## 10.8 - kolektory

Budowanie pojedynczej wartości:
```
// clist jest listą obiektów klasy Country
String info = clist.stream()
    .map(Country::getName)
    .filter(s -> s.startsWith("Ch"))
    .collect(Collectors.joining(" / "));
System.out.println(info);
```

Budowanie map:
```
List<Country> clist = ....
Map<String, List<Country>> contMap;
contMap = clist.stream()
.collect(groupingBy(Country::getContCode));
```

Bezpośredni sposób budowania map,
gdzie pierwsza funkcja tworzy klucz, druga wartość:
```
Map<String, Double> popMap =
    clist.stream()
    .collect(toMap(Country::getIso2, Country::getPopul));
```

Grouping by examples:
https://www.mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/

```
String line = ...;
Pattern pattern = Pattern.compile("\\s+");
return pattern.splitAsStream(line).filter(s -> s.length() > 0);
```

## 10.10 Generatory

```
Stream.generate(Word::new)
```

```
String res = new Random().ints(1, 50)...
```

```
Stream.iterate(initVal, UnaryOperator f)
List<Integer> l = Stream.iterate(1, n-> n*3).limit(5).collect(toList());
```

## 10.11 Strumienie równoległe
```
list.parallelStream()
```

Ustawienie strumienia jako równoległego lub sekwencyjnego:
```
str
    .paralle()
    .filter(...)
    .map(...)
    .sequential()
    .forEach(System.out::println);
```

#ch11 - Input Output

## 11.2

Kopiowanie danych ze strumienia wejściowego do wyjściowego
```
public static void copy(InputStream in, OutputStream out) throws IOException {
    byte[] buffer = new byte[BUFLEN];
    int readLen;
    while ((readLen = in.read(buffer)) != -1) out.write(buffer, 0, readLen);
    out.flush();
}
```

Zapis wierszy do strumienia, z line separatorem
```
public static void writeLines(Iterable<? extends CharSequence> lines, Writer out) throws IOException {
    // separator wierszy dla danej platformy systemowej:
    String lf = System.getProperty("line.separator");
    for (CharSequence seq : lines) {
        out.append(seq);
        out.write(lf);
    }
    out.flush();
}
```

Wykorzystanie metody copy (biedna wersja):
```
FileInputStream in = null; // plik wejściowy
FileOutputStream out = null; // plik wyjściowy
// ...
try {
    in = new FileInputStream("in1");
    out = new FileOutputStream("out1", true);
    Stream.copy(in, out); // skopiowanie pliku "in1" do "out1"
} catch (IOException exc) { // brak pliku lub błąd wejścia-wyjścia
    System.err.println("I/O error: " + exc);
    return;
} finally {
    try {
        if (in != null) in.close();
        if (out != null) out.close();
    } catch (IOException exc) {
        System.out.println(exc.toString());
    }
}
```


Wykorzystanie metody copy (wersja na wypasie z try-with-resources):
```
try (FileInputStream in = new FileInputStream("in1");
FileOutputStream out = new FileOutputStream("out1", true)) {
    Stream.copy(in, out); // skopiowanie pliku in1 do ut1
} catch (IOException exc) { // brak pliku lub błąd wejścia-wyjścia
    System.err.println("I/O error: " + exc);
    return;
}
```

Wykorzystanie metody writeLines (try-with-resources):
```
try (FileWriter out = new FileWriter("out2.txt")) {
    Stream.writeLines(Arrays.asList("a", "b", "c"), out);
}
```

## 11.3
Pamięć:

    Znakowe:
    CharArrayReader, CharArrayWriter
    StringReader, StringWriter

    Bajtowe:
    ByteArrayInputStream, ByteArrayOutputStream

Potok:
    Znakowe:
    PipedReader, PipedWriter

    Bajtowe:
    PipedInputStream, PipedOutputStream

Plik:
    Znakowe:
    FileReader, FileWriter

    Bajtowe:
    FileInputStream, FileOutputStream


```
public static void removeWhitespaces(Reader in, Writer out) throws IOException {
int i;
    while ((i = in.read()) != -1) {
        char c = (char) i;
        if (!Character.isWhitespace(c)) out.write(c);
    }
}
```


```
    String in = "a b c\n d";
    StringWriter out = new StringWriter();
    StringReader reader = new StringReader(in);
    Ch11_11_05_RemoveWhite.removeWhitespaces(reader, out);
    String res = out.toString();
```

```
public static void increaseByteValues(InputStream in, OutputStream out) throws IOException {
    int i;
    while ((i = in.read()) != -1) {
        byte b = (byte) i;
        b++; // uwaga: dla b = 127, uzyskamy wartość -128
        out.write(b);
    }
}
```


```
    byte[] bin = { 1, 2, 3 };
    ByteArrayInputStream bis = new ByteArrayInputStream(bin);
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    Ch11_11_05_IncreaseByOne.increaseByteValues(bis, bos);
    byte[] bout = bos.toByteArray();
```

## 11.4 try-with-resources
W nawiasy try-with-resources można wrzucic klasy implementujące interface AutoCloseable, np.:

```
public class Resource implements AutoCloseable {
    public Resource() {
        open();
        // dalsze działania inicjujące
    }

    private void open() {
        // operacje związane z otwarciem zasobu
        closed = false;
    }

    // ... inne metody działające na zasobie
    @Override
    public void close() throws Exception {
        // jakieś operacje porządkujące, ewentualnie przy niepowodzeniu zgłaszające wyjątek
    }
}
```
Wykorzystanie:

```
try (Resource r = new Resource(); ) {
    // zasób otwarty
    // operacje na zasobie
} catch(Exception exc) {
    // reakcja na powstałe wyjątki
}
// zasób zamknięty (o ile metoda close zakończyła działanie bez błędu)
```

W javie 9 w nawiasach try-with-resources można podawać zmienne efektywnie finalne:
```
BulkTextFilesAppender appender = new BulkTextFilesAppender(fnames);
try(appender) {
    ...
}
```

## 11.6 Buforowanie

```
FileReader fr = new FileReader("plik.txt");
BufferedReader br = new BufferedReader(fr);
String line;
while ((line = br.readLine()) != null) { // readLine zwraca wiersz lub null, jeśli koniec pliku
}
```

#ch12
##FutureTask
class FutureFib extends FutureTask<Long>{
    ...
    public FutureFib(Callable<Long> proc) {
        super(proc);
        ...
    }
    ...
    protected void done() {

    }
}

exec.execute( new FutureFib (new FibCall(n)));

##CompletionService
ExecutorService executorService = Executors.newCachedThreadPool();
CompletionService<Long> completionService = new ExecutorCompletionService<Long>(executorService);
Integer[] params = {10,20,40};
for(Integer param : params){
    completionService.submit(new FibCall(param));
}
Future<Long> future;
Long result;
for(int i = 0; i < params.length; i++){
    future = completionService.take();
    result = future.get();
}