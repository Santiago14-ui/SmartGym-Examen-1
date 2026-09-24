package viewController;

import controller.GimnasioController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Cliente;
import model.Gimnasio;

import java.time.LocalDate;

/**
 * Controlador de la interfaz gráfica para la gestión de clientes.
 *
 * Permite registrar nuevos clientes, buscar clientes mediante
 * su número de teléfono y verificar si el número ingresado
 * corresponde a un número perfecto.
 */
public class ClienteViewController {

    /**
     * Registrar un cliente.
     */
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtEdad;

    /**
     * Buscar un cliente por teléfono.
     */
    @FXML
    private TextField txtBuscarTelefono;

    /**
     * Mostrar los resultados.
     */
    @FXML
    private Label lblResultado;

    /**
     * Encargado de comunicarse con el gimnasio.
     */
    private GimnasioController gimnasioController;

    /**
     * Constructor del controlador.
     *
     * Obtiene la instancia única del gimnasio mediante el patrón Singleton y crea el controlador correspondiente.
     */
    public ClienteViewController() {
        gimnasioController =
                new GimnasioController(Gimnasio.getInstancia());
    }

    /**
     * Registra un nuevo cliente en el gimnasio utilizando la información ingresada en los campos de la interfaz.
     */
    @FXML
    public void registrarCliente() {

        try {

            String nombre = txtNombre.getText();
            String documento = txtDocumento.getText();
            String telefono = txtTelefono.getText();
            String correo = txtCorreo.getText();
            int edad = Integer.parseInt(txtEdad.getText());

            Cliente cliente = new Cliente(
                    nombre,
                    documento,
                    telefono,
                    correo,
                    edad,
                    LocalDate.now()
            );

            gimnasioController.registrarCliente(cliente);

            lblResultado.setText("Cliente registrado correctamente.");

            limpiarCampos();

        } catch (NumberFormatException e) {

            lblResultado.setText("La edad debe ser un número válido.");

        } catch (Exception e) {

            lblResultado.setText("Error al registrar el cliente.");

        }
    }

    /**
     * Busca un cliente mediante su número de teléfono.
     *
     * También verifica si el número ingresado corresponde
     * a un número perfecto.
     */
    @FXML
    public void buscarCliente() {

        String telefono = txtBuscarTelefono.getText();

        if (telefono.isEmpty()) {
            lblResultado.setText("Ingrese un número de teléfono.");
            return;
        }

        Cliente cliente = gimnasioController.buscarClientePorTelefono(telefono);

        if (cliente != null) {

            boolean esPerfecto = gimnasioController.esNumeroPerfecto(telefono);

            if (esPerfecto) {

                lblResultado.setText(
                        "Cliente encontrado: " +
                                cliente.getNombreCompleto() +
                                "\nEl teléfono corresponde a un número perfecto."
                );

            } else {

                lblResultado.setText(
                        "Cliente encontrado: " +
                                cliente.getNombreCompleto() +
                                "\nEl teléfono no corresponde a un número perfecto."
                );
            }

        } else {

            boolean esPerfecto = gimnasioController.esNumeroPerfecto(telefono);

            if (esPerfecto) {

                lblResultado.setText(
                        "No se encontró el cliente.\n" +
                                "El número ingresado es un número perfecto."
                );

            } else {

                lblResultado.setText(
                        "No se encontró ningún cliente con ese teléfono."
                );
            }
        }
    }

    /**
     * Limpia los campos utilizados para registrar clientes.
     */
    private void limpiarCampos() {

        txtNombre.clear();
        txtDocumento.clear();
        txtTelefono.clear();
        txtCorreo.clear();
        txtEdad.clear();
    }
}