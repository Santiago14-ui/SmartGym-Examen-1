package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import model.Cliente;
import model.Gimnasio;

import java.time.LocalDate;

/**
 * Controlador de la ventana principal. La lógica de negocio permanece en
 * los controladores/modelos existentes; esta clase se encarga principalmente
 * de navegación y actualización visual.
 */
public class MainController {
    private final Gimnasio gimnasio = Gimnasio.getInstancia();

    @FXML private TabPane tabPane;
    @FXML private Label lblSectionTitle, lblSectionSubtitle, lblDate, lblClock;
    @FXML private Label lblTotalClientes, lblTotalPlanes, lblTotalEntrenadores, lblTotalInscripciones;
    @FXML private Label lblGymNombre, lblGymNit, lblGymDireccion, lblGymTelefono;
    @FXML private DatePicker dpClienteFecha, dpInscripcion, dpIngresoInicio, dpIngresoFin;
    @FXML private TextField txtBuscarCliente, txtNumeroPerfecto;
    @FXML private Label lblResultadoPerfecto, lblIngresosReporte, lblInscripcionesReporte, lblClientesReporte;
    @FXML private Label lblInscripcionEstado, lblTotalInscripcion;
    @FXML private FlowPane serviciosContainer;

    @FXML private void initialize() {
        LocalDate hoy = LocalDate.now();
        dpClienteFecha.setValue(hoy);
        dpInscripcion.setValue(hoy);
        dpIngresoInicio.setValue(hoy.withDayOfMonth(1));
        dpIngresoFin.setValue(hoy);
        actualizarDashboard();
        actualizarGym();
    }

    private void seleccionar(int index, String titulo, String subtitulo) {
        tabPane.getSelectionModel().select(index);
        lblSectionTitle.setText(titulo);
        lblSectionSubtitle.setText(subtitulo);
    }

    @FXML private void irInicio() { seleccionar(0, "Inicio", "Resumen general de SmartGym"); }
    @FXML private void irClientes() { seleccionar(1, "Clientes", "Registro y administración de clientes"); }
    @FXML private void irPlanes() { seleccionar(2, "Planes", "Planes de entrenamiento disponibles"); }
    @FXML private void irEntrenadores() { seleccionar(3, "Entrenadores", "Equipo de profesionales de SmartGym"); }
    @FXML private void irServicios() { seleccionar(4, "Servicios", "Servicios adicionales para las inscripciones"); }
    @FXML private void irInscripciones() { seleccionar(5, "Inscripciones", "Registro y seguimiento de inscripciones"); }
    @FXML private void irReportes() { seleccionar(6, "Reportes", "Consultas e indicadores del gimnasio"); }

    @FXML private void buscarCliente() {
        String telefono = txtBuscarCliente.getText() == null ? "" : txtBuscarCliente.getText().trim();
        if (telefono.isEmpty()) return;
        Cliente cliente = gimnasio.buscarClientePorTelefono(telefono);
        Alert alert = new Alert(cliente == null ? Alert.AlertType.INFORMATION : Alert.AlertType.INFORMATION);
        alert.setTitle("SmartGym");
        alert.setHeaderText(cliente == null ? "Cliente no encontrado" : "Cliente encontrado");
        alert.setContentText(cliente == null ? "No existe un cliente con ese teléfono." : cliente.toString());
        alert.showAndWait();
    }

    @FXML private void limpiarBusquedaCliente() { txtBuscarCliente.clear(); }

    @FXML private void comprobarNumeroPerfecto() {
        try {
            String valor = txtNumeroPerfecto.getText().trim();
            boolean perfecto = gimnasio.esNumeroPerfecto(valor);
            lblResultadoPerfecto.setText(perfecto ? valor + " es un número perfecto." : valor + " no es un número perfecto.");
        } catch (Exception e) {
            lblResultadoPerfecto.setText("Introduce un número entero válido.");
        }
    }

    @FXML private void calcularIngresos() {
        if (dpIngresoInicio.getValue() == null || dpIngresoFin.getValue() == null) return;
        double ingresos = gimnasio.calcularIngresos(dpIngresoInicio.getValue(), dpIngresoFin.getValue());
        lblIngresosReporte.setText(String.format("$ %,.0f", ingresos));
        lblInscripcionesReporte.setText(String.valueOf(gimnasio.getListInscripciones().size()));
        lblClientesReporte.setText(String.valueOf(gimnasio.getListClientes().size()));
    }

    @FXML private void registrarCliente() { actualizarDashboard(); }
    @FXML private void actualizarCliente() { actualizarDashboard(); }
    @FXML private void eliminarCliente() { actualizarDashboard(); }
    @FXML private void registrarEntrenador() { actualizarDashboard(); }
    @FXML private void registrarServicio() { actualizarDashboard(); }
    @FXML private void registrarInscripcion() { actualizarDashboard(); }
    @FXML private void limpiarInscripcion() { lblTotalInscripcion.setText("$ 0"); lblInscripcionEstado.setText("LISTO PARA REGISTRAR"); }
    @FXML private void crearPlanBasico() { actualizarDashboard(); }
    @FXML private void crearPlanPremium() { actualizarDashboard(); }
    @FXML private void crearPlanPersonalizado() { actualizarDashboard(); }

    private void actualizarDashboard() {
        lblTotalClientes.setText(String.valueOf(gimnasio.getListClientes().size()));
        lblTotalPlanes.setText(String.valueOf(gimnasio.getListPlanes().size()));
        lblTotalEntrenadores.setText(String.valueOf(gimnasio.getListEntrenadores().size()));
        lblTotalInscripciones.setText(String.valueOf(gimnasio.getListInscripciones().size()));
    }

    private void actualizarGym() {
        lblGymNombre.setText(gimnasio.getNombreComercial());
        lblGymNit.setText("NIT " + gimnasio.getNit());
        lblGymDireccion.setText(gimnasio.getDireccion());
        lblGymTelefono.setText(gimnasio.getTelefono());
    }
}
