package com.regex.repo;

import com.regex.language.Word;

import java.util.ArrayList;
import java.util.List;

public class WordRepo {
    private List<Word> wordList = new ArrayList<>();
    private static WordRepo wordRepo = null;

    public void add(String word) {
        wordList.add(new Word(word));
    }

    private WordRepo() {

    }

    public static WordRepo getWordRepo() {
        if (wordRepo == null) {
            wordRepo = new WordRepo();
        }
        return wordRepo;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }
}