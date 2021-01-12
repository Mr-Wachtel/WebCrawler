package WebCrawlerFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TextscreenController {

    @FXML
    private javafx.scene.control.TextArea textArea;

    @FXML
    private javafx.scene.control.Label label;

    public String text = "";

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

    public void initialize() {
        //textArea.setText(text);
        label.setText(text);
    }

    public void GoBackTo(ActionEvent actionEvent) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        Scene tableviewScene = new Scene(tableViewParent);
        //Stage Info

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(tableviewScene);
        window.show();
    }

}
