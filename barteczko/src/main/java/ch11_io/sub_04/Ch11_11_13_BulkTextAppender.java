package ch11_io.sub_04;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ch11_11_13_BulkTextAppender implements AutoCloseable{

    List<FileWriter> fileStreamsToAppend;
    List<String> filesToAppend;
    List<String> filesSuccessfullyAppended;
    String textToAppend;
    boolean allAppended;

    public Ch11_11_13_BulkTextAppender(List<String> fileNames) throws IOException {
        filesToAppend = new ArrayList<>(fileNames);
        filesSuccessfullyAppended = new ArrayList<>();
        fileStreamsToAppend = new ArrayList<>();
        for(String name : filesToAppend){
            fileStreamsToAppend.add(new FileWriter(name,true));
        }
    }

    /*
    public Ch11_11_13_BulkTextAppender(String... fileNames) throws IOException{
        this.textToAppend = textToAppend;
        filesSuccessfullyAppended = new ArrayList<>();
        filesToAppend = Arrays.asList(fileNames);
        for(String name : filesToAppend){
            fileStreamsToAppend.add(new FileWriter(name,true));
        }
    }
    */

    public void append(CharSequence sequence) throws IOException{
        int i = -1;
        for(FileWriter fileWriter : fileStreamsToAppend){
            i++;
            try{
                fileWriter.append(sequence);
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException(e.getMessage() + " - file " + filesToAppend.get(i));
            }
            //TODO - wolałbym zrobić zamiast tego hashMapę <String,FileWriter> - fileName,fileWriter
            filesSuccessfullyAppended.add( filesToAppend.get(i)); // na listę nazw plików z dopisanym tekstem
        }
        allAppended = true;
    }

    // Lista nazw plików, do których dopisanie się nie udało
    public List<String> getNamesOfUnappendedFiles() {
        filesToAppend.removeAll(filesSuccessfullyAppended);
        return filesToAppend;
    }
    // Czy tekst został dopisany do wszystkich plików
    public boolean isAllAppended() {
        return allAppended;
    }

    public CharSequence getTextToAppend() {
        return textToAppend;
    }

    @Override
    public void close() throws Exception {
        List<String> unclosed = new ArrayList<>(); // lista nazw niezamkniętych plików
        int i = -1;
        for (FileWriter fileWriter : fileStreamsToAppend){
            i++;
            try {
                fileWriter.close();
            } catch (Exception exc) {
                unclosed.add(filesToAppend.get(i)); // błąd przy zamknięciu - dodajemy do listy niezamkniętych
            }
        }
        if (!unclosed.isEmpty()) throw new IOException("Unclosed files:" + unclosed);
    }
}
