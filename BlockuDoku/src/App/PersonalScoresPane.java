package App;

import GameAssets.Score;
import GameAssets.Scores;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class PersonalScoresPane extends ListView<Score> {
    private ObservableList<Score> personalScoresList;

    public PersonalScoresPane(List<Score> list){

        personalScoresList = FXCollections.observableArrayList(list);
        setItems(personalScoresList);

        setCellFactory((ListView<Score> listView) -> {
            ListCell<Score> cell = new ListCell<>() {
                @Override
                public void updateItem(Score item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    }
                    if (item != null) {
                        setGraphic(drawCell(item));
                    }
                }
            };
            return cell;
        });
    }

    private Node drawCell(Score item){
        VBox hBoxContent = new VBox();
        Font userInfoFont = Font.loadFont("file:resources/fonts/Montserrat-Regular.ttf", 15);

        Label lblContent = new Label(item.toString());
        lblContent.setFont(userInfoFont);
        lblContent.setPadding(new Insets(5,0,5,5));

        hBoxContent.getChildren().add(lblContent);

        setMouseTransparent( true );
        setFocusTraversable( false );

        return hBoxContent;
    }

    public ObservableList<Score> getPersonalScoresList() {
        return personalScoresList;
    }
}
