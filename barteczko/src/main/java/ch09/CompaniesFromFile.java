package ch09;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class CompaniesFromFile{

    private String s;

    public CompaniesFromFile(String s){
        this.s = s;
    }

    public File getFile(String filePath){
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(filePath);
        File file = new File(url.getFile());
        return file;
    }

    public Stream<String> getStreamFromFile(String filePath){
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(filePath);
        Path paths = null;
        Stream<String> stream = null;
        try {
            paths = Paths.get(url.toURI());
            stream = Files.lines(paths);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

    public Scanner getScanner(File file){
        try {
            System.out.println(file);
            return new Scanner(file);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public void readLinesFromStream(Stream<String> stream){
        //TODO - jak uzupełnić mapę?
        stream.forEach(
                e -> {
                    System.out.println(e);
                }
        );

    }

    public void readLinesFromScanner(Scanner scanner){
        String name;
        String address;
        Map<String,String> map = new HashMap<>();
        while(scanner.hasNextLine()){
            name = scanner.nextLine();
            System.out.println(name);
            address = scanner.nextLine();
            System.out.println(address);
            map.put(name,address);
        }

        map.forEach( (key,val) -> System.out.println("\n Key:"+key+";\n Val:"+val) );
        System.out.println();
    }

    public void readLinesFromScannerWithExceptionHandler(Scanner scanner,String exceptionMsg){
        try {
            readLinesFromScanner(scanner);
        }catch(NullPointerException e){
            System.out.println("scanner - null pointer exception");
            System.out.println(e);
        }
    }


    public void test(){
//        Scanner scanner = getScanner(new File("C:/Users/kkolcz/IdeaProjects/java/barteczko/src/main/resources/bla.txt"));
        Scanner scanner01 = getScanner(getFile(this.s));
//        readLinesFromScannerWithExceptionHandler(scanner,"scanner - null pointer exception");
        readLinesFromScannerWithExceptionHandler(scanner01,"scanner01 - null pointer exception");
        System.out.println("-----------stream-----------");
        Stream<String> stream = getStreamFromFile(this.s);
        readLinesFromStream(stream);
    }

    public static void main(String[] args) throws IOException{
//            String s = "/resources/bla.txt";
        String s = "bla.txt";
        CompaniesFromFile c = new CompaniesFromFile(s);
        c.test();
    }

}
