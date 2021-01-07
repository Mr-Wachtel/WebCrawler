package WebCrawlerFX;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class WhatHappens extends WebCrawler {


    // show the link of website
    public static void links() throws IOException {

    Elements links = WebCrawler.getHtml().select("a[href]");
        for (Element e : links)

    {
        System.out.println("link : " + e.attr("href"));
    }

}

    // Überschrift der durchsuchten Webseite
    public static String websideName() throws IOException {
        String title = WebCrawler.getHtml().title();
        return title;

    }
}