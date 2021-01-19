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
    public static ArrayList<String> links() throws IOException {
        ArrayList<String> linksArrayList = new ArrayList<>();

        Elements links = WebCrawler.getHtml().select("a[href]");
        for (Element e : links) {
            if (!e.toString().contains("#")){
                String g = e.attr("href").toString();
                if(!g.equals("https://orf.at/")){
                    linksArrayList.add(g);
        }}}
        return linksArrayList;
    }



    // Überschrift der durchsuchten Webseite
    public static String websideName() throws IOException {
        String title = "https://"+ WebCrawler.getHtml().title();
        return title;

    }
}