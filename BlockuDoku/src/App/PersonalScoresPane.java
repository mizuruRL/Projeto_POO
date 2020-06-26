package App;

import GameAssets.Score;
import GameAssets.Scores;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class PersonalScoresPane extends ListView<Score> {
    private ObservableList<Score> personalScoresList;

    public PersonalScoresPane(){
        personalScoresList = FXCollections.observableArrayList();
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

        return hBoxContent;
    }

    public ObservableList<Score> getPersonalScoresList() {
        return personalScoresList;
    }
}
