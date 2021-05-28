package App;

import BlockGame.Game;
import GameAssets.Blocks.Block;
import GameAssets.Board;
import GameAssets.Mode;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.text.Font;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Optional;
import java.util.Random;
import java.awt.event.MouseEvent;

/**
 * Class responsible for displaying the in-game ui, along with the board.
 *
 * @author André Dias (190221068) e Tomás Barroso (190221029)
 * @version 1.0
 */
public class GameBoard extends VBox {
    private Game game;
    private Board board;
    private GridPane gridPaneBoard;
    private HBox hBoxPlayableContent;
    private GridPane gridpanePlayableBlockA;
    private GridPane gridpanePlayableBlockB;
    private GridPane gridpanePlayableBlockC;
    private BorderPane paneContent;
    private Color[] colors;
    private Font titleFont;
    private Random random;
    private VBox vBinfo;
    private VBox vBCommand;
    private TextField txtCommand;
    private Button btnSubmit;
    private int n;
    private String[] values;
    private boolean gameOver;
    private Label lblPoints;
    private Label lblRound;

    /**
     * Constructor for class GameBoard, responsible for initializing the game interface.
     * @param game Game to start.
     */
    public GameBoard(Game game) {
        this.game = game;
        gameOver = false;
        vBinfo = new VBox();
        vBCommand = new VBox();
        random = new Random();
        n = random.nextInt(14);
        titleFont = Font.loadFont("file:resources/fonts/Montserrat-Regular.ttf", 14);
        gridPaneBoard = new GridPane();
        paneContent = new BorderPane();
        colors = new Color[]{Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.AQUA, Color.BEIGE, Color.BLUEVIOLET, Color.CORAL, Color.CYAN, Color.DARKBLUE, Color.DARKRED, Color.DARKGOLDENROD, Color.DARKGREEN, Color.DARKSALMON};
        board = this.game.getGameBoard();
        txtCommand = new TextField();
        btnSubmit = new Button("Go");
        hBoxPlayableContent = new HBox();
        hBoxPlayableContent.setSpacing(20);
        hBoxPlayableContent.setPadding(new Insets(10, 0, 0, 0));
        hBoxPlayableContent.setAlignment(Pos.CENTER);
        gridpanePlayableBlockA = new GridPane();
        gridpanePlayableBlockB = new GridPane();
        gridpanePlayableBlockC = new GridPane();
        createGridPaneBoard();
        gridPaneBoard.setGridLinesVisible(true);
        gridPaneBoard.setAlignment(Pos.CENTER);
        paneContent.setTop(gridPaneBoard);
        play();
        createPlayableBlocks();
        hBoxPlayableContent.getChildren().addAll(gridpanePlayableBlockA, gridpanePlayableBlockB, gridpanePlayableBlockC);

        lblPoints = new Label("Points: " + this.game.getPlayer().getScore());
        lblRound = new Label("Round: " + this.game.getRound());
        vBinfo.getChildren().addAll(lblPoints, lblRound);
        vBinfo.setMinHeight(Window.HEIGHT);
        vBinfo.setAlignment(Pos.TOP_LEFT);
        vBinfo.setSpacing(10);

        btnSubmit.setAlignment(Pos.BASELINE_CENTER);
        txtCommand.setMaxWidth(80);
        vBCommand.setSpacing(10);
        vBCommand.getChildren().addAll(txtCommand,btnSubmit);
        vBCommand.setAlignment(Pos.TOP_RIGHT);
        btnSubmit.setOnAction((event) -> {
            String command = txtCommand.getText();
            if(!command.isEmpty()){
                if(this.game.commandIsValid(command)){
                    values = this.game.getValues();
                    char pickedBlock = values[0].charAt(0);
                    char locationY = values[1].charAt(0); //'A'
                    int locationX = Integer.parseInt(String.valueOf(values[1].charAt(1)));// 1
                    if(this.game.executeCommand(pickedBlock,locationX,locationY)) {
                        updatePlayableBlocks(pickedBlock);
                        updateGameBoard();
                        board.show();
                    }
                    this.game.checkForPoints();

                    if(game.getMoves() == 0) {
                        this.game.newRound();
                        createPlayableBlocks();
                    }

                    gameOver = !game.checkPossibleMoves();
                    if(gameOver) {
                        this.game.loadTop10Scores();
                        this.game.insertPersonalScore();
                        this.game.insertTop10Score();
                        this.game.saveTop10Scores();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Blocku Docku");
                        alert.setHeaderText("Game Over!");
                        alert.setContentText("Sorry you are out of moves!");
                        alert.showAndWait();


                        super.getChildren().remove(paneContent);
                        Menu menu = new Menu(game);
                        super.getChildren().add(menu);
                    }

                }
            }
        });


        Label lblTitle = new Label("Playable Blocks");
        lblTitle.setPadding(new Insets(10, 0, 0, 0));
        lblTitle.setFont(titleFont);






        paneContent.setTop(gridPaneBoard);
        paneContent.setCenter(lblTitle);
        paneContent.setBottom(hBoxPlayableContent);
        paneContent.setLeft(vBinfo);
        paneContent.setRight(vBCommand);
        paneContent.setMinWidth(Window.WIDTH);
        paneContent.setMinHeight(Window.HEIGHT);
        getChildren().add(paneContent);
    }

    private void play() {


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {

            lblPoints.setText("Points: " + game.getPlayer().getScore());
            lblRound.setText("Round: " + game.getRound());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void createGridPaneBoard() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board.getBoard()[x][y]) {
                    Rectangle rec = new Rectangle();
                    rec.setWidth(24.5);
                    rec.setHeight(24.5);
                    rec.setFill(colors[n]);
                    gridPaneBoard.add(rec, y, x);
                }
                if(!board.getBoard()[x][y]){
                    Rectangle rec = new Rectangle();
                    rec.setWidth(24.5);
                    rec.setHeight(24.5);
                    rec.setFill(Color.WHITE);
                    gridPaneBoard.add(rec, y, x);
                }
            }
        }
        gridPaneBoard.setGridLinesVisible(true);
        gridPaneBoard.setAlignment(Pos.CENTER);
        paneContent.setTop(gridPaneBoard);
    }

    private void createPlayableBlocks() {
        int a = 0;
        for (Block block : game.getPlayableBlocks()) {
            if (block != null) {
                for (int x = 0; x < block.getRowSize(); x++) {
                    for (int y = 0; y < block.getColumnSize(); y++) {
                        if (block.getContent()[x][y]) {
                            Rectangle rec = new Rectangle();
                            rec.setFill(colors[n]);
                            rec.setWidth(24.5);
                            rec.setHeight(24.5);
                            if (a == 0) gridpanePlayableBlockA.add(rec, y, x);
                            if (a == 1) gridpanePlayableBlockB.add(rec, y, x);
                            if (a == 2) gridpanePlayableBlockC.add(rec, y, x);
                        }
                    }
                }
            }
            a++;
        }

    }


    private void updatePlayableBlocks(char blockPos) {
        switch (Character.toUpperCase(blockPos)) {
            case 'A':
                gridpanePlayableBlockA.getChildren().clear();
                break;
            case 'B':
                gridpanePlayableBlockB.getChildren().clear();
                break;
            case 'C':
                gridpanePlayableBlockC.getChildren().clear();
                break;
        }
    }

    private void updateGameBoard() {
        gridPaneBoard = new GridPane();
        createGridPaneBoard();
    }


}


