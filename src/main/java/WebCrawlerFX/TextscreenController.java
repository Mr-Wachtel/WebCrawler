package WebCrawlerFX;

import javafx.fxml.FXML;

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
        textArea.setText(text);
        label.setText(text);
    }

}
