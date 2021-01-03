import com.sun.tools.javac.Main;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebCrawler {

    // HTML der Webseite holen und in Document doc speichern
    public static Document getHtml() throws IOException {
        Document doc = Jsoup.connect("https://orf.at/").userAgent("Mozilla").get();
        return doc;
    }

    public static void main(String[] args) throws IOException {


        Sandra.websideName();
        Sandra.headlines();
        Sandra.headlinesApp();
        Sandra.breakingNews();
        Sandra.giveMeBackwards(Sandra.headlines());

        //System.out.println(getHtml());































     //   System.out.println(getHtml());

        Mary.TitleandWebsite();
        Mary.getIcon();
        Mary.getAllLinks();
        Mary.COVAusland();







































































        // Start - PHIL


    }
}