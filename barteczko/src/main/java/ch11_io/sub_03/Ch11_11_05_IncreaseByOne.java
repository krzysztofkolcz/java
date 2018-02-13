package ch11_io.sub_03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ch11_11_05_IncreaseByOne {

    public static void increaseByteValues(InputStream in, OutputStream out) throws IOException {
        int i;
        while ((i = in.read()) != -1) {
            byte b = (byte) i;
            b++; // uwaga: dla b = 127, uzyskamy wartość -128
            out.write(b);
        }
    }
}
