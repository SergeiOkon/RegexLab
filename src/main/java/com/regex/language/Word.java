package com.regex.language;

import com.regex.service.BookService;

public class Word implements regexParsable {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private int wordLength;

    @Override
    public String parseByRegex(String text) {
        return text.replaceAll("(?i)\\b[b-df-hj-np-tv-z]\\w{" + (wordLength - 1) + "}\\b", ANSI_RED + "-" + ANSI_RESET);
    }

    public void setWordLengthForRegex() {
        wordLength = BookService.scanUserWordLength();
    }
    public String parseWordsByRegex(){
        String book = BookService.setBook("C:/Users/BOSSJNR/IdeaProjects/RegexLab/src/main/resources/Book.txt");
        setWordLengthForRegex();
        return parseByRegex(book);
    }
}