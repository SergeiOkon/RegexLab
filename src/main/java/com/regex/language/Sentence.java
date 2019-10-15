package com.regex.language;

public class Sentence {
    private String sentence;

    public Sentence(String sentence){
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return sentence;
    }
}
