package com.regex.service;

import com.regex.repo.SentenceRepo;
import com.regex.repo.WordRepo;

import java.text.BreakIterator;
import java.util.Locale;

public class ParseService {
    private BookService bookService = new BookService();

    public void parseWholeText() {
        String text = bookService.getBookText();
        parseSentence(text);
        parseWord();
    }

    private void parseSentence(String text) {
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.ENGLISH);
        iterator.setText(text);
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            SentenceRepo.getSentenceRepo().add(text.substring(start, end));
        }
    }

    private void parseWord() {
        for (int i = 0; i < SentenceRepo.getSentenceRepo().getSentenceList().size(); i++) {
            SentenceRepo.getSentenceRepo().getSentenceList().get(i);
            String[] Res = SentenceRepo.getSentenceRepo().getSentenceList().get(i).toString().split("\\W+");
            for (String word : Res) {
                WordRepo.getWordRepo().add(word);
            }
        }
    }
}
