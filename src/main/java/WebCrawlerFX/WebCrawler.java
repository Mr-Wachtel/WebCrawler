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


        launch(args);
    }

  @Override
    public void start(Stage primaryStage) throws Exception {

          Parent root = FXMLLoader.load(this.getClass().getResource("/sample.fxml"));
          primaryStage.setTitle("ORF Mighty Duck Style!");
          primaryStage.setScene(new Scene(root, 600,400));
          primaryStage.show();


    }
}