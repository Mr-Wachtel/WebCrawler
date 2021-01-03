import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Mary extends WebCrawler {

    /* try {
        Document document = Jsoup.parse( new File("C:/Users/User/Documents/orfat.html"), "utf-8"); // Use Jsoup.parse() method to load HTML from a string.
        System.out.println(document.title()); // call document.title() method to get the title of HTML page.
        } catch (IOException e) {
            e.printStackTrace();
        }
     */

    /* We have already added these codes under "WebCrawler.java" /*
    /* try {
        Document document = Jsoup.connect("https://orf.at/").get();
        System.out.println(document.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
     */

    private HashSet<String> links;

    public Mary() {
        links = new HashSet<>();
    }

    public static void TitleandWebsite() throws IOException {
        String html = "<html><head><title>ORF.AT</title></head>"
                + "<body>"
                + "<div id='sampleDiv'><a href='https://orf.at/'></a>"
                + "</div>"
                + "</body></html>";
        Document document = Jsoup.parse(html);

        // get the page title
        String TitleandWebsite = document.title();
        System.out.println("The Website that you're browsing: " + TitleandWebsite + " (URL: https://orf.at/)" + "\n");
    }

    //get the favicon from orf.at (the red circle :D)
    public static void getIcon() throws IOException {
        String favImage = "https://orf.at/mojo/1_4_1/storyserver//common/images/favicons/favicon-32x32.png";
        Element element = getHtml().head().select("link[href~=.*\\.(image|png)]").first();

        if (element == null) {
            element = getHtml().head().select("meta[itemprop=image/png]").first();

            if (element != null) {
                favImage = element.attr("content");
            }
        } else {
            favImage = element.attr("href");
        }
        System.out.println("Logo of this website: " + favImage + "\n");
    }


    // show all the links of different news within orf.at
    public static void getAllLinks() throws IOException {

        List<String> getAllLinks = new ArrayList<>();
        Elements li1 = getHtml().select("a[href]");

        if (li1 != null && getHtml().toString().contains("https")) {
            for (Element link : li1) {
                String li1Str = link.toString();
                getAllLinks.add(li1Str);

                System.out.println("Category: " + link.text());
                System.out.println("Link: " + link.attr("href") + "\n");

                // how can I remove the "#content" and "ss-networkNavigation" from the result?!
                if (getAllLinks.contains("#content") || getAllLinks.contains("#ss-networkNavigation")) {
                    System.out.println();
                }
            }
        } else {
            System.out.println("No Links can be displayed!!!");
        }
    }

    // the below part is not finished, different Abteilungen von orf.at
    public static void COVAusland() throws IOException {
        // there are no news headline under COV-Ausland?! (inside the source codes)

        ArrayList<String> COVAusland = new ArrayList<>();
        Elements COVheadline = getHtml().select("div.oon-grid-texts-headline oon-grid-texts-shadow-10 oon-grid-texts-dimout-7 oon-grid-texts-letter-spacing-10");

        if (COVheadline != null) {
            for (Element h : COVheadline) {
                Elements h1title = h.select("h1");
                String Strh2 = h1title.toString().replace("<h1>", "").replace("</h1>", "");

                COVAusland.add(Strh2);
            }
            System.out.println("title: ");
            for (String h : COVAusland) {
                System.out.println(h);
            }

        }
    }
}

    /* public static void COVInland() throws IOException {
        ArrayList<String> COVInland = new ArrayList<>();

    }

    public static void EU() throws IOException {
        ArrayList<String> EU = new ArrayList<>();
    }

    public static void Inland() throws IOException {
        ArrayList<String> Inland = new ArrayList<>();
    }

    public static void Ausland() throws IOException {
        ArrayList<String> Ausland = new ArrayList<>();
    }

    public static void Sport() throws IOException {
        ArrayList<String> Sport = new ArrayList<>();
        String s = getHtml().absUrl("https://sport.orf.at/");
        Elements Sportheadline = getHtml().select("div.oon-grid-texts-container");

        for (Element sport1 : Sportheadline) {
            Elements sporth1 = sport1.select("h1");
            String h1 = sporth1.toString().replace("<h1>","").replace("</h1>","");

            Sport.add(h1);
        }
        System.out.println("title1: ");
        for (String sport1 : Sport) {
            System.out.println(sport1 + "\n");
        }
    }
}/*

            //Headline News
            /* Elements list = getHtml().select("li[class=interactive] a ");
            for (Element li : list) {
                System.out.println(li.text());
                System.out.println("Link:" + li.attr("href"));
                System.out.println('\n');
            } */

//Stories
            /* Elements divs = getHtml().select("div[class=story] a");
            for (Element div : divs) {
                System.out.println("Story:" + div.text());
                System.out.println("Link:" + div.attr("href"));
                System.out.println('\n');
            }
        } */

/* Find all URLs that start with "https://orf.at/" and add them to the HashSet */

// Step 4. Check if you have already crawled the URLs
// (we are intentionally not checking for duplicate content in this example)

        /* public void getPageLinks(String url)
            if (!links.contains(url)) {
                try {
                    // Step 4i. if not add it to the index
                    if (links.add(url)) {
                        System.out.println(url);
                    }

                Document document = Jsoup.connect(url).get(); // Step 2. Fetch the HTML code

                Elements linksOnPage = document.select("a[href]"); // Step 3. Parse the HTML to extract links to other URLs

                for (Element page : linksOnPage) {    // Step 5. For each extracted URL... go back to Step 4.
                    getPageLinks(page.attr("abs:href"));
                }
            } catch (IOException e) {
                System.err.println("For '" + url + "': " + e.getMessage());
            }
        }
    } */