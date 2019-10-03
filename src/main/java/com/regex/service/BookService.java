package com.regex.service;

import com.regex.language.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class BookService {
    private static String bookText;
    private static int wordLength;
    private static Scanner scanner = new Scanner(System.in);
    private static Word word = new Word();

    public static String setBook(String path) {
        try {
            bookText = new String(Files.readAllBytes(Paths.get(path)), "UTF-8");
        } catch (IOException e) {
            System.out.println("Invalid path!");
        }
        return bookText;
    }

    public static int scanUserWordLength() {
        try {
            wordLength = Integer.parseInt(scanner.nextLine());
            if (wordLength < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again:");
            showDeleteByLengthWithConsonants();
        }
        return wordLength;
    }

    public static void showDeleteByLengthWithConsonants() {
        System.out.println(word.parseWordsByRegex());
    }
}