import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.Objects;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        WebView view = new WebView();
        WebEngine engine = view.getEngine();
        engine.load(Objects.requireNonNull(getClass().getResource("/front_end/index.html")).toExternalForm());

        engine.setOnAlert(e -> {
            System.out.println("received: " + e.getData());
        });

        stage.setScene(new Scene(view, 960, 540));
        stage.show();

    }
}