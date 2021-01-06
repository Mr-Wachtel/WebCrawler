package WebCrawlerFX;

import java.util.ArrayList;
import java.util.Random;

public class Phil extends WebCrawler {


    public static void mixUpMyCaptions(ArrayList<String> mixup) {


        String[] MixUpArray;
        String MixUpString;
        ArrayList<String> MixUpStringArrayList = new ArrayList<>();
        StringBuilder MixUpStringBuilder = new StringBuilder();


        Random random = new Random();



        for (String beforemix : mixup) {
            MixUpArray = beforemix.split(" ");
            MixUpStringBuilder.append(MixUpArray[random.nextInt(MixUpArray.length)]+" ");
        }


        System.out.println("MixUp du gewählt hast:");
        System.out.println();

        System.out.println(MixUpStringBuilder);


        // for (String aftermix : MixUpStringArrayList) {
        //      System.out.println(aftermix);
        //    System.out.println();

    }

}
