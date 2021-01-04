import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sandra extends WebCrawler {
    public Sandra() throws IOException {
    }





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
                    .replace(" </h1>", "")
                    .replaceAll(" <br> ", " ")
                    .replaceAll(" <br>", " ")
                    .replaceAll("<br> ", " ")
                    .replaceAll("<br>", " ");

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

    public static ArrayList<String> headlines() throws IOException {

        ArrayList<String> headlines = new ArrayList<>();
        Elements big = getHtml().select("div.oon-grid-texts-container");
        for (Element e : big) {
            String test = e.toString();
            if (!test.contains("-mobile")) {
                Elements h1 = e.select("h1");
                String stringH1 = h1.toString()
                        .replace("<h1> ", "")
                        .replace(" </h1>", "")
                        // manchmal wird br mit leezeichen davor abgegeben. manchmal ohne daher wird untschieden
                        .replaceAll(" <br> ", " ")
                        .replaceAll(" <br>", " ")
                        .replaceAll("<br>x", " ")
                        .replaceAll("<br>", " ");

                headlines.add(stringH1);
            }
        }
        System.out.println("Normalansicht Überschriften");
        for (String e : headlines) {
            System.out.println(e);
            System.out.println();
        }
        return headlines;
    }


// Breaking news, Latest News

   // public static void breakingNews() throws IOException {

     //   if (getHtml().toString().contains("ticker-breaking-special")) {
      //      Elements breakingNews = getHtml().select("div#ticker-breaking-special");

            // System.out.println(breakingNews);

           /* if (breakingNews.toString().contains("h2")) {


                for (Element e : breakingNews) {
                    // Art der Breaking News
                    Elements h2BreakingNews = breakingNews.select("h2");
                    String h2BreakingNewsStr = h2BreakingNews.toString();
                    int substrH2 = h2BreakingNewsStr.indexOf("<span>");
                    int substrH2End = h2BreakingNewsStr.indexOf("</span>");
                    h2BreakingNewsStr = h2BreakingNewsStr.substring(substrH2, substrH2End)
                            .replaceAll("<span>", "");

                    // headline der breaking News
                    Elements h3BreakingNews = breakingNews.select("h3");
                    String h3BreakingNewsStr = h3BreakingNews.toString();
                    int substrH3 = h3BreakingNewsStr.indexOf("=\"false\">");
                    int substrH3End = h3BreakingNewsStr.indexOf("</a");
                    h2BreakingNewsStr = h2BreakingNewsStr.substring(substrH3, substrH3End)
                            .replaceAll("=\"false\">", "");

                    System.out.println(h2BreakingNewsStr);
                    System.out.println(h3BreakingNewsStr);
                }

            } else {
                System.out.println("No breaking news");
                System.out.println();*/

          //  for (Element a : breakingNews) {
            //    String testH2 = a.toString();
              //  System.out.println(testH2);

           // }




        //for Shit an Giggles

        public static void giveMeBackwards (ArrayList < String > headlines) {
            String[] backwardsArry;
            String backwardsString;
            ArrayList<String> backwardsStringArrayList = new ArrayList<>();
            for (String e : headlines) {
                backwardsArry = e.split(" ");
                StringBuilder backwardsStringBuilder = new StringBuilder();
                for (int i = (backwardsArry.length - 1); i >= 0; i--) {
                    backwardsStringBuilder.append(backwardsArry[i] + " ");
                }
                backwardsString = backwardsStringBuilder.toString()
                        .replace(":", "")
                        .replace("“", "")
                        .replace("„", "");
                backwardsStringArrayList.add(backwardsString);

            }
            System.out.println("headlines backwards");
            System.out.println();

            for (String e : backwardsStringArrayList) {
                System.out.println(e);
                System.out.println();

            }
        }

        public static ArrayList<String> otherHeadlines () throws IOException {
            ArrayList<String> allOtherHeadlines = new ArrayList<>();
            ArrayList<String> thisHeadline = new ArrayList<>();

            Elements otherHeadlinesE = getHtml().select("div.ticker-ressort");

            for (Element a : otherHeadlinesE) {
                thisHeadline.clear();
                Elements h2 = a.select("h2");
                String testH2 = h2.toString();

                int substrH2 = testH2.indexOf("<span>");
                int substrH2End = testH2.indexOf("</span>");
                testH2 = testH2.substring(substrH2, substrH2End)
                        .replaceAll("<span>", "");

                // headlines der einzellnen Unterordner
                Elements h3 = a.select("h3");
                for (Element b : h3) {
                    String testH3 = b.toString();
                    if (testH3.contains("=\"false\">")) {
                        int substrH3 = testH3.indexOf("=\"false\">");
                        int substrH3End = testH3.indexOf("</a");
                        testH3 = testH3.substring(substrH3, substrH3End)
                                .replaceAll("=\"false\">", "");
                    }
                    if (!testH3.contains("h3")) {
                        allOtherHeadlines.add(testH3);
                        thisHeadline.add(testH3);
                    }
                }
                System.out.println();
                System.out.println(testH2);
                for (String d: thisHeadline)
                System.out.println(d);

            }

            return allOtherHeadlines;

        }

}



