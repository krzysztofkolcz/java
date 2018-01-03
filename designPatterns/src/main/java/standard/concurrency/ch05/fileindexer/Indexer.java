package standard.concurrency.ch05.fileindexer;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class Indexer implements Runnable {

    private final BlockingQueue<File> queue;
    private final FileIndex fileIndex;

    public Indexer(BlockingQueue<File> queue, FileIndex fileIndex) {
        this.queue = queue;
        this.fileIndex = fileIndex;
    }
    public void run() {
        try {
            while (true)
                indexFile(queue.take());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void indexFile(File entry){
        System.out.println("Thread:"+this+" indexing:"+entry.getPath());
        fileIndex.indexFile(entry.getPath());
    }
}
