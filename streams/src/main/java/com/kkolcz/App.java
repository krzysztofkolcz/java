package com.kkolcz;

import java.io.*;
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.net.URISyntaxException;

public class App {
    public static void main( String[] args ) throws IOException, URISyntaxException{
        System.out.println( "hello world!" );
        Path p = Paths.get(ClassLoader.getSystemResource("countryInfo.txt").toURI());
        Stream<String> ls = Files.lines(p);
        ls.close();
        /* ls.forEach(System::out::println); */
        Optional<String> optional = ls.findFirst();
        String line = optional.orElse("null");
        System.out.println(line);
        /* List<Country> clist = ls.map(Country::new).collect(Collectors.toList()); */

    }
}
