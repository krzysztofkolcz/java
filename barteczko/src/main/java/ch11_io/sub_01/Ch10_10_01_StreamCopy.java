package ch11_io.sub_01;

import java.io.*;

public class Ch10_10_01_StreamCopy {

    static public int BUFLEN = 4096;

    static void copy(InputStream in, OutputStream out) throws IOException {
        int c;
        while ((c = in.read()) != -1) out.write(c);
        out.flush();
    }

    static void copy(Reader in, Writer out) throws IOException {
        int c;
        while ((c = in.read()) != -1) out.write(c);
        out.flush();
    }

    public static void copyWithBuffer(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[BUFLEN];
        int readLen;
        while ((readLen = in.read(buffer)) != -1) out.write(buffer, 0, readLen);
        out.flush();
    }
    public static void copyWithBuffer(Reader in, Writer out) throws IOException {
        char[] buffer = new char[BUFLEN];
        int readLen;
        while ((readLen = in.read(buffer)) != -1) out.write(buffer, 0, readLen);
        out.flush();
    }
}
