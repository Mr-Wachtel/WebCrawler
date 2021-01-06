package WebCrawlerFX;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Sandra extends WebCrawler {

    // Überschrift der durchsuchten Webseite
    public static String websideName() throws IOException {
        String title = WebCrawler.getHtml().title();
        return title;

    }

    // Headlines (der Appansicht)  als String - Liste
    // Headlines für die App Version sind im "oon-grid-texts-container-mobile" Absatz
    public static ArrayList<String> headlinesApp() throws IOException {

        ArrayList<String> headlinesApp = new ArrayList<>();

        Elements appBig = WebCrawler.getHtml().select("div.oon-grid-texts-container-mobile");
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
        return headlinesApp;
        }


    // Headlines (der Normalansicht)  als String - Liste
    // Headlines für die Normalansicht sind im "oon-grid-texts-container" Absatz

    public static ArrayList<String> headlines() throws IOException {

        ArrayList<String> headlines = new ArrayList<>();
        Elements big = WebCrawler.getHtml().select("div.oon-grid-texts-container");
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
        return headlines;
    }


        //for Shit an Giggles

        public static ArrayList<String> giveMeBackwards (ArrayList < String > headlines) {
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
            return backwardsStringArrayList;
        }

        public static ArrayList<String> otherHeadlines () throws IOException {
            ArrayList<String> allOtherHeadlines = new ArrayList<>();
          //  ArrayList<String> thisHeadline = new ArrayList<>();

            Elements otherHeadlinesE = WebCrawler.getHtml().select("div.ticker-ressort");

            for (Element a : otherHeadlinesE) {
                //thisHeadline.clear();
                Elements h2 = a.select("h2");
                String testH2 = h2.toString();

                int substrH2 = testH2.indexOf("<span>");
                int substrH2End = testH2.indexOf("</span>");
                testH2 = testH2.substring(substrH2, substrH2End)
                        .replaceAll("<span>", "");
                allOtherHeadlines.add(testH2);

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
                        //thisHeadline.add(testH3);
                    }
                }
              /*  System.out.println();
                System.out.println(testH2);
                for (String d: thisHeadline)
                System.out.println(d);*/
            }
            return allOtherHeadlines;
        }

}



