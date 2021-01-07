package WebCrawlerFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.io.IOException;

public class Oberflaeche {

    @FXML
    private CheckBox checkbox1;

    @FXML
    private Button Button_MixUp;

    @FXML
    void Button_MixUP(ActionEvent event) throws IOException {

        Phil.mixUpMyCaptions(Sandra.headlines());

    }

    @FXML
    void clickcheckbox1(ActionEvent event) {

    }

}

