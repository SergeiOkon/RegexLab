package com.regex.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BookService {
    private String bookText = null;
    UserIOService userIOService = new UserIOService();

    public String setBook(String path) {
        try {
            bookText = new String(Files.readAllBytes(Paths.get(path)), "UTF-8");
        } catch (IOException e) {
            System.out.println("Invalid path!");
        }
        return bookText;
    }


    public String getBookText() {
        if(bookText == null){
            String bookPath = userIOService.scanBookPath();

            setBook(bookPath);
        }
        return bookText;
    }

}
