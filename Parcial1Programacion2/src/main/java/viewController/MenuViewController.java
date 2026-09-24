package viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador del menú principal de SmartGym.
 */
public class MenuViewController {

    /**
     * Abre la ventana de gestión de clientes.
     */
    public void abrirClientes(ActionEvent event) {
        abrirVentana("/fxml/Cliente.fxml", "Gestión de Clientes");
    }

    /**
     * Abre la ventana de gestión de entrenadores.
     */
    public void abrirEntrenadores(ActionEvent event) {
        abrirVentana("/fxml/Entrenador.fxml", "Gestión de Entrenadores");
    }

    /**
     * Abre la ventana de gestión de planes.
     */
    public void abrirPlanes(ActionEvent event) {
        abrirVentana("/fxml/Plan.fxml", "Gestión de Planes");
    }

    /**
     * Abre la ventana de gestión de servicios adicionales.
     */
    public void abrirServiciosAdicionales(ActionEvent event) {
        abrirVentana(
                "/fxml/ServicioAdicional.fxml",
                "Gestión de Servicios Adicionales"
        );
    }

    /**
     * Abre la ventana de gestión de inscripciones.
     */
    public void abrirInscripciones(ActionEvent event) {
        abrirVentana(
                "/fxml/Inscripcion.fxml",
                "Gestión de Inscripciones"
        );
    }
    /**
     * Abre la ventana de reporte de ingresos.
     */
    public void abrirReporteIngresos(ActionEvent event) {
        abrirVentana(
                "/fxml/Ingresos.fxml",
                "Reporte de Ingresos"
        );
    }
    /**
     * Abre una ventana de la aplicación.
     *
     * @param ruta Ruta del archivo FXML.
     * @param titulo Título de la ventana.
     */

    private void abrirVentana(String ruta, String titulo) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(ruta)
            );

            Parent root = loader.load();

            Stage stage = new Stage();

            stage.setTitle("SmartGym - " + titulo);

            stage.setScene(
                    new Scene(root)
            );

            stage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public void abrirIngresos(ActionEvent event) {
        abrirVentana(
                "/fxml/Ingresos.fxml",
                "Consulta de Ingresos"
        );
    }

    public void abrirInscripcionesRegistradas(ActionEvent event) {
        abrirVentana(
                "/fxml/InscripcionesRegistradas.fxml",
                "Inscripciones Registradas"
        );
    }
}