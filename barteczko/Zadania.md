#ch09

## Zadanie ch09_95:
TODO ch09/CompaniesFromFile
Pobrać z pliku listę firm.
a) pokazać listę nazw firm
b) listę nazw firm bez duplikatów (zbiór)
c) zbiór nazw firm w porządku występowania
d) zbiór nazw firm w porządku alfabetycznym

### Help 01

#### Pobranie Scannera z pliku ścieżka bezwzględna:
Scanner s = new Scanner(new File(filePath);//filePath == "C:/..."

#### Pobranie Scannera z pliku, gdy plik znajduje się w katalogu:
src/main/resources/plik.txt
public File getFile(String filePath){
    ClassLoader classLoader = getClass().getClassLoader();
    URL url = classLoader.getResource(filePath);
    File file = new File(url.getFile());
    return file;
}
Scanner scanner = new Scanner(getFile("plik.txt"))

#### Iteracja po scannerze:

For(scanner; scanner.hasNextLine() ; ) {
	list.add(s.nextLine());
}

#### Pobranie streama
public Stream<String> getFile(String filePath) throws ...{
    ClassLoader classLoader = getClass().getClassLoader();
    URL url = classLoader.getResource(filePath);
    Path paths = Paths.get(url.toURI());
    Stream<String> stream = Files.lines(paths);
    return stream;
}

### Odp.
a) List<Company> list = …
b) Set<Company> set = new HashSet<>(list); //zbiór
c) Set<Company> lhset = new LinkedHashSet<>(list); //porządek występowania, ale zbiór
d) Set<Company> tset = new TreeSet<>(list) //porządek alfabetyczny – todo comparator

## Zadanko ch09_97:
odnalezienie listy najdłuższych linii w pliku.
ch09/longestLineInFile/LongestLineInFile
ch09/longestLineInFile/LongestLineInFile01
ch09/longestLineInFile/LongestLineInFileStreams02

## Zadanko ch09_971
Metoda usuwająca z kolekcji elementy większe od podanego (z wykorzystaniem iteratora, oraz gotowej metody collections)
ch09/iterators/RemoveGreater
ch09/iterators/RemoveGreater01


## Zadanko ch09_972
Usuwaj elementy ze zbioru, dopóki suma elementów pozostałych w zbiorze jest większa od zadanego X.
Nie da się tego zrobić za pomocą interfaceów funkcyjnych.

## Zadanko ch09_973 (mój pomysł)
Dany zbiór elementów, oraz zadane X.
Znajdź podzbiór zadanego zbioru, którego suma będzie najbliższa X lecz od niego mniejsza lub równa.

## Zadanko ch09_99
Input - lista
output - lista, pierwszy element sumą dwóch pierwszych elementów inputu, pozostałe elementy zwiększone o 1

### hint 01
forEachRemaining

## Zadanko ch09_120
Lista Customer, z metodą setBonus.
pierwszym dwóm - bonus 500zł, reszcie 200zł

### hint 01
spliterator


### Kod pigułka
#### Splitearator
List<Customer> list = ...
Spliterator<Customer> spliter = list.spliterator();
spliter.tryAdvance( e -> ... );
spliter.forEachRemaining( e -> ...);

## Zadanko ch09_140:
SplitAndParallelProcess - dana jest lista wyrazów. podwoić każdą literkę w wyrazie (np. "kot" -> "kkoott")
Zrobić to sekwencyjnie, oraz równolegle. Wykorzysatć spliterator.

## Zadanko ch09_9_17:
ch09/Ch09_9_17_MeasureListAccess - implementacja z książki
ch09/Ch09_9_17_MeasureListAccess_01 - moja implementacja (średnia)

wykonać następujące operacje:
 1. edycji elementu na losowej pozycji listy
 2. wstawianie elementu za nieparzystym elementem
 3. wstawienie elementu na koniec listy

Operacje wykonać X razy oraz zmierzyć średni czas wykonania

jako parametry:
- liczba elementów tablicy
- liczba wykonywanych operacji
- czy wykonywać kopię LinkedList do ArrayList

### hint 01
Operacje przekazywać jako Consumer

### hint 02
Pomiar czasu:
long start = System.currentTimeMillis();
long time = System.currentTimeMillis() - start;


9.8.4 Lists Operations

## Zadanko Ch09_9_21B:
TODO - brak implementacji - Ch09_9_21B_FindSublistBetweenFirstAndLastOccurence

napisać metodę zwracającą podlistę znajdującą się pomiędzy pierwszym i ostatnim wystąpieniem danego elementu.
indexOf, lastIndexOf i subList

## Zadanko Ch09_9_21C_ReplaceWithSqrt:
TODO - brak implementacji Ch09_9_21C_ReplaceWithSqrt
Zastąpić wszystkie liczby ich kwadratami

## Zadanie Ch09_9_21D:
ch09/Ch09_9_21D_ListIterPutHalfBefore
na liście liczb całkowitych przed każdą parzystą liczbą należy wpisać jej połówkę
ListIterator

## Zadanie Ch09_9_23:
TODO - Ch09_9_23_MeasureListSearch
Zmierzyć czas wyszukiwania elementu dla:
- oryginalnej nieposortowanej listy - ArrayList lub LinkedList metodą contains()
- binarne wyszukiwanie na posortowanej kopii listy
- contains() na kopii HashSet

element wyszukiwany pobieram z kolekcji z miejsca (N - wielkość kolekcji):
początku - 0
pierwszej 1/3 - N/3
połowy - 1/2 - N/2
3/4 - 3*N/4
końca - N
nieistniejący

### hint 01
Sortowanie (działa na referencji):
Collections.sort(sorted);

### hint 02
Wyszukiwanie Binarne:
Collections.binarySearch(sorted, n)

