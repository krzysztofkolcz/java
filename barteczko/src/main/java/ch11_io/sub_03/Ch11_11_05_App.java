package ch11_io.sub_03;

import java.io.*;
import java.util.Arrays;

public class Ch11_11_05_App {

    public static void main(String[] args) throws IOException {
        String in = "a b c\n d";
        StringWriter out = new StringWriter();
        StringReader reader = new StringReader(in);
        Ch11_11_05_RemoveWhite.removeWhitespaces(reader, out);
        String res = out.toString();

        System.out.println("Len: " + res.length());
        System.out.println(res);
        System.out.println("-----------");

        byte[] bin = { 1, 2, 3 };
        ByteArrayInputStream bis = new ByteArrayInputStream(bin);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Ch11_11_05_IncreaseByOne.increaseByteValues(bis, bos);
        byte[] bout = bos.toByteArray();
        System.out.println(Arrays.toString(bout));
    }
}
