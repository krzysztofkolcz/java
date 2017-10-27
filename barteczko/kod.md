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