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
 * Permite:
 * - Registrar clientes.
 * - Buscar clientes por documento.
 * - Actualizar clientes.
 * - Eliminar clientes.
 */
public class ClienteViewController {

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

    @FXML
    private TextField txtBuscarDocumento;

    @FXML
    private Label lblResultado;

    private GimnasioController gimnasioController;

    /**
     * Constructor del controlador.
     */
    public ClienteViewController() {
        gimnasioController =
                new GimnasioController(Gimnasio.getInstancia());
    }

    /**
     * Registra un nuevo cliente.
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
     * Busca un cliente mediante su documento.
     */
    @FXML
    public void buscarCliente() {

        String documento = txtBuscarDocumento.getText();

        if (documento.isEmpty()) {

            lblResultado.setText("Ingrese un documento.");
            return;
        }

        Cliente cliente = buscarClientePorDocumento(documento);

        if (cliente != null) {

            txtNombre.setText(cliente.getNombreCompleto());
            txtDocumento.setText(cliente.getDocumentoIdentidad());
            txtTelefono.setText(cliente.getTelefono());
            txtCorreo.setText(cliente.getCorreoElectronico());
            txtEdad.setText(String.valueOf(cliente.getEdad()));

            lblResultado.setText(
                    "Cliente encontrado: " + cliente.getNombreCompleto()
            );

        } else {

            lblResultado.setText(
                    "No se encontró ningún cliente con ese documento."
            );
        }
    }

    /**
     * Actualiza los datos del cliente seleccionado.
     */
    @FXML
    public void actualizarCliente() {

        try {

            String nombre = txtNombre.getText();
            String documento = txtDocumento.getText();
            String telefono = txtTelefono.getText();
            String correo = txtCorreo.getText();
            int edad = Integer.parseInt(txtEdad.getText());

            Cliente clienteExistente =
                    buscarClientePorDocumento(documento);

            if (clienteExistente == null) {

                lblResultado.setText(
                        "No existe un cliente con ese documento."
                );

                return;
            }

            clienteExistente.setNombreCompleto(nombre);
            clienteExistente.setTelefono(telefono);
            clienteExistente.setCorreoElectronico(correo);
            clienteExistente.setEdad(edad);

            gimnasioController.actualizarCliente(clienteExistente);

            lblResultado.setText(
                    "Cliente actualizado correctamente."
            );

        } catch (NumberFormatException e) {

            lblResultado.setText(
                    "La edad debe ser un número válido."
            );

        } catch (Exception e) {

            lblResultado.setText(
                    "Error al actualizar el cliente."
            );
        }
    }

    /**
     * Elimina un cliente utilizando su documento.
     */
    @FXML
    public void eliminarCliente() {

        String documento = txtDocumento.getText();

        if (documento.isEmpty()) {

            lblResultado.setText(
                    "Ingrese o busque un cliente primero."
            );

            return;
        }

        Cliente cliente =
                buscarClientePorDocumento(documento);

        if (cliente != null) {

            gimnasioController.eliminarCliente(cliente);

            lblResultado.setText(
                    "Cliente eliminado correctamente."
            );

            limpiarCampos();

        } else {

            lblResultado.setText(
                    "No se encontró el cliente."
            );
        }
    }

    /**
     * Busca un cliente por documento.
     */
    private Cliente buscarClientePorDocumento(String documento) {

        for (Cliente cliente :
                gimnasioController.getListClientes()) {

            if (cliente.getDocumentoIdentidad()
                    .equals(documento)) {

                return cliente;
            }
        }

        return null;
    }

    /**
     * Limpia los campos del formulario.
     */
    private void limpiarCampos() {

        txtNombre.clear();
        txtDocumento.clear();
        txtTelefono.clear();
        txtCorreo.clear();
        txtEdad.clear();
        txtBuscarDocumento.clear();
    }
}