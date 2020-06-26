package App;

import GameAssets.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.awt.*;
import java.util.Optional;
import java.util.Stack;

public class Menu extends StackPane {
    private BorderPane gameStart;
    private Label lblUsername;
    private Player player;
    private Font lblUsernameFont;
    private GridPane startGameMenu;
    private GridPane gameDifficulty;
    private Button btnStartNewGame;
    private Button btnLoadGame;
    private Button btnShowPersonalScores;
    private Button btnShowRanking;
    private HBox hBTitle;
    private HBox hBBottom;
    private Button btnQuit;
    private Button btnNewBasicGameMode;
    private Button btnNewAdvancedGameMode;

    public Menu(String username) {
        gameStart = new BorderPane();
        lblUsername = new Label();
        player = new Player(username);
        lblUsernameFont = Font.loadFont("file:resources/fonts/Montserrat-Regular.ttf", 32);
        startGameMenu = new GridPane();
        gameDifficulty = new GridPane();
        btnStartNewGame = new Button("Start new Game");
        btnLoadGame = new Button("Load game");
        btnShowPersonalScores = new Button("Show personal scores");
        btnShowRanking = new Button("Ranking (TOP 10)");
        hBTitle = new HBox(lblUsername);
        hBBottom = new HBox();
        btnQuit = new Button("Quit");
        btnNewBasicGameMode = new Button("Start new Game\n- Basic Mode");
        btnNewAdvancedGameMode = new Button("Start new Game\n- Advanced Mode");
    }

    public void createContent(){
        gameStart.setStyle("-fx-background-color: #A9F8FB");
        lblUsername.setText("Hello "+ player.getNickName());
        lblUsername.setFont(lblUsernameFont);
        lblUsername.setTextAlignment(TextAlignment.CENTER);
        lblUsername.setAlignment(Pos.TOP_CENTER);
        lblUsername.setPadding(new Insets(50,0,0,0));
        hBTitle.setPadding(new Insets(30,0,0,0));
        hBTitle.setAlignment(Pos.TOP_CENTER);
        gameStart.setTop(hBTitle);

        showCreateGameMenu();
        getChildren().add(gameStart);
    }

    public void showCreateGameMenu(){
        getChildren().remove(gameDifficulty);

        btnStartNewGame.setMinWidth(150);
        btnStartNewGame.setCursor(Cursor.HAND);
        btnStartNewGame.setPadding(new Insets(10,0,10,0));

        btnLoadGame.setMinWidth(150);
        btnLoadGame.setPadding(new Insets(10,0,10,0));
        btnLoadGame.setCursor(Cursor.HAND);

        btnShowPersonalScores.setMinWidth(150);
        btnShowPersonalScores.setPadding(new Insets(10,0,10,0));
        btnShowPersonalScores.setCursor(Cursor.HAND);

        btnShowRanking.setMinWidth(150);
        btnShowRanking.setPadding(new Insets(10,0,10,0));
        btnShowRanking.setCursor(Cursor.HAND);

        startGameMenu.add(btnStartNewGame,0,0);
        startGameMenu.add(btnLoadGame,1,0);
        startGameMenu.add(btnShowPersonalScores, 0,1);
        startGameMenu.add(btnShowRanking,1,1);
        startGameMenu.setAlignment(Pos.TOP_CENTER);
        startGameMenu.setPadding(new Insets(80,0,0,0));
        startGameMenu.setVgap(5);
        startGameMenu.setHgap(5);
        gameStart.setCenter(startGameMenu);

        hBBottom.getChildren().add(btnQuit);
        gameStart.setBottom(hBBottom);
        btnQuit.setCursor(Cursor.HAND);
        hBBottom.setPadding(new Insets(0,0,10,10));

        btnQuit.setOnAction((event) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Blocku Docku");
            alert.setHeaderText("Quit game!");
            alert.setContentText("Are you sure you want to quit the game?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Platform.exit();
            } else {
                alert.close();
            }
        });

        btnStartNewGame.setOnAction((event) -> {
            showGameModeDifficulty();
        });
    }

    public void showGameModeDifficulty(){
        getChildren().remove(startGameMenu);

        startGameMenu.getChildren().removeAll(btnShowPersonalScores,btnShowRanking);

        btnQuit.setText("Back");

        btnNewBasicGameMode.setMinWidth(150);
        btnNewBasicGameMode.setCursor(Cursor.HAND);
        btnNewBasicGameMode.setPadding(new Insets(10,0,10,0));

        btnNewAdvancedGameMode.setMinWidth(150);
        btnNewAdvancedGameMode.setPadding(new Insets(10,0,10,0));
        btnNewAdvancedGameMode.setCursor(Cursor.HAND);

        startGameMenu.add(btnNewBasicGameMode,0,0);
        startGameMenu.add(btnNewAdvancedGameMode,1,0);
        startGameMenu.setAlignment(Pos.TOP_CENTER);
        startGameMenu.setPadding(new Insets(80,0,0,0));
        startGameMenu.setVgap(5);
        startGameMenu.setHgap(5);
        gameStart.setCenter(startGameMenu);

        btnQuit.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                startGameMenu.getChildren().removeAll(btnNewBasicGameMode,btnNewAdvancedGameMode);
                showCreateGameMenu();
            }
        });
    }

}
