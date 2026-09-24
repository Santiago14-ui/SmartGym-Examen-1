package viewController;

import controller.GimnasioController;
import model.Entrenador;
import model.Gimnasio;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * Controlador de la vista de entrenadores.
 *
 * Permite registrar entrenadores en el sistema SmartGym.
 */
public class EntrenadorViewController {

    private GimnasioController gimnasioController;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtTarifaPorSesion;

    /**
     * Inicializa el controlador.
     */
    @FXML
    public void initialize() {
        gimnasioController = new GimnasioController(Gimnasio.getInstancia());
    }

    /**
     * Registra un nuevo entrenador en el gimnasio.
     */
    @FXML
    private void registrarEntrenador() {

        try {

            String identificacion = txtIdentificacion.getText();
            String nombre = txtNombre.getText();
            String especialidad = txtEspecialidad.getText();
            String telefono = txtTelefono.getText();
            double tarifaPorSesion = Double.parseDouble(txtTarifaPorSesion.getText());

            Entrenador entrenador = new Entrenador(
                    identificacion,
                    nombre,
                    especialidad,
                    telefono,
                    tarifaPorSesion
            );

            gimnasioController.registrarEntrenador(entrenador);

            mostrarMensaje(
                    "Registro exitoso",
                    "El entrenador fue registrado correctamente."
            );

            limpiarCampos();

        } catch (NumberFormatException e) {

            mostrarMensaje(
                    "Error",
                    "La tarifa por sesión debe ser un número válido."
            );
        }
    }

    /**
     * Limpia los campos de la interfaz.
     */
    private void limpiarCampos() {
        txtIdentificacion.clear();
        txtNombre.clear();
        txtEspecialidad.clear();
        txtTelefono.clear();
        txtTarifaPorSesion.clear();
    }

    /**
     * Muestra un mensaje al usuario.
     */
    private void mostrarMensaje(String titulo, String mensaje) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}