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
    private Button GoBack;

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
        String headline ="MixUp du gew\u00E4hlt hast: ";

        StringBuilder text = new StringBuilder();
        text.append(System.lineSeparator());
        text.append(ShitAndGiggels.mixUpMyCaptions(Headlines.headlines()));



        loadTextScreen(event, text.toString(),headline);
    }




    @FXML
    void GiveMeBackwards(ActionEvent event) throws IOException {

        String headline ="Headlines Backwards";

      StringBuilder text = new StringBuilder();
      text.append(System.lineSeparator());
        for (String e : ShitAndGiggels.giveMeBackwards(Headlines.headlines())) {
            text.append(e).append(System.lineSeparator()).append(System.lineSeparator());
        }
       loadTextScreen(event, text.toString(),headline);

    }

    @FXML
    void GiveMeHeadlines(ActionEvent event) throws IOException {

        String headline ="Normalansicht \u00DCberschriften";

        StringBuilder text = new StringBuilder();
        text.append(System.lineSeparator());
        for (String e : Headlines.headlines()) {
            text.append(e).append(System.lineSeparator()).append(System.lineSeparator());
        }
        loadTextScreen(event, text.toString(),headline);
    }



    @FXML
    void GiveMeLinks(ActionEvent event) throws IOException {

        String headline ="Links";

        StringBuilder text = new StringBuilder();
        text.append(System.lineSeparator());
        for (String e : WhatHappens.links()) {
            text.append(e).append(System.lineSeparator()).append(System.lineSeparator());
        }
        loadTextScreen(event, text.toString(),headline);
    }


    @FXML
    void GiveMeMobileHeadlines(ActionEvent event) throws IOException {
        String headline ="App \u00DCberschriften";

        StringBuilder text = new StringBuilder();
        text.append(System.lineSeparator());
        for (String e : Headlines.headlinesApp()) {
            text.append(e).append(System.lineSeparator()).append(System.lineSeparator());
        }
        loadTextScreen(event, text.toString(),headline);
    }

    @FXML
    void GiveMeORF(ActionEvent event) throws IOException {
        String headline ="Die \u00DCberschrift der Webseite lautet: ";

        StringBuilder text = new StringBuilder();
        text.append(System.lineSeparator());
        text.append(WhatHappens.websideName());

        loadTextScreen(event, text.toString(), headline);
    }



    @FXML
    void GiveMeSubHeadlines(ActionEvent event) throws IOException {

        String headline ="Other Headlines";

        StringBuilder text = new StringBuilder();
        for (String e : Headlines.otherHeadlines()) {
            text.append(e).append(System.lineSeparator());
        }
        loadTextScreen(event, text.toString(), headline);
    }


    private void loadTextScreen(Event event, String text, String headline){
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
            controller.setHeadline(headline);

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


