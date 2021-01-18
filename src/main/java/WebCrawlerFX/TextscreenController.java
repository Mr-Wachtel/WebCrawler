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

public class TextscreenController {

    @FXML
    private javafx.scene.control.Button GoBack;

    @FXML
    private javafx.scene.control.Label label2;

    @FXML
    private javafx.scene.control.Label label;

    public String text = "";
    public String headline = "";


    public void setText(String text) {
        this.text = text;
    }
    public void setHeadline(String headline) {
        this.headline= headline;
    }

    public String getText() {
        return this.text;
    }
    public String getHeadline() {
        return this.headline;
    }

    public void initialize() {
        //textArea.setText(text);
        label.setText(text);
        label2.setText(headline);


            GoBack.setOnAction(e -> {
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
