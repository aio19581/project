package com.example.project;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.lang.model.util.Elements;
import java.io.IOException;

public class CrawlingTest {

    Connection connection = Jsoup.connect("https://www.naver.com/");
    Document document;

    {
        try {
            document = connection.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Elements elements = (Elements) document.select("");


}
