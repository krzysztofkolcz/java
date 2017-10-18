package ch09;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Consumer;

/**
 * Created by kkolcz on 14/10/17.
 */
public class WordFrequency01 {

    private Map<String,Integer> wordCount;

    public static void main(String[] args) {
        WordFrequency01 wordFrequency01 = new WordFrequency01();
        File file = wordFrequency01.getFile("tekst02.txt");
        wordFrequency01.readLinesFromFileWithCallback(file);
        wordFrequency01.showWordCountMap();
    }

    public WordFrequency01() {
        this.wordCount = new TreeMap<>();
    }

    public File getFile(String name){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(name).getFile());
        return file;
    }

    public void readLinesFromFileWithCallback(File file){
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                countWords(line);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void countWords(String line){
        String[] words = line.split("[^a-zA-Zęóąśłżźćń]");
        Integer n ;
        for(String word : words){
            n = 1;
            if(wordCount.containsKey(word)) {
                n = wordCount.get(word) + 1;
            }
            wordCount.put(word,n);
        }
    }

    public void showWordCountMap(){
        wordCount.forEach((a,b) -> {System.out.print(a + ":" + b); System.out.println();});
    }
}
