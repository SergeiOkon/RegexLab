package com.regex.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class BookService {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static String bookText;
    private static int wordLength;
    private static Scanner scanner = new Scanner(System.in);

    public static void setBook(String path) {
        try {
            bookText = new String(Files.readAllBytes(Paths.get(path)), "UTF-8");
        } catch (IOException e) {

        }
    }

    private static void scanUserWordLength() {
        try {
            wordLength = Integer.parseInt(scanner.nextLine());
            if (wordLength < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again:");
            deleteByLengthWithConsonants();
        }
    }

    public static void deleteByLengthWithConsonants() {
        scanUserWordLength();
        System.out.println(bookText.replaceAll("(?i)\\b[b-df-hj-np-tv-z]\\w{" + (wordLength - 1) + "}\\b", ANSI_RED + "-" + ANSI_RESET));
    }
}