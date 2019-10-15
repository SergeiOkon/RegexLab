package com.regex.repo;

import com.regex.language.Sentence;

import java.util.ArrayList;
import java.util.List;

public class SentenceRepo {
    private List<Sentence> sentenceList = new ArrayList<>();
    private static SentenceRepo sentenceRepo = null;

    public void add(String sentence) {
        sentenceList.add(new Sentence(sentence));
    }

    private SentenceRepo() {

    }

    public static SentenceRepo getSentenceRepo() {
        if (sentenceRepo == null) {
            sentenceRepo = new SentenceRepo();
        }
        return sentenceRepo;
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }

    public void setSentenceList(List<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }
}