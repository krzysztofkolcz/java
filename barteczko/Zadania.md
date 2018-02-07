#ch09

## Zadanie ch09_95:
ch09/CompaniesFromFile
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

## Zadanko:
SplitAndParallelProcess - dana jest lista wyrazów. podwoić każdą literkę w wyrazie (np. "kot" -> "kkoott")
Zrobić to sekwencyjnie, oraz równolegle. Wykorzysatć spliterator.

Zadanko:
Lists - wykonać operacje:
 1. edycji elementu na losowej pozycji listy
 2. wstawianie elementu za nieparzystym elementem
 3. wstawienie elementu na koniec listy
jako parametr - liczba elementów tablicy, oraz liczba wykonywanych operacji.

Teoria:
Splitearator
List<Customer> list = ...
Spliterator<Customer> spliter = list.spliterator();
spliter.tryAdvance( e -> ... );
spliter.forEachRemaining( e -> ...);


Lists

Zadanko:
napisać metodę zwracającą polistę znajdującą się pomiędzy pierwszym i ostatnim wystąpieniem danego elementu.
indexOf, lastIndexOf i subList

Zadanko:
Zastąpić wszystkie liczby ich kwadratami

Zadanie:
ListIter02
na liście liczb całkowitych przed każdą parzystą liczbą należy wpisać jej połówkę
ListIterator


Zadanie:
WordFrequency01
program obliczający częstotliwość występowania słow w pliku.

Zadanie
MapSort01
Posortować mapę wg. wartości. Wskazówka - wykorzystać listę Entry.


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