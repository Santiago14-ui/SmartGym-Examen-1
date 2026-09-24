package viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controlador del menú principal de SmartGym.
 *
 * Permite acceder a las diferentes funcionalidades
 * de administración del sistema.
 */
public class MenuViewController {

    /**
     * Abre la ventana de gestión de clientes.
     */
    @FXML
    private void abrirClientes() throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/Cliente.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = new Stage();
        stage.setTitle("SmartGym - Gestión de Clientes");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Abre la ventana de gestión de entrenadores.
     */
    @FXML
    private void abrirEntrenadores() throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/Entrenador.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = new Stage();
        stage.setTitle("SmartGym - Gestión de Entrenadores");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Abre la ventana de gestión de planes.
     */
    @FXML
    private void abrirPlanes() throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/Plan.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = new Stage();
        stage.setTitle("SmartGym - Gestión de Planes");
        stage.setScene(scene);
        stage.show();
    }
}