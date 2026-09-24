package viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Gimnasio;
import model.ServicioAdicional;
import controller.GimnasioController;

/**
 * Controlador para la gestión de servicios adicionales.
 */
public class ServicioAdicionalViewController {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Label lblResultado;

    private GimnasioController gimnasioController;

    /**
     * Inicializa el controlador.
     */
    @FXML
    public void initialize() {
        gimnasioController =
                new GimnasioController(Gimnasio.getInstancia());
    }

    /**
     * Registra un nuevo servicio adicional en el gimnasio.
     */
    @FXML
    private void registrarServicio() {

        if (txtCodigo.getText().isEmpty()
                || txtNombre.getText().isEmpty()
                || txtDescripcion.getText().isEmpty()
                || txtPrecio.getText().isEmpty()) {

            lblResultado.setText("Complete todos los campos.");
            return;
        }

        try {

            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            double precio = Double.parseDouble(txtPrecio.getText());

            ServicioAdicional servicio =
                    new ServicioAdicional(
                            codigo,
                            nombre,
                            descripcion,
                            precio
                    );

            gimnasioController.registrarServicioAdicional(servicio);

            lblResultado.setText(
                    "Servicio registrado correctamente."
            );

            limpiarCampos();

        } catch (NumberFormatException e) {

            lblResultado.setText(
                    "El precio debe ser un número."
            );
        }
    }

    /**
     * Limpia los campos del formulario.
     */
    private void limpiarCampos() {
        txtCodigo.clear();
        txtNombre.clear();
        txtDescripcion.clear();
        txtPrecio.clear();
    }
}