/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author rcneves
 */
public class Welcome extends StackPane {
    private BorderPane borderPane;
    private Button btn;
    private Label lblTitle;
    private HBox hBoxTitle;
    private Font fontTitle;
    private VBox vBoxUserContent;
    private Label lblSubTitle;
    private Font btnFont;
    private TextField txtFieldUsername;
    private Menu menu;
    private Alert alert;

    public Welcome() {
        borderPane = new BorderPane();
        btn = new Button("Continue");
        btnFont = Font.loadFont("file:resources/fonts/Montserrat-Regular.ttf", 10);
        alert = new Alert(Alert.AlertType.INFORMATION);
        lblTitle = new Label("Welcome to\nBlockuDocku");
        fontTitle = Font.loadFont("file:resources/fonts/Montserrat-Regular.ttf", 36);
        hBoxTitle = new HBox(lblTitle);
        lblSubTitle = new Label("Im blocku Docku, who are you?");
        vBoxUserContent = new VBox(lblSubTitle);
        txtFieldUsername = new TextField();
    }

    public void createContent(){


        btn.setOnAction((event) -> {

            if(!txtFieldUsername.getText().isEmpty()) {
                getChildren().remove(borderPane);
                menu = new Menu(txtFieldUsername.getText());
                menu.createContent();
                getChildren().add(menu);
            }else{
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Username cant be empty!");
                alert.showAndWait();
            }
        });


        btn.setFont(btnFont);
        btn.setPadding(new Insets(8,15,8,15));
        btn.setCursor(Cursor.HAND);
        btn.setStyle("-fx-border-width: 0; -fx-border-color: none;-fx-focus-color: transparent;-fx-background-color: #2C363F;-fx-background-radius: 4px;");
        btn.setTextFill(Color.WHITE);

        btn.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event ->  btn.setStyle("-fx-background-color: #668c99;"));
        btn.addEventHandler(MouseEvent.MOUSE_EXITED,
                event ->  btn.setStyle("-fx-background-color: #2C363F;"));

        borderPane.setStyle("-fx-background-color: #B6DCFE");


        lblTitle.setTextFill(Color.web("#ffffff"));

        hBoxTitle.setAlignment(Pos.BOTTOM_CENTER);
        lblTitle.setPadding(new Insets(50,0,0,0));
        lblTitle.setFont(fontTitle);
        lblTitle.setTextAlignment(TextAlignment.CENTER);

        vBoxUserContent.setAlignment(Pos.TOP_CENTER);
        vBoxUserContent.setStyle("-fx-font-size: 16px;");
        lblSubTitle.setTextAlignment(TextAlignment.CENTER);
        lblSubTitle.setPadding(new Insets(50,0,0,0));

        txtFieldUsername.setMaxWidth(220);
        txtFieldUsername.setStyle("-fx-border-width: 0; -fx-border-color: none;-fx-focus-color: transparent;-fx-font-size: 12px;");

        vBoxUserContent.getChildren().addAll(txtFieldUsername,btn);
        vBoxUserContent.setSpacing(10);

        borderPane.setTop(hBoxTitle);
        borderPane.setCenter(vBoxUserContent);

        this.getChildren().add(borderPane);
    }

}
