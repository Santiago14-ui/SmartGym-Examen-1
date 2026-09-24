package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación SmartGym.
 *
 * Se encarga de iniciar la aplicación JavaFX
 * y cargar la interfaz gráfica de clientes.
 */
public class App extends Application {

    /**
     * Inicia la aplicación JavaFX.
     *
     * @param stage ventana principal de la aplicación
     * @throws Exception si ocurre un error al cargar el archivo FXML
     */
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("/fxml/Cliente.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("SmartGym - Gestión de Clientes");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args argumentos de la aplicación
     */
    public static void main(String[] args) {
        launch();
    }
}