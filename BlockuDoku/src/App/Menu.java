package App;

import BlockGame.Game;
import FileHandler.RWFile;
import GameAssets.Mode;
import GameAssets.Player;
import GameAssets.Score;
import GameAssets.Scores;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.*;
import java.util.Optional;
import java.util.Stack;

/**
 * Class responsible for displaying the main menu of the game.
 *
 * @author André Dias (190221068) e Tomás Barroso (190221029)
 * @version 1.0
 */
public class Menu extends StackPane {
    private BorderPane gameStart;
    private BorderPane gameDifficultyMenu;
    private Label lblUsername;
    private Game game;
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
    private Button btnBack;
    private Button btnNewBasicGameMode;
    private Button btnNewAdvancedGameMode;

    /**
     * Constructor of class menu.
     * @param game Game to keep in memory.
     */
    public Menu(Game game) {
        this.game = game;
        lblUsernameFont = Font.loadFont("file:resources/fonts/Montserrat-Regular.ttf", 32);

    }

    /**
     * Method responsible for creating the content to be displayed in the menu.
     */
    public void createContent(){
        createGameMenu();
        createDifficultyMenu();
        getChildren().add(createGameMenu());
        btnStartNewGame.setOnAction((event) -> {
            getChildren().remove(gameStart);
            getChildren().add(gameDifficultyMenu);
        });
        btnBack.setOnAction((event) -> {
            getChildren().remove(gameDifficultyMenu);
            getChildren().add(gameStart);
        });
        btnQuit.setOnAction((event) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Blocku Docku");
            alert.setHeaderText("Quit game!");
            alert.setContentText("Are you sure you want to quit the game?\nAny progress will not be saved.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Platform.exit();
            } else {
                alert.close();
            }
        });
    }

    /**
     * Method responsible for creating the game menu.
     * @return Game menu panel
     */
    public BorderPane createGameMenu(){
        gameStart = new BorderPane();
        startGameMenu = new GridPane();
        hBBottom = new HBox();
        lblUsername = new Label();
        btnStartNewGame = new Button("Start new Game");
        btnLoadGame = new Button("Load game");
        btnShowPersonalScores = new Button("Show personal scores");
        btnShowRanking = new Button("Ranking (TOP 10)");
        hBTitle = new HBox(lblUsername);
        btnQuit = new Button("Quit");

        gameStart.setStyle("-fx-background-color: #A9F8FB");
        lblUsername.setText("Hello "+ game.getPlayer().getNickName());
        lblUsername.setFont(lblUsernameFont);
        lblUsername.setTextAlignment(TextAlignment.CENTER);
        lblUsername.setAlignment(Pos.TOP_CENTER);
        lblUsername.setPadding(new Insets(50,0,0,0));
        hBTitle.setPadding(new Insets(30,0,0,0));
        hBTitle.setAlignment(Pos.TOP_CENTER);
        gameStart.setTop(hBTitle);

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
        startGameMenu.add(btnShowPersonalScores,0,1);
        startGameMenu.add(btnShowRanking,1,1);
        startGameMenu.setAlignment(Pos.TOP_CENTER);
        startGameMenu.setPadding(new Insets(80,0,0,0));
        startGameMenu.setVgap(5);
        startGameMenu.setHgap(5);

        btnQuit.setCursor(Cursor.HAND);
        btnQuit.setMinWidth(50);
        btnQuit.setPadding(new Insets(5,0,5,0));

        hBBottom.getChildren().add(btnQuit);
        hBBottom.setAlignment(Pos.BOTTOM_RIGHT);
        hBBottom.setPadding(new Insets(0,5,5,0));
        gameStart.setBottom(hBBottom);

        gameStart.setCenter(startGameMenu);

        btnShowPersonalScores.setOnAction((event) -> {
            Stage primaryStage = new Stage();
            Scene scene = new Scene(new PersonalScoresPane(game.getPersonalScores().getScores()), 300, 500);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            primaryStage.setX(50);
            primaryStage.setY(50);
        });

        btnShowRanking.setOnAction((event) -> {
            game.loadTop10Scores();
            if(game.getTop10() != null) {
                Stage primaryStage = new Stage();
                Scene scene = new Scene(new RankingPane(game.getTop10().getScores()), 300, 500);
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
                primaryStage.setX(50);
                primaryStage.setY(50);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Blocku Docku");
                alert.setHeaderText("Error!");
                alert.setContentText("There are no Top 10 scores");
                alert.showAndWait();
            }
        });

        btnLoadGame.setOnAction((event) -> {
            TextInputDialog window = new TextInputDialog("User");
            window.setTitle("Save Manager");
            window.setHeaderText("Input the name of your save.\n(Your username only)");
            Optional<String> resultado = window.showAndWait();
            String username;
            if(resultado.isPresent()) {
                username = resultado.get();
                Game load = (BlockGame.Game) RWFile.loadData("saves/" + username + ".sav");
                if (load != null) {
                    game = load;
                    getChildren().remove(gameStart);
                    getChildren().add(new GameBoard(game));
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Blocku Docku");
                    alert.setHeaderText("Error!");
                    alert.setContentText("There are no saves with this name!");
                    alert.showAndWait();
                }
            }});


        return gameStart;
    }

    /**
     * Method responsible for creating the difficulty menu panels.
     * @return Difficulty menu panel.
     */
    public BorderPane createDifficultyMenu() {
        gameDifficultyMenu = new BorderPane();
        gameDifficulty = new GridPane();
        hBBottom = new HBox();
        btnNewBasicGameMode = new Button("Start new Game\n- Basic Mode");
        btnNewAdvancedGameMode = new Button("Start new Game\n- Advanced Mode");
        gameDifficultyMenu.setStyle("-fx-background-color: #A9F8FB");
        btnBack = new Button("Back");

        lblUsername.setText("Choose a game\nDificulty");
        lblUsername.setFont(lblUsernameFont);
        lblUsername.setTextAlignment(TextAlignment.CENTER);
        lblUsername.setAlignment(Pos.TOP_CENTER);
        lblUsername.setPadding(new Insets(20,0,0,0));
        hBTitle.setAlignment(Pos.TOP_CENTER);
        gameDifficultyMenu.setTop(hBTitle);

        btnNewBasicGameMode.setMinWidth(150);
        btnNewBasicGameMode.setCursor(Cursor.HAND);
        btnNewBasicGameMode.setPadding(new Insets(10,0,10,0));
        btnNewBasicGameMode.setTextAlignment(TextAlignment.CENTER);

        btnNewAdvancedGameMode.setMinWidth(150);
        btnNewAdvancedGameMode.setCursor(Cursor.HAND);
        btnNewAdvancedGameMode.setPadding(new Insets(10,0,10,0));
        btnNewAdvancedGameMode.setTextAlignment(TextAlignment.CENTER);

        gameDifficulty.add(btnNewBasicGameMode,0,0);
        gameDifficulty.add(btnNewAdvancedGameMode,1,0);
        gameDifficulty.setAlignment(Pos.TOP_CENTER);
        gameDifficulty.setVgap(5);
        gameDifficulty.setHgap(5);
        gameDifficulty.setPadding(new Insets(50,0,10,0));
        gameDifficultyMenu.setCenter(gameDifficulty);


        btnBack.setCursor(Cursor.HAND);
        btnBack.setMinWidth(50);
        btnBack.setPadding(new Insets(5,0,5,0));

        hBBottom.getChildren().add(btnBack);
        hBBottom.setPadding(new Insets(0,0,5,5));
        gameDifficultyMenu.setBottom(hBBottom);

        btnNewBasicGameMode.setOnAction((event) -> {
            getChildren().remove(gameDifficultyMenu);
            game.setGameMode(Mode.BASIC);
            game.createPlayableBlocks(Mode.BASIC);
            this.game.reset();
            getChildren().add(new GameBoard(game));
        });

        btnNewAdvancedGameMode.setOnAction((event) -> {
            getChildren().remove(gameDifficultyMenu);
            game.setGameMode(Mode.ADVANCED);
            game.createPlayableBlocks(Mode.ADVANCED);
            this.game.reset();
            getChildren().add(new GameBoard(game));
        });

        return gameDifficultyMenu;
    }

}
