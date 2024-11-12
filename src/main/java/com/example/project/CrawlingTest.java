package com.example.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class CrawlingTest {

    Document doc = Jsoup.connect("").get();

    public CrawlingTest() throws IOException {
    }
}
