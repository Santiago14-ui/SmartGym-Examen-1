package viewController;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Gimnasio;
import model.Inscripcion;

public class InscripcionesRegistradasViewController {

    @FXML
    private ListView<String> listaInscripciones;

    @FXML
    public void initialize() {

        listaInscripciones.getItems().clear();

        for (Inscripcion inscripcion :
                Gimnasio.getInstancia().getListInscripciones()) {

            listaInscripciones.getItems().add(
                    "Cliente: " + inscripcion.getCliente()
                            + " | Plan: " + inscripcion.getPlan().getNombre()
                            + " | Entrenador: " + inscripcion.getEntrenador()
                            + " | Fecha: " + inscripcion.getFechaInscripcion()
                            + " | Total: $" + inscripcion.getValorTotal()
            );
        }
    }

    @FXML
    private void cerrarVentana() {

        Stage stage = (Stage) listaInscripciones.getScene().getWindow();

        stage.close();
    }
}