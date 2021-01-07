package WebCrawlerFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Oberflaeche {

    @FXML
    private Button Button_MixUp;

    @FXML
    private Button GiveMeBackwards;

    @FXML
    private Button GiveMeLinks;

    @FXML
    private Button GiveMeORF;

    @FXML
    private Button GiveMeHeadlines;

    @FXML
    private Button GiveMeMobileHeadlines;

    @FXML
    private Button GiveMeSubHeadlines;

    @FXML
    void Button_MixUP(ActionEvent event) throws IOException {

        ShitAndGiggels.mixUpMyCaptions(Headlines.headlines());
    }

    @FXML
    void GiveMeBackwards(ActionEvent event) throws IOException {

        System.out.println();
        System.out.println("headlines backwards");
        System.out.println();
        for (String e : ShitAndGiggels.giveMeBackwards(Headlines.headlines())) {
            System.out.println(e);
            System.out.println();
        }
    }

    @FXML
    void GiveMeHeadlines(ActionEvent event) throws IOException {

        System.out.println();
        System.out.println("Normalansicht Überschriften");
        System.out.println();
        for (String e : Headlines.headlines()) {
            System.out.println(e);
            System.out.println();}

    }

    @FXML
    void GiveMeLinks(ActionEvent event) throws IOException {
        WhatHappens.links();
    }

    @FXML
    void GiveMeMobileHeadlines(ActionEvent event) throws IOException {
        System.out.println();
        System.out.println("App Überschriften");
        System.out.println();
        for (String e :  Headlines.headlinesApp()) {
            System.out.println(e);
            System.out.println();}

    }

    @FXML
    void GiveMeORF(ActionEvent event) throws IOException {
        System.out.println();
        System.out.println("Die Überschrift der Webseite lautet: " + WhatHappens.websideName());
        System.out.println();

    }

    @FXML
    void GiveMeSubHeadlines(ActionEvent event) throws IOException {
        System.out.println();
        System.out.println("other headlines");
        System.out.println();
        for (String e : Headlines.otherHeadlines()) {
            System.out.println(e);
            System.out.println();
        }

    }

}


