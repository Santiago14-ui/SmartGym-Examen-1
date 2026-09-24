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
 * Permite registrar, consultar, actualizar y eliminar
 * entrenadores en el sistema SmartGym.
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

    @FXML
    private TextField txtBuscarIdentificacion;

    /**
     * Inicializa el controlador.
     */
    @FXML
    public void initialize() {

        gimnasioController =
                new GimnasioController(Gimnasio.getInstancia());
    }

    /**
     * Registra un nuevo entrenador.
     */
    @FXML
    private void registrarEntrenador() {

        try {

            String identificacion = txtIdentificacion.getText();
            String nombre = txtNombre.getText();
            String especialidad = txtEspecialidad.getText();
            String telefono = txtTelefono.getText();

            double tarifaPorSesion =
                    Double.parseDouble(txtTarifaPorSesion.getText());

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
     * Busca un entrenador mediante su identificación.
     */
    @FXML
    private void buscarEntrenador() {

        String identificacion = txtBuscarIdentificacion.getText();

        if (identificacion.isEmpty()) {

            mostrarMensaje(
                    "Error",
                    "Ingrese la identificación del entrenador."
            );

            return;
        }

        Entrenador entrenador =
                gimnasioController.buscarEntrenadorPorIdentificacion(
                        identificacion
                );

        if (entrenador != null) {

            txtIdentificacion.setText(entrenador.getIdentificacion());
            txtNombre.setText(entrenador.getNombre());
            txtEspecialidad.setText(entrenador.getEspecialidad());
            txtTelefono.setText(entrenador.getTelefono());
            txtTarifaPorSesion.setText(
                    String.valueOf(entrenador.getTarifaPorSesion())
            );

            mostrarMensaje(
                    "Entrenador encontrado",
                    "Los datos del entrenador fueron cargados."
            );

        } else {

            mostrarMensaje(
                    "No encontrado",
                    "No existe un entrenador con esa identificación."
            );
        }
    }

    /**
     * Actualiza los datos del entrenador.
     */
    @FXML
    private void actualizarEntrenador() {

        try {

            String identificacion = txtIdentificacion.getText();
            String nombre = txtNombre.getText();
            String especialidad = txtEspecialidad.getText();
            String telefono = txtTelefono.getText();

            double tarifaPorSesion =
                    Double.parseDouble(txtTarifaPorSesion.getText());

            Entrenador entrenadorExistente =
                    gimnasioController.buscarEntrenadorPorIdentificacion(
                            identificacion
                    );

            if (entrenadorExistente == null) {

                mostrarMensaje(
                        "Error",
                        "No existe un entrenador con esa identificación."
                );

                return;
            }

            entrenadorExistente.setNombre(nombre);
            entrenadorExistente.setEspecialidad(especialidad);
            entrenadorExistente.setTelefono(telefono);
            entrenadorExistente.setTarifaPorSesion(tarifaPorSesion);

            gimnasioController.actualizarEntrenador(
                    entrenadorExistente
            );

            mostrarMensaje(
                    "Actualización exitosa",
                    "El entrenador fue actualizado correctamente."
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
     * Elimina un entrenador.
     */
    @FXML
    private void eliminarEntrenador() {

        String identificacion = txtIdentificacion.getText();

        if (identificacion.isEmpty()) {

            mostrarMensaje(
                    "Error",
                    "Ingrese la identificación del entrenador."
            );

            return;
        }

        Entrenador entrenador =
                gimnasioController.buscarEntrenadorPorIdentificacion(
                        identificacion
                );

        if (entrenador != null) {

            gimnasioController.eliminarEntrenador(entrenador);

            mostrarMensaje(
                    "Eliminación exitosa",
                    "El entrenador fue eliminado correctamente."
            );

            limpiarCampos();

        } else {

            mostrarMensaje(
                    "No encontrado",
                    "No existe un entrenador con esa identificación."
            );
        }
    }

    /**
     * Limpia los campos de la interfaz.
     */
    @FXML
    private void limpiarCampos() {

        txtIdentificacion.clear();
        txtNombre.clear();
        txtEspecialidad.clear();
        txtTelefono.clear();
        txtTarifaPorSesion.clear();
        txtBuscarIdentificacion.clear();
    }

    /**
     * Muestra un mensaje al usuario.
     */
    private void mostrarMensaje(String titulo, String mensaje) {

        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}