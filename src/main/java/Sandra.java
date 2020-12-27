import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sandra extends WebCrawler {
    //Warum will er main Methode, wenn ich nicht extend schreibe?



   /* // HTML der Webseite holen und in Document doc  speichern
    public static Document getHtml() throws IOException {
        Document doc = Jsoup.connect("https://orf.at/").userAgent("Mozilla").get();
        return doc;
    }*/

    // Überschrift der durchsuchten Webseite
    public static void websideName() throws IOException {
        String title = getHtml().title();
        System.out.println("Die Überschrift der Website lautet: " + title);
        System.out.println();
    }

        // Headlines (der Appansicht)  als String - Liste
        // Headlines für die App Version sind im "oon-grid-texts-container-mobile" Absatz
    public static void headlinesApp() throws IOException {

        List<String> headlinesApp = new ArrayList<>();
        Elements appBig = getHtml().select("div.oon-grid-texts-container-mobile");
        for (Element e : appBig) {
            Elements h1 = e.select("h1");
            String stringH1 = h1.toString()
                    .replace("<h1> ", "")
                    .replace(" </h1>", "");
            headlinesApp.add(stringH1);

        }
        System.out.println("App Überschriften");
        for (String e : headlinesApp) {
            System.out.println(e);
            System.out.println();
        }
    }

        // Headlines (der Normalansicht)  als String - Liste
        // Headlines für die Normalansicht sind im "oon-grid-texts-container" Absatz

    public static void headlines() throws IOException {

        List<String> headlines = new ArrayList<>();
        Elements big = getHtml().select("div.oon-grid-texts-container");
        for (Element e : big) {
            String test = e.toString();
            if (!test.contains("-mobile")) {
                Elements h1 = e.select("h1");
                String stringH1 = h1.toString()
                        .replace("<h1> ", "")
                        .replace(" </h1>", "")
                        .replace("<br> ", "");

                headlines.add(stringH1);
            }
        }
        System.out.println("Normalansicht Überschriften");
        for (String e : headlines) {
            System.out.println(e);
            System.out.println();
        }
    }


// Breaking new, Latest News.... noch nicht fertig

    public static void breakingNews() throws IOException {

        if (getHtml().toString().contains("ticker-breaking-special")) {
            Elements breakingNews = getHtml().select("div#ticker-breaking-special");
            // System.out.println(breakingNews);

            if (breakingNews.toString().contains("h2")) {
                List<String> breakingNewsKind = new ArrayList<>();
                List<String> breakingNewsHeadlines = new ArrayList<>();

                for (Element e : breakingNews) {
                    Elements h2BreakingNews = breakingNews.select("h2");
                    Elements h3BreakingNews = breakingNews.select("h3");
                    String h2BreakingNewsStr = h2BreakingNews.toString();
                    String h3BreakingNewsStr = h3BreakingNews.toString();

                    breakingNewsKind.add(h2BreakingNewsStr);
                    breakingNewsHeadlines.add(h3BreakingNewsStr);

                }

                System.out.println(breakingNewsKind);
                System.out.println(breakingNewsHeadlines);

            } else {
                System.out.println("No breaking news");
            }

        }
    }
}




