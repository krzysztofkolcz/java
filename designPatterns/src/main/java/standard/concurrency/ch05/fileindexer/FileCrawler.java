package standard.concurrency.ch05.fileindexer;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

public class FileCrawler implements Runnable {
    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;
    private final FileIndex fileIndex;

    public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root, FileIndex fileIndex) {
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root;
        this.fileIndex = fileIndex;
    }

    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] entries = root.listFiles(fileFilter);
        if (entries != null) {
            for (File entry : entries)
                if (entry.isDirectory())
                    crawl(entry);
                else if (!alreadyIndexed(entry))
                    fileQueue.put(entry);
        }
    }

    private boolean alreadyIndexed(File entry){
        return fileIndex.alreadyIndexed(entry.getPath());
    }
}
