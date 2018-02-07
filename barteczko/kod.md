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