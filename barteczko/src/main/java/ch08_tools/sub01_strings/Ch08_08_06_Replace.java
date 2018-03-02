package ch08_tools.sub01_strings;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ch08_08_06_Replace {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("ch08_08_06_replace_input.txt");
        Charset cs = Charset.defaultCharset();
        List<String> lines = Files.readAllLines(Paths.get("test1.txt"), cs);
    }


}
