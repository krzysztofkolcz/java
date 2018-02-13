package ch11_io.sub_03;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;

public class Ch11_11_05_RemoveWhite {

    public static void removeWhitespaces(Reader in, Writer out) throws IOException {
        int i;
        while ((i = in.read()) != -1) {
            char c = (char) i;
            if (!Character.isWhitespace(c)) out.write(c);
        }
    }

    //TODO
    public static void removeWhitespacesWithBuff(Reader in, Writer out) throws IOException {
        int i;
        char[] array = new char[1024];

        while ((i = in.read()) != -1) {
            char c = (char) i;
            if (!Character.isWhitespace(c)) out.write(c);
        }
    }
}