## TODO - zadania dotyczące LinkedList jako kolejki, ArrayDeque oraz PriorityQueue
### info, kod, pigułka, teoria:
ArrayDeque:
deq.add; deq.peek - działa jak kolejka FIFO
deq.addFirst; deq.peek - działa jak kolejka LIFO (stos)

9.11

## Zadanie Ch09_9_28:
TODO - Ch09_9_29_EmployeeComparators
Klasa Employee z polami firstName, lastName, salary,
Zdefiniować natralny porządek sortowania wg lastName, następnie firstName
Posortować dla kilku objektów
Posortować tą samą klasę po pensji dla kilu obiektów
Posortować w odwróconym porządku


### hint 01
class Employee implements Comparable<Employee>{
    @Overrides
    public int compareTo(Employe obj){
    ...
    }
}

### hint 02
Collections.sort(elist, new Comparator<Employee>() {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getSalary() - e2.getSalary();
    }
});

Lub
Collections.sort ( elist, (e1, e2) -> e1.getSalary() - e2.getSalary() );
W javie 8 interface List ma dodatkową metodę sort:
elist.sort( (e1, e2) -> e1.getSalary() - e2.getSalary() );

### hint 03
Collections.sort(elist, Collections.reverseOrder());

### hint 04
Przykłady zdefiniowania komparatorów:

Comparator.naturalOrder();
Comparator.reverseOrder();

Comparator<Employee> comp; // na tej zmiennej zapiszemy komparator do odwrócenia
comp = (e1, e2) -> e1.getSalary() - e2.getSalary();
comp.reversed(); // w odwrotnym porządku pensji

## Klasa Ch09_9_31_KeySetValuesEntrySet:
ilustracja działania na widokach uzyskanych z mapy

## Zadanie:
WordFrequency01
program obliczający częstotliwość występowania słow w pliku.

## Zadanie Ch09_9_38
ch09.sub_13_maps.Ch09_9_38_MapSortByValue
Posortować mapę wg. wartości.

### hint 01
Wskazówka - wykorzystać listę Entry.

### hint 02
Sortowanie map uwzględniające inne kryteria niż porządek kluczy powinno być realizowane
jako sortowanie listy tworzonej z widoku wejść mapy typu LinkedHashMap
z następującym zastąpieniem dotychczasowych wejść w mapie – posortowanymi.


#ch10
## Zadanie ch10_10_2
Wczytać plik countryInfo.txt, za pomocą strumienia uzyskać listę krajów.
-odnaleźć pierwszy kraj w strumieniu z nazwą na literę 'B'
-posortować kraje wg. wielkości powierzchni. Wypisać 5 z najmniejszą powierzchnią

-moje zadanko - utworzyć mapę Map<String,List<String>> - klucz - pierwsza litera, wartość - lista krajów zaczynająca
się na daną literę np:
A -> Australia, Austria...
B -> Bośnia, Bułgaria...

-wyświetlić kraj z największą powierzchnią
-utworzyć mapę - dla każdego kraju obliczyć liczbę mieszkańców jego sąsiadów

### hint 01
W klasie Country konstruktor parsuje linię i uzupełnia na jej podstawie atrybuty klasy.

Path p = Paths.get("nazwa_pliku");
Stream<String> ls = Files.lines(p);
ls.close();
List<Country> clist = ls.map(Country::new).collect(Collectors.toList());

### hint 02
jeżeli nie ma szukanego elementu w strumieniu (np. kraju na litere X)
wykorzystać konstrukcję:
Optional<String> first ...
String nazwa = first.orElse(...)

### hint 03
Przykłady map:
http://www.deadcoderising.com/2017-02-14-java-8-declarative-ways-of-modifying-a-map-using-compute-merge-and-replace/
Map<String,List<String>> dictionaryMap = new HashMap<>();
dictionaryMap.merge(
    firstLetter,
    Arrays.asList(countryName), //parametr - lista, którą chcę wrzucić jako parametr do poniższego argumentu.
                                //drugim argumentem jest lista znajdująca się w mapie.
    (list1,list2) -> Stream.of(list1, list2).flatMap(Collection::stream).sorted().collect(Collectors.toList())
);

Lub
Map<String,List<String>> dictionaryStringMap = new HashMap<>();
dictionaryStringMap = countryStream
    .map(c -> c.getName())
    .sorted()
    .collect(
        groupingBy(s -> s.substring(0,1))
    );

### hint 04
metody terminalne - min i max


## Zadanie ch10_10_my01
ch10_streams/my/Ch10_my01_WordCount
Obliczyć częstotliwość występowania słów w pliku

#ch11
## Zadanko metody kopiująca strumień z wejściowego do wyjściowego.
ch11_io.sub_01.Ch10_10_01_StreamCopy

#ch12

Zadanie:
Proste zadanie sumowania liczb całkowitych z podanego zakresu, np. sum(50,100), jako pętla.
(49 * 150 + 75, ale coś trzeba wymyślić). Można też sumować liczby z tablicy podanej jako parametr.
Wyświetlać wynik co 1000 liczb.
Uruchomić za pomocą egzekutora kilka takich zadań dla różnych parametrów.

Zadanko:
ch12.executors.FibCall*
Klasa FibCall - obliczająca ciąg fibonacciego.
Uruchomienie w kilku executorach dla kilku inputów.

Zadanko:
Funkcja ma odwracać napis i co 100ms wypisywać kolejną odwracaną literkę.
Callable jako lambda wyrażenie executor.submit().

Zadanko 12.16:
ch12.executors.FibCallCompletionService
Zlecić wykonanie i pobierać wyniki obliczeń ciągu fibonacciego w kolejności wykonania
Wykorzystanie CompletionService