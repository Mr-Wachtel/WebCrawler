package WebCrawlerFX;

import java.util.ArrayList;
import java.util.Random;

public class ShitAndGiggels extends WebCrawler {

    public static String mixUpMyCaptions(ArrayList<String> mixup) {
    //Überschriften werden durchgemischt und eine neue Überschrift daraus erstellt
        String[] MixUpArray;
        StringBuilder MixUpStringBuilder = new StringBuilder();

        Random random = new Random();

        for (String beforemix : mixup) {
            MixUpArray = beforemix.split(" ");
            MixUpStringBuilder.append(MixUpArray[random.nextInt(MixUpArray.length)]+" ");
        }
        return MixUpStringBuilder.toString();
    }

    public static ArrayList<String> giveMeBackwards (ArrayList < String > headlines) {
     //Überschrift wird rückwärts ausgegeben
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
