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

    public static void TitleandWebsite() {
        String html = "<html><head><title>ORF.AT</title></head>"
                + "<body>"
                + "<p>Sample Content</p>"
                + "<div id='sampleDiv'><a href='https://orf.at/'></a>"
                + "<h3><a>Sample</a><h3>"
                + "</div>"
                + "</body></html>";

        Document document = Jsoup.parse(html);
        try {
            // get the page title
            String TitleandWebsite = document.title();
            System.out.println("Website:" + TitleandWebsite);
            System.out.println("\n");

            System.out.println("Top Headline News:");
            System.out.println("\n");

            //Headline News
            Elements list = document.select("li[class=interactive] a ");
            for (Element li : list) {
                System.out.println(li.text());
                System.out.println("Link:" + li.attr("href"));
                System.out.println('\n');
            }

            //Stories
            Elements divs = document.select("div[class=story] a");
            for (Element div : divs) {
                System.out.println("Story:" + div.text());
                System.out.println("Link:" + div.attr("href"));
                System.out.println('\n');
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

            // show the link of website
            Elements links = document.select("a[href]");
            for (Element link : links) {
                System.out.println("link : " + link.attr("href"));
            }

            // get the fav icon if it exists (not necessary)
            String favImage = "Not Found";
            Element element = document.head().select("link[href~=.*\\.(ico|png)]").first();
            if (element == null) {
                element = document.head().select("meta[itemprop=image]").first();
                if (element != null) {
                    favImage = element.attr("content");
                }
            } else {
                favImage = element.attr("href");
            }
            System.out.println(favImage);
        }
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

    // the below part is not finished
    public static void COVAusland() throws IOException {

        Document doc = Jsoup.connect("https://orf.at/").get();
        for (Element headline : doc.select("div.headline")) {
            System.out.println(headline.text());
        }
        }
    }