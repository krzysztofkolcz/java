package ch09.longestLineInFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestLineInFile01 {

    public File getLocalFile(String fileName){
//        System.out.println(fileName);
       return new File(getClass().getClassLoader().getResource(fileName).getFile());
    }

    private Scanner getLocalScanner(File file){
        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<String> getLongestLines(File file){
        int longestLineLength = 0;
        List<String> longestLines = new ArrayList<>();
//        File file = getFile(fileName);
        Scanner scanner = getLocalScanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.length() > longestLineLength){
                longestLineLength = line.length();
                longestLines.clear();
                longestLines.add(line);
            }else if(line.length() == longestLineLength){
                longestLines.add(line);
            }
        }
        return longestLines;
    }

    public static void main(String[] args) {
        LongestLineInFile01 longestLineInFile01 = new LongestLineInFile01();
    }

}
