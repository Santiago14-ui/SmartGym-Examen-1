package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación SmartGym.
 *
 * Se encarga de iniciar la aplicación JavaFX
 * y cargar el menú principal del sistema.
 */
public class App extends Application {

    /**
     * Inicia la aplicación JavaFX.
     */
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("/fxml/Menu.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("SmartGym - Menú Principal");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Punto de entrada de la aplicación.
     */
    public static void main(String[] args) {
        launch();
    }
}