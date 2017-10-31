package ch12.cyclicBarier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {
        String[] words = "to jest tylko prezentacja barier cyklicznych".split("\\s+");
        List<List<String>> wordsCharsList = new ArrayList<>(); // lista list liter
        Runnable barrierAction = () -> { // akcja wykonywana po przejściu bariery
            System.out.print("All ready.\nJoined result: ");
            wordsCharsList.forEach( list-> System.out.print(String.join("", list) + " "));
            System.out.println();
        };
        CyclicBarrier b = new CyclicBarrier(words.length, barrierAction);
        for (String w : words) {
            List<String> word = new ArrayList<>(); // word jest listą liter słowa
            for (char c : w.toCharArray()) word.add(""+c);
            wordsCharsList.add(word);
            new Thread(new ReverseWord(word, b)).start();
        }
    }

}