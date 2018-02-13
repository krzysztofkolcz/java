package ch11_io.sub_03;

import ch11_io.sub_01.Ch11_11_01_StreamCopy;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

public class Ch11_11_4_FileCopy {

    @Test
    public void fileCopyTest(){
        FileInputStream in = null; // plik wejściowy
        FileOutputStream out = null; // plik wyjściowy
        try {
//            in = new FileInputStream("C:\\Users\\kkolcz\\IdeaProjects\\java\\barteczko\\src\\main\\resources\\bla.txt");
//            out = new FileOutputStream("C:\\Users\\kkolcz\\IdeaProjects\\java\\barteczko\\src\\main\\resources\\out1.txt", true);
            in = new FileInputStream("target/classes/tekst02.txt");
            out = new FileOutputStream("out2.txt", true);//zapis w roocie projektu
            Ch11_11_01_StreamCopy.copyWithBuffer(in,out);
        } catch (IOException exc) { // brak pliku lub błąd wejścia-wyjścia
            System.err.println("I/O error: " + exc);
            return;
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException exc) {
                System.out.println(exc.toString());
            }
        }
    }
}
