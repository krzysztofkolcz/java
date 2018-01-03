package standard.concurrency.ch05.fileindexer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/*
Kilka sposobów:
1. bez synchronizacji - bo tylko dodawanie
2. każdy wątek ma swoją kolekcję zaindeksowanych plików
- ale wtedy prawdzenie musi być we wszystkich wątkach,
czy plik już nie zaindeksowany
3. wykorzystanie synchronizowanej kolekcij, zamiast synchronizowania metod dostępu
4. synchronizowanie metod dostępu
 */

public class FileIndex {

    static List<Class<?>> classList = new LinkedList(){{add(String.class);}};
    ArrayList<String> list = new ArrayList<>();
    /* lub */
    List<Object> syncList = Collections.synchronizedList(new ArrayList<>());


    public synchronized boolean alreadyIndexed(String path){
        return list.contains(path);
    }

    public synchronized void indexFile(String path){
        list.add(path);
    }

    public static void test(){
//        Class<?>[] array = classList.toArray(new Class<?>[classList.size()]);
        Class<?>[] array = getList().toArray(new Class<?>[classList.size()]);
    }

    public static void main(String[] args) {
        FileIndex.test();
    }

    public static List<Class> getList(){
        return null;
    }
}
