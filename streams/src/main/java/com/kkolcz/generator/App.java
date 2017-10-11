package com.kkolcz.generator;

import java.util.stream.Stream;

/**
 * Created by kkolcz on 03/10/17.
 */
public class App {

  public static void main(String[] args) {
    Stream.generate(Word::new).limit(20).forEach(System.out::println);
  }
}
