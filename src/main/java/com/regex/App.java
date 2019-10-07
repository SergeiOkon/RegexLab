package com.regex;

import com.regex.service.ParseService;
import com.regex.service.UserIOService;

public class App {

    public static void main(String[] args) {
        runApp();
    }

    public static void runApp() {
        UserIOService userIOService = new UserIOService();
        ParseService parseService = new ParseService();


        parseService.parseWholeText();
        userIOService.showTextWithDeletedWordsWithConsonantAndLength();
    }
}

//"D:/_JAVA/EPAM/RegexLab/src/main/resources/Book.txt"
