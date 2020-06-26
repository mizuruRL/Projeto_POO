package App;

import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

/**
 *
 * @author rcneves
 */
public class JavaFXBlockuDoku extends Application {
    App.Welcome welcome = new App.Welcome();
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(welcome, 400, 400);
        welcome.createContent();
        primaryStage.setTitle("BlockuDocku");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        /*primaryStage.setOnCloseRequest((event) -> {
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
        });*/
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
