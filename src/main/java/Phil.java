import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Phil extends WebCrawler {


    public static void mixUpMyCaptions(ArrayList<String> mixup) {


        String[] MixUpArray;
        String MixUpString;
        ArrayList<String> MixUpStringArrayList = new ArrayList<>();
        for (String beforemix : mixup) {
            MixUpArray = beforemix.split(" ");
            StringBuilder MixUpStringBuilder = new StringBuilder();

            Random random = new Random();


            // irgendwie muss das doch mit Random zu machen sein o.O
            // es ist zu spät und ich bin zu müde um noch vernünftig Code aus meinem Hirn rauszukriegen -.-

            System.out.println("MixUp du gewählt hast:");
            System.out.println();

            for (String aftermix : MixUpStringArrayList) {
                System.out.println(aftermix);
                System.out.println();

            }

        }
    }
}
