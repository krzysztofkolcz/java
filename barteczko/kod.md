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


#ch09
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