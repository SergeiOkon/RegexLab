package com.regex.service;

public class FilterService {
    int userWordLength;
    final String regex = "\\b(\\w+)\\b\\s*(?=.*\\b\\1\\b)";
    final String bookText = "Goodbye bye bye world world world\n";
    private String result;

    private void deleteFromText(int wordLength) {
        result = bookText.replaceAll(regex, "");
    }
    public void deleteWordsStartedWith
}