package WebCrawlerFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebCrawler extends Application {

    // HTML der Webseite holen und in Document doc speichern
    public static Document getHtml() {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://orf.at/").userAgent("Mozilla").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static void main(String[] args) throws IOException {

        System.out.println();
        System.out.println("Die Überschrift der Webseite lautet: " + WhatHappens.websideName());
        System.out.println();

        System.out.println();
        System.out.println("Normalansicht Überschriften");
        System.out.println();
        for (String e : Headlines.headlines()) {
            System.out.println(e);
            System.out.println();}

        System.out.println();
        System.out.println("App Überschriften");
        System.out.println();
        for (String e :  Headlines.headlinesApp()) {
            System.out.println(e);
            System.out.println();}

        System.out.println();
        System.out.println("headlines backwards");
        System.out.println();
        for (String e : ShitAndGiggels.giveMeBackwards(Headlines.headlines())) {
            System.out.println(e);
            System.out.println();
        }
        System.out.println();
        System.out.println("other headlines");
        System.out.println();
        for (String e : Headlines.otherHeadlines()) {
            System.out.println(e);
            System.out.println();
        }
        // System.out.println(getHtml());

        WhatHappens.links();
        //Mary.getIcon();
        //  Mary.getAllLinks();
        //   Mary.COVAusland();












































































        // Start - PHIL



        ShitAndGiggels.mixUpMyCaptions(Headlines.headlines());
        launch(args);
    }

  @Override
    public void start(Stage primaryStage) throws Exception {

          Parent root = FXMLLoader.load(this.getClass().getResource("/sample.fxml"));
          primaryStage.setTitle("WebCrawler Test");
          primaryStage.setScene(new Scene(root, 400, 300));
          primaryStage.show();


    }
}