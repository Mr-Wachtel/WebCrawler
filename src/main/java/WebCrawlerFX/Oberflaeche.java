package WebCrawlerFX;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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

        StringBuilder text = new StringBuilder();
        for (String e : ShitAndGiggels.giveMeBackwards(Headlines.headlines())) {
            text.append(e).append(System.lineSeparator());
            System.out.println(e);
            System.out.println();
        }
        loadTextScreen(event, text.toString());
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

    private void loadTextScreen(Event event, String text){
        Node node = (Node) event.getSource();
        Stage stageTheEventSourceNodeBelongs = (Stage) node.getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();

        try {
            // load fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("textscreen.fxml"));
            // initialize controller manually to pass values - remove controller from fxml!
            TextscreenController controller = new TextscreenController();
            // pass the values to controller instance
            controller.setText(text);

            // set the controller to fxml
            loader.setController(controller);

            Parent root = loader.load();

            // call initialize method to set the elements
            controller.initialize();

            // show scene
            Scene scene = new Scene(root, 600,400);
            stageTheEventSourceNodeBelongs.setScene(scene);
            stageTheEventSourceNodeBelongs.show();
        } catch (IOException e){
            System.out.println("Error loading scene.");
        }
    }

}


