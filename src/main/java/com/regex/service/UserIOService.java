package com.regex.service;

import com.regex.App;
import com.regex.language.Sentence;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserIOService {
    private static String path;

    private static Scanner scanner = new Scanner(System.in);
    private ModifyBookService modifyBookService = new ModifyBookService();

    public String scanBookPath(){
        System.out.println("Insert book path:");
        path = scanner.nextLine();
        try {
            if(!new File(path).isFile()){
                throw new IOException();
            }
        } catch (IOException e){
            scanBookPath();
        }
        return path;
    }

    private int scanUserWordLength() {
        int wordLength = 0;

        System.out.println("Type count of letters in words that start with consonant you want to delete:");
        try {
            wordLength = Integer.parseInt(scanner.nextLine());
            if (wordLength < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again:");
            scanUserWordLength();
        }
        return wordLength;
    }

    public void showTextWithDeletedWordsWithConsonantAndLength(){
        int wordLength = scanUserWordLength();
        List<Sentence> newText = modifyBookService.deleteWordsWithConsonantAndLength(wordLength);
        showMakeUpText(newText);
    }

    private void showMakeUpText(List<Sentence> sentences){
        for (int i = 0; i < sentences.size(); i++) {
            System.out.print(sentences.get(i));
        }
    }
}