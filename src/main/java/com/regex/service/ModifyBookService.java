package com.regex.service;

import com.regex.language.Sentence;
import com.regex.repo.SentenceRepo;

import java.util.ArrayList;
import java.util.List;

public class ModifyBookService {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public List<Sentence> deleteWordsWithConsonantAndLength(int wordLength) {
        List<Sentence> deletedWordsSentences = new ArrayList<>();
        for (int i = 0; i < SentenceRepo.getSentenceRepo().getSentenceList().size(); i++) {
            deletedWordsSentences.add(new Sentence(SentenceRepo.getSentenceRepo().getSentenceList().get(i).toString().replaceAll("(?i)\\b[b-df-hj-np-tv-z]\\w{" + (wordLength - 1) + "}\\b", ANSI_RED + "-" + ANSI_RESET)));
        }
        return deletedWordsSentences;
    }
}