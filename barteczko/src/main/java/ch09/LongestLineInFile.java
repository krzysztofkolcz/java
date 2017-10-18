package ch09;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kkolcz on 10/10/17.
 */
public class LongestLineInFile {

    public static void main(String[] args) {
        LongestLineInFile llif = new LongestLineInFile();
        File f = llif.getFile("tekst.txt");
        List<String> lines = llif.getLinesFromFile(f);
        List<String> longest = llif.getLongestLinesFromFile(lines);
        longest.stream().forEach(System.out::println);
    }

    public File getFile(String name){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(name).getFile());
        return file;
    }

    public List<String> getLinesFromFile(File file){
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> getLongestLinesFromFile(List<String> lines){
        List<String> result = new ArrayList<>();
        int longestLineSize = 0;
        for(String line : lines) {
            if(line.length() > longestLineSize){
                result.clear();
                result.add(line);
                longestLineSize = line.length();
            }else if(line.length() == longestLineSize){
                result.add(line);
            }
        }
        return result;
    }
}
