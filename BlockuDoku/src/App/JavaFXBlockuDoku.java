package App;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
