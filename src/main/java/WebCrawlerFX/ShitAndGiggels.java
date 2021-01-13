package WebCrawlerFX;

import java.util.ArrayList;
import java.util.Random;

public class ShitAndGiggels extends WebCrawler {


    public static String mixUpMyCaptions(ArrayList<String> mixup) {


        String[] MixUpArray;
        String MixUpString;
        ArrayList<String> MixUpStringArrayList = new ArrayList<>();
        StringBuilder MixUpStringBuilder = new StringBuilder();


        Random random = new Random();



        for (String beforemix : mixup) {
            MixUpArray = beforemix.split(" ");
            MixUpStringBuilder.append(MixUpArray[random.nextInt(MixUpArray.length)]+" ");
        }


        return MixUpStringBuilder.toString();


        // for (String aftermix : MixUpStringArrayList) {
        //      System.out.println(aftermix);
        //    System.out.println();

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

}
