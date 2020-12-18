import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class WebCrawler {
    public WebCrawler() throws IOException {
    }
    public static void main(String[] args) throws IOException {


        Document doc = Jsoup.connect("http://orf.at").userAgent("Mozilla").get();
        String title = doc.title();
        Elements headline = doc.select("div.oon");

        System.out.print(doc);


    }
}