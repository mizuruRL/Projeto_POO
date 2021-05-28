package App;

import GameAssets.Score;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

/**
 * Class responsible for displaying the top10 scores panel.
 *
 * @author André Dias (190221068) e Tomás Barroso (190221029)
 * @version 1.0
 */
public class RankingPane extends ListView<Score> {
    private ObservableList<Score> rankings;

    /**
     * Constructor of class RankingPane.
     * @param list List of top10 rankings.
     */
    public RankingPane(List<Score> list) {
        rankings = FXCollections.observableArrayList(list);
        setItems(rankings);
            setCellFactory((ListView<Score> listView) -> {
                ListCell<Score> cell = new ListCell<Score>() {
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

    public ObservableList<Score> getRankings() {
        return rankings;
    }
}
