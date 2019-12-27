import com.sun.javafx.collections.MappingChange;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.plaf.FileChooserUI;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BookReaderController extends Application {

    public static final String[] REGIONS = {"blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
            "halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
            "södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
            "öland", "östergötland"};


    @Override
    public void start(Stage primaryStage) throws Exception {

        FileChooser fileChooser = new FileChooser();

        Scanner s = new Scanner(new File("nilsholg.txt"));
        s.findWithinHorizon("\uFEFF", 1);
        s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

        Scanner ss = new Scanner(new File("undantagsord.txt"));
        ss.findWithinHorizon("\uFEFF", 1);
        ss.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");

        Set<String> stopWords = new HashSet<>();
        while (ss.hasNext()) {
            String word = ss.next().toLowerCase();
            stopWords.add(word);
        }
        ss.close();
        GeneralWordCounter generalWordCounter = new GeneralWordCounter(stopWords);
        while (s.hasNext()) {
            String word = s.next().toLowerCase();
            generalWordCounter.process(word);
        }
        s.close();


        ObservableList<Map.Entry<String, Integer>> words =
                FXCollections.observableArrayList(generalWordCounter.getWords());
        ListView<Map.Entry<String, Integer>> listView = new
                ListView<Map.Entry<String, Integer>>(words);


        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("BookReader");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.setCenter(listView);

        HBox hb = new HBox();
        Button file = new Button("File..."); //optional exercise
        Button b1 = new Button("Alphabetic");
        Button b2 = new Button("Frequency");
        Button b3 = new Button("Search");
        TextField field = new TextField();
        hb.getChildren().addAll(file, b1, b2, b3, field);
        hb.setHgrow(field, Priority.ALWAYS);// optional exercise
        root.setBottom(hb);

        file.setOnAction(event -> {
            File f = fileChooser.showOpenDialog(primaryStage);
        });


        b1.setOnAction(event -> {
            words.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));
        });

        b2.setOnAction(event -> {
            words.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        });


        //search button optional exercise
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Word not found");
        alert.setHeaderText("The searched for word does not appear in the text");

        b3.setOnAction(event -> {
            boolean found = false;
            for (Map.Entry<String, Integer> searchedWord : words) {
                String entry = field.getText();
                entry = entry.trim().toLowerCase();   //optional exercise
                if (searchedWord.getKey().equals(entry)) {
                    listView.scrollTo(searchedWord);
                    listView.getSelectionModel().select(searchedWord);  //optional exercise
                    found = true;
                    break;
                }
            }
            if (!found) {
                alert.show();
            }
        });

        field.setOnAction(event -> b3.fire());


    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
