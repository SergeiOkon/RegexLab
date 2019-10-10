package com.regex.service;

import com.regex.language.Sentence;
import com.regex.repo.SentenceRepo;

import java.util.List;
import java.util.stream.Collectors;

public class ModifyBookService {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public List<Sentence> deleteWordsWithConsonantAndLength(int wordLength) {
        return getSentenceListFromRepo().stream()
                .map(sentence -> toDeletedSentence(sentence, wordLength))
                .collect(Collectors.toList());
    }

    private Sentence toDeletedSentence(Sentence sentence, int wordLength) {
        return new Sentence(sentence.toString().replaceAll("(?i)\\b[b-df-hj-np-tv-z]\\w{" + (wordLength - 1) + "}\\b", ANSI_RED + "-" + ANSI_RESET));
    }

    private List<Sentence> getSentenceListFromRepo(){
        return SentenceRepo.getSentenceRepo().getSentenceList();
    }
}