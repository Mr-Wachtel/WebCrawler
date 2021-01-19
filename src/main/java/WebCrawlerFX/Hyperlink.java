package WebCrawlerFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Hyperlink {


    public static String weblink = "";


    public static void setWeblink(String linkname){
        weblink = linkname;
    }

    @FXML
    private javafx.scene.control.Button GoBack2;

    @FXML
    private javafx.scene.control.Label label3;

    @FXML
    private javafx.scene.control.Hyperlink hyperlink;


    public String link =  "";
    public String headline = "";



    public void setHyperlink(String link) {
        this.link = link;
    }

    public void setHeadline2(String headline) {
        this.headline= headline;
    }

    public String getHyperlink() {
        return this.link;
    }
    public String getHeadline() {
        return this.headline;
    }

    public void initialize() {
        hyperlink.setText(link);
        label3.setText(headline);


        hyperlink.setOnAction(e -> {
            if(Desktop.isDesktopSupported())
            {
                try {
                    Desktop.getDesktop().browse(new URI(weblink));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });


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
    }
}

