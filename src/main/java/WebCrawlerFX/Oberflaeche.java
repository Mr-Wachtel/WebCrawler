package WebCrawlerFX;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Oberflaeche {


    @FXML
    private ImageView MightyDucks;

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

      //  Variante für die Ausgabe der Links nur als Text

       /* String headline ="Links";

        StringBuilder text = new StringBuilder();
        text.append(System.lineSeparator());
        for (String e : WhatHappens.links()) {
            text.append(e).append(System.lineSeparator()).append(System.lineSeparator());
        }
        loadTextScreen(event, text.toString(),headline);*/
        loadHyperlinksScreen(event);
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
        String headline ="Der link zur durchsuchten Webseite: ";

        String  text = WhatHappens.websideName();

        Hyperlink.setWeblink(text);
        loadHyperlinkScreen(event, text, headline);

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

    @FXML
    void MightyDucks(MouseEvent event) throws IOException {

        String headline ="Sei gegr\u00FC\u00DFt neugieriger Wanderer!";




        loadEasterEgg(event, headline);

    }

    private void loadHyperlinkScreen(Event event, String hyperlink, String headline){
        Node node = (Node) event.getSource();
        Stage stageTheEventSourceNodeBelongs = (Stage) node.getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();

        try {
            // load fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("hyperlink.fxml"));
            // initialize controller manually to pass values - remove controller from fxml!
            Hyperlink controller = new Hyperlink();
            // pass the values to controller instance
            controller.setHyperlink(hyperlink);
            controller.setHeadline2(headline);

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

    private void loadEasterEgg(Event event, String headline){
        Node node = (Node) event.getSource();
        Stage stageTheEventSourceNodeBelongs = (Stage) node.getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();

        try {
            // load fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("easterEgg.fxml"));
            // initialize controller manually to pass values - remove controller from fxml!
            EasterEgg controller = new EasterEgg();
            // pass the values to controller instance
            //controller.setText(text);
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

    private void loadHyperlinksScreen(Event event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stageTheEventSourceNodeBelongs = (Stage) node.getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();

        try {

            Scene scene = new Scene(new Group());

            start(stageTheEventSourceNodeBelongs, scene);

            stageTheEventSourceNodeBelongs.setScene(scene);
            stageTheEventSourceNodeBelongs.show();
        }
        finally
        {}

    }

    public void start(Stage stage, Scene scene) throws IOException {
        //Scene scene = new Scene(new Group());
        stage.setTitle("Mighty Ducks links: ");
        stage.setWidth(600);
        stage.setHeight(600);


        // Cheat Code
        final javafx.scene.control.Hyperlink[] hpls
                = new javafx.scene.control.Hyperlink[18];

        String[] captions = new String[WhatHappens.links().size()];

        int h = 0;
        for (String g : WhatHappens.links()) {
            captions[h] = g;
            h++;
        }

        for (int i =0; i< 18; i++) {
            final javafx.scene.control.Hyperlink hpl = new javafx.scene.control.Hyperlink(captions[i]);
            hpls[i] = hpl;
            String hilfe = captions[i];
            hpl.setOnAction(e -> {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI(hilfe));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
     /* Code with Scroll Pane

     final javafx.scene.control.Hyperlink[] hpls
              = new javafx.scene.control.Hyperlink[(WhatHappens.links().size())];
        int i = 0;
        for (String g : WhatHappens.links()) {
            final javafx.scene.control.Hyperlink hpl = new javafx.scene.control.Hyperlink(g);
            hpls[i] = hpl;
          //  e = hpl;
            //hpl.setText("http://"+i);
            hpl.setOnAction(e -> {
                if(Desktop.isDesktopSupported())
                {
                    try {
                        Desktop.getDesktop().browse(new URI(g));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            i++;

        }*/



        final Button GoBack2 = new Button("Nochmal");
        GoBack2.setAlignment(Pos.BOTTOM_CENTER);
        //final ScrollBar pane = new ScrollBar();
        //pane.setOrientation(Orientation.VERTICAL);

        GoBack2.setOnAction(e -> {
            Parent tableViewParent = null;
            try {
                tableViewParent = FXMLLoader.load(getClass().getResource("/sample.fxml"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Scene tableviewScene = new Scene(tableViewParent);
            //Stage Info

            Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
            window.setScene(tableviewScene);
            window.show();

        });



        VBox vbox = new VBox();
        vbox.getChildren().addAll(hpls);


        vbox.getChildren().add(GoBack2);
        vbox.setSpacing(5);

        ((Group)scene.getRoot()).getChildren().add(vbox);
        stage.setScene(scene);
        stage.show();
    }

}


