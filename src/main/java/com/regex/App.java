package com.regex;

import com.regex.service.BookService;

public class App {
    public static void main(String[] args) {
        runApp();
    }

    static void runApp() {
        System.out.println("Type count of letters in words that start with consonant you want to delete:");
        BookService.showDeleteByLengthWithConsonants();
    }

}