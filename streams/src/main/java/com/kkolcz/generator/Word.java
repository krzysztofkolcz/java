package com.kkolcz.generator;

/**
 * Created by kkolcz on 03/10/17.
 */
public class Word {
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Word(){
        this.word = "aaa";
    }

    public int getSize(){
        return this.word.length();
    }

    public String toString(){
        return this.word;
    }
}
