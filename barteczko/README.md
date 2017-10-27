ch09

Zadanko:
LongestLineInFile - odnalezienie listy najdłuższych linii w pliku.

Zadanko:
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