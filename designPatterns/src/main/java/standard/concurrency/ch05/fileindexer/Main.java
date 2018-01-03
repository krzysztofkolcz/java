package standard.concurrency.ch05.fileindexer;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static final int N_CONSUMERS = 3;
    public static final int BOUND = 10;

    public static void main(String[] args) {
        File[] files = new File[1];
        files[0] = new File("C:\\Users\\kkolcz");
        startIndexing(files);
    }

    public static void startIndexing(File[] roots) {
        FileIndex fileIndex = new FileIndex();
        BlockingQueue<File> queue = new LinkedBlockingQueue<File>(BOUND);
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) { return true; }
        };
        for (File root : roots)
            new Thread(new FileCrawler(queue, filter, root, fileIndex)).start();
        for (int i = 0; i < N_CONSUMERS; i++)
            new Thread(new Indexer(queue, fileIndex)).start();
    }
}
