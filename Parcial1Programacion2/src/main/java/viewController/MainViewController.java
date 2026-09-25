package viewController;

import controller.GimnasioController;
import controller.InscripcionController;
import factory.FactoryPlan;
import factory.FactoryPlanBasico;
import factory.FactoryPlanPersonalizado;
import factory.FactoryPlanPremium;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import model.*;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Controlador de la vista principal de SmartGym.
 *
 * Esta clase conecta Main.fxml con los controladores de negocio que ya
 * existen en el proyecto. No reemplaza GimnasioController ni
 * InscripcionController: solamente coordina la interfaz gráfica.
 */
public class MainViewController {

    private final GimnasioController gimnasioController =
            new GimnasioController(Gimnasio.getInstancia());

    private final InscripcionController inscripcionController =
            new InscripcionController(Gimnasio.getInstancia());

    private final Gimnasio gimnasio = Gimnasio.getInstancia();

    // =========================
    // NAVEGACIÓN / CABECERA
    // =========================

    @FXML private TabPane tabPane;
    @FXML private Label lblSectionTitle;
    @FXML private Label lblSectionSubtitle;
    @FXML private Label lblDate;
    @FXML private Label lblClock;

    // =========================
    // DASHBOARD
    // =========================

    @FXML private Label lblTotalClientes;
    @FXML private Label lblTotalPlanes;
    @FXML private Label lblTotalEntrenadores;
    @FXML private Label lblTotalInscripciones;
    @FXML private Label lblGymNombre;
    @FXML private Label lblGymNit;
    @FXML private Label lblGymDireccion;
    @FXML private Label lblGymTelefono;

    // =========================
    // CLIENTES
    // =========================

    @FXML private TextField txtClienteNombre;
    @FXML private TextField txtClienteDocumento;
    @FXML private TextField txtClienteTelefono;
    @FXML private TextField txtClienteCorreo;
    @FXML private TextField txtClienteEdad;
    @FXML private DatePicker dpClienteFecha;
    @FXML private TextField txtBuscarCliente;
    @FXML private TableView<Cliente> tablaClientes;

    @FXML private TableColumn<Cliente, String> colClienteNombre;
    @FXML private TableColumn<Cliente, String> colClienteDocumento;
    @FXML private TableColumn<Cliente, String> colClienteTelefono;
    @FXML private TableColumn<Cliente, String> colClienteCorreo;
    @FXML private TableColumn<Cliente, Integer> colClienteEdad;

    // =========================
    // ENTRENADORES
    // =========================

    @FXML private TextField txtEntrenadorId;
    @FXML private TextField txtEntrenadorNombre;
    @FXML private TextField txtEntrenadorEspecialidad;
    @FXML private TextField txtEntrenadorTelefono;
    @FXML private TextField txtEntrenadorTarifa;
    @FXML private TableView<Entrenador> tablaEntrenadores;

    @FXML private TableColumn<Entrenador, String> colEntrenadorId;
    @FXML private TableColumn<Entrenador, String> colEntrenadorNombre;
    @FXML private TableColumn<Entrenador, String> colEntrenadorEspecialidad;
    @FXML private TableColumn<Entrenador, String> colEntrenadorTelefono;
    @FXML private TableColumn<Entrenador, Double> colEntrenadorTarifa;

    // =========================
    // PLANES
    // =========================

    @FXML private TableView<PlanEntrenamiento> tablaPlanes;
    @FXML private TableColumn<PlanEntrenamiento, String> colPlanCodigo;
    @FXML private TableColumn<PlanEntrenamiento, String> colPlanNombre;
    @FXML private TableColumn<PlanEntrenamiento, Integer> colPlanDuracion;
    @FXML private TableColumn<PlanEntrenamiento, Double> colPlanValor;
    @FXML private TableColumn<PlanEntrenamiento, EstadoPlan> colPlanEstado;

    // =========================
    // SERVICIOS
    // =========================

    @FXML private TextField txtServicioCodigo;
    @FXML private TextField txtServicioNombre;
    @FXML private TextField txtServicioDescripcion;
    @FXML private TextField txtServicioPrecio;
    @FXML private TableView<ServicioAdicional> tablaServicios;

    @FXML private TableColumn<ServicioAdicional, String> colServicioCodigo;
    @FXML private TableColumn<ServicioAdicional, String> colServicioNombre;
    @FXML private TableColumn<ServicioAdicional, String> colServicioDescripcion;
    @FXML private TableColumn<ServicioAdicional, Double> colServicioPrecio;

    // =========================
    // INSCRIPCIONES
    // =========================

    @FXML private ComboBox<Cliente> cbCliente;
    @FXML private ComboBox<PlanEntrenamiento> cbPlan;
    @FXML private ComboBox<Entrenador> cbEntrenador;
    @FXML private DatePicker dpInscripcion;
    @FXML private FlowPane serviciosContainer;
    @FXML private Label lblTotalInscripcion;
    @FXML private Label lblInscripcionEstado;
    @FXML private TableView<Inscripcion> tablaInscripciones;

    @FXML private TableColumn<Inscripcion, Cliente> colInscripcionCliente;
    @FXML private TableColumn<Inscripcion, PlanEntrenamiento> colInscripcionPlan;
    @FXML private TableColumn<Inscripcion, Entrenador> colInscripcionEntrenador;
    @FXML private TableColumn<Inscripcion, LocalDateTime> colInscripcionFecha;
    @FXML private TableColumn<Inscripcion, Double> colInscripcionTotal;

    // =========================
    // REPORTES
    // =========================

    @FXML private DatePicker dpIngresoInicio;
    @FXML private DatePicker dpIngresoFin;
    @FXML private Label lblIngresosReporte;
    @FXML private Label lblInscripcionesReporte;
    @FXML private Label lblClientesReporte;
    @FXML private TextField txtNumeroPerfecto;
    @FXML private Label lblResultadoPerfecto;

    private final NumberFormat moneda =
            NumberFormat.getCurrencyInstance(new Locale("es", "CO"));

    @FXML
    private void initialize() {
        LocalDate hoy = LocalDate.now();

        dpClienteFecha.setValue(hoy);
        dpInscripcion.setValue(hoy);
        dpIngresoInicio.setValue(hoy.withDayOfMonth(1));
        dpIngresoFin.setValue(hoy);

        configurarTablas();
        configurarInscripciones();
        actualizarTodo();

        lblDate.setText(hoy.toString());
        lblClock.setText("Sistema activo");
    }

    // =========================
    // CONFIGURACIÓN
    // =========================

    private void configurarTablas() {
        colClienteNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colClienteDocumento.setCellValueFactory(new PropertyValueFactory<>("documentoIdentidad"));
        colClienteTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colClienteCorreo.setCellValueFactory(new PropertyValueFactory<>("correoElectronico"));
        colClienteEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        colEntrenadorId.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        colEntrenadorNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEntrenadorEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        colEntrenadorTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colEntrenadorTarifa.setCellValueFactory(new PropertyValueFactory<>("tarifaPorSesion"));

        colPlanCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colPlanNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPlanDuracion.setCellValueFactory(new PropertyValueFactory<>("duracionMeses"));
        colPlanValor.setCellValueFactory(new PropertyValueFactory<>("valorMensual"));
        colPlanEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        colServicioCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colServicioNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colServicioDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colServicioPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        colInscripcionCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colInscripcionPlan.setCellValueFactory(new PropertyValueFactory<>("plan"));
        colInscripcionEntrenador.setCellValueFactory(new PropertyValueFactory<>("entrenador"));
        colInscripcionFecha.setCellValueFactory(new PropertyValueFactory<>("fechaInscripcion"));
        colInscripcionTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));

        tablaClientes.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, cliente) -> cargarCliente(cliente));
    }

    private void configurarInscripciones() {
        cbCliente.valueProperty().addListener((obs, anterior, nuevo) -> actualizarTotalInscripcion());
        cbPlan.valueProperty().addListener((obs, anterior, nuevo) -> actualizarTotalInscripcion());

        cargarServiciosEnVista();
    }

    private void cargarServiciosEnVista() {
        serviciosContainer.getChildren().clear();

        for (ServicioAdicional servicio : gimnasioController.getListServiciosAdicionales()) {
            CheckBox check = new CheckBox(servicio.getNombre());
            check.setUserData(servicio);
            check.getStyleClass().add("service-check");
            check.selectedProperty().addListener((obs, anterior, nuevo) -> actualizarTotalInscripcion());
            serviciosContainer.getChildren().add(check);
        }
    }

    // =========================
    // NAVEGACIÓN
    // =========================

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

    // =========================
    // CLIENTES
    // =========================

    @FXML
    private void registrarCliente() {
        try {
            String nombre = requerido(txtClienteNombre, "nombre");
            String documento = requerido(txtClienteDocumento, "documento");
            String telefono = requerido(txtClienteTelefono, "teléfono");
            String correo = requerido(txtClienteCorreo, "correo");
            int edad = Integer.parseInt(requerido(txtClienteEdad, "edad"));
            LocalDate fecha = dpClienteFecha.getValue() == null ? LocalDate.now() : dpClienteFecha.getValue();

            if (gimnasioController.buscarClientePorTelefono(telefono) != null) {
                mostrarError("Ya existe un cliente registrado con ese teléfono.");
                return;
            }

            Cliente cliente = new Cliente(nombre, documento, telefono, correo, edad, fecha);
            cliente.setGimnasio(gimnasio);
            gimnasioController.registrarCliente(cliente);

            limpiarCliente();
            actualizarTodo();
            mostrarInfo("Cliente registrado correctamente.");
        } catch (NumberFormatException e) {
            mostrarError("La edad debe ser un número entero válido.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void buscarCliente() {
        String telefono = txtBuscarCliente.getText().trim();
        if (telefono.isEmpty()) {
            mostrarError("Ingrese un teléfono para buscar.");
            return;
        }

        Cliente cliente = gimnasioController.buscarClientePorTelefono(telefono);
        if (cliente == null) {
            mostrarInfo("No se encontró un cliente con ese teléfono.");
            return;
        }

        tablaClientes.getSelectionModel().select(cliente);
        tablaClientes.scrollTo(cliente);
    }

    @FXML
    private void actualizarCliente() {
        Cliente seleccionado = tablaClientes.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarError("Seleccione un cliente en la tabla.");
            return;
        }

        try {
            seleccionado.setNombreCompleto(requerido(txtClienteNombre, "nombre"));
            seleccionado.setTelefono(requerido(txtClienteTelefono, "teléfono"));
            seleccionado.setCorreoElectronico(requerido(txtClienteCorreo, "correo"));
            seleccionado.setEdad(Integer.parseInt(requerido(txtClienteEdad, "edad")));
            seleccionado.setFechaRegistro(dpClienteFecha.getValue());

            gimnasioController.actualizarCliente(seleccionado);
            actualizarTodo();
            mostrarInfo("Cliente actualizado correctamente.");
        } catch (NumberFormatException e) {
            mostrarError("La edad debe ser un número entero válido.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void eliminarCliente() {
        Cliente seleccionado = tablaClientes.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarError("Seleccione un cliente en la tabla.");
            return;
        }

        gimnasioController.eliminarCliente(seleccionado);
        limpiarCliente();
        actualizarTodo();
        mostrarInfo("Cliente eliminado correctamente.");
    }

    @FXML private void limpiarBusquedaCliente() { txtBuscarCliente.clear(); }

    private void cargarCliente(Cliente cliente) {
        if (cliente == null) return;
        txtClienteNombre.setText(cliente.getNombreCompleto());
        txtClienteDocumento.setText(cliente.getDocumentoIdentidad());
        txtClienteTelefono.setText(cliente.getTelefono());
        txtClienteCorreo.setText(cliente.getCorreoElectronico());
        txtClienteEdad.setText(String.valueOf(cliente.getEdad()));
        dpClienteFecha.setValue(cliente.getFechaRegistro());
    }

    private void limpiarCliente() {
        txtClienteNombre.clear();
        txtClienteDocumento.clear();
        txtClienteTelefono.clear();
        txtClienteCorreo.clear();
        txtClienteEdad.clear();
        dpClienteFecha.setValue(LocalDate.now());
        tablaClientes.getSelectionModel().clearSelection();
    }

    // =========================
    // ENTRENADORES
    // =========================

    @FXML
    private void registrarEntrenador() {
        try {
            String id = requerido(txtEntrenadorId, "identificación");
            String nombre = requerido(txtEntrenadorNombre, "nombre");
            String especialidad = requerido(txtEntrenadorEspecialidad, "especialidad");
            String telefono = requerido(txtEntrenadorTelefono, "teléfono");
            double tarifa = Double.parseDouble(requerido(txtEntrenadorTarifa, "tarifa"));

            if (gimnasioController.buscarEntrenadorPorIdentificacion(id) != null) {
                mostrarError("Ya existe un entrenador con esa identificación.");
                return;
            }

            Entrenador entrenador = new Entrenador(id, nombre, especialidad, telefono, tarifa);
            entrenador.setGimnasio(gimnasio);
            gimnasioController.registrarEntrenador(entrenador);

            limpiarEntrenador();
            actualizarTodo();
            mostrarInfo("Entrenador registrado correctamente.");
        } catch (NumberFormatException e) {
            mostrarError("La tarifa debe ser un número válido.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    private void limpiarEntrenador() {
        txtEntrenadorId.clear();
        txtEntrenadorNombre.clear();
        txtEntrenadorEspecialidad.clear();
        txtEntrenadorTelefono.clear();
        txtEntrenadorTarifa.clear();
    }

    // =========================
    // PLANES / FACTORY METHOD
    // =========================

    @FXML
    private void crearPlanBasico() {
        FactoryPlan factory = new FactoryPlanBasico();
        PlanEntrenamiento plan = factory.crearPlan(
                siguienteCodigo("BAS"), "Plan Básico",
                "Plan de entrenamiento básico", 1, 80000,
                EstadoPlan.ACTIVO);

        plan.agregarBeneficio(BeneficioPlan.ACOMPANAMIENTO_ENTRENADOR);
        gimnasioController.registrarPlan(plan);
        actualizarTodo();
        mostrarInfo("Plan Básico registrado correctamente.");
    }

    @FXML
    private void crearPlanPremium() {
        FactoryPlan factory = new FactoryPlanPremium();
        PlanEntrenamiento plan = factory.crearPlan(
                siguienteCodigo("PRE"), "Plan Premium",
                "Plan de entrenamiento premium", 1, 150000,
                EstadoPlan.ACTIVO);

        plan.agregarBeneficio(BeneficioPlan.ACCESO_ZONAS_DEPORTIVAS);
        plan.agregarBeneficio(BeneficioPlan.CLASES_GRUPALES);
        plan.agregarBeneficio(BeneficioPlan.ACOMPANAMIENTO_ENTRENADOR);

        gimnasioController.registrarPlan(plan);
        actualizarTodo();
        mostrarInfo("Plan Premium registrado correctamente.");
    }

    @FXML
    private void crearPlanPersonalizado() {
        FactoryPlanPersonalizado factory = new FactoryPlanPersonalizado();
        PlanEntrenamiento plan = factory.crearPlan(
                siguienteCodigo("PER"), "Plan Personalizado",
                "Plan adaptado a los objetivos del cliente", 1, 200000,
                EstadoPlan.ACTIVO, 8, "Entrenamiento funcional",
                "Mejorar condición física");

        plan.agregarBeneficio(BeneficioPlan.ACCESO_ZONAS_DEPORTIVAS);
        plan.agregarBeneficio(BeneficioPlan.CLASES_GRUPALES);
        plan.agregarBeneficio(BeneficioPlan.ACOMPANAMIENTO_ENTRENADOR);

        gimnasioController.registrarPlan(plan);
        actualizarTodo();
        mostrarInfo("Plan Personalizado registrado correctamente.");
    }

    private String siguienteCodigo(String prefijo) {
        return prefijo + String.format("%03d", gimnasioController.getListPlanEntrenamientos().size() + 1);
    }

    // =========================
    // SERVICIOS
    // =========================

    @FXML
    private void registrarServicio() {
        try {
            String codigo = requerido(txtServicioCodigo, "código");
            String nombre = requerido(txtServicioNombre, "nombre");
            String descripcion = requerido(txtServicioDescripcion, "descripción");
            double precio = Double.parseDouble(requerido(txtServicioPrecio, "precio"));

            ServicioAdicional servicio = new ServicioAdicional(codigo, nombre, descripcion, precio);
            gimnasioController.registrarServicioAdicional(servicio);

            limpiarServicio();
            actualizarTodo();
            cargarServiciosEnVista();
            mostrarInfo("Servicio registrado correctamente.");
        } catch (NumberFormatException e) {
            mostrarError("El precio debe ser un número válido.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    private void limpiarServicio() {
        txtServicioCodigo.clear();
        txtServicioNombre.clear();
        txtServicioDescripcion.clear();
        txtServicioPrecio.clear();
    }

    // =========================
    // INSCRIPCIONES
    // =========================

    @FXML
    private void registrarInscripcion() {
        Cliente cliente = cbCliente.getValue();
        PlanEntrenamiento plan = cbPlan.getValue();
        Entrenador entrenador = cbEntrenador.getValue();

        if (cliente == null || plan == null) {
            mostrarError("Seleccione al menos un cliente y un plan.");
            return;
        }

        LocalDate fecha = dpInscripcion.getValue() == null
                ? LocalDate.now()
                : dpInscripcion.getValue();

        Inscripcion inscripcion = inscripcionController.crearInscripcion(
                fecha.atStartOfDay(), cliente, plan, entrenador);

        for (javafx.scene.Node node : serviciosContainer.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox check = (CheckBox) node;
                if (check.isSelected() && check.getUserData() instanceof ServicioAdicional) {
                    inscripcionController.agregarServicio(
                            inscripcion,
                            (ServicioAdicional) check.getUserData());
                }
            }
        }

        lblInscripcionEstado.setText("INSCRIPCIÓN REGISTRADA");
        actualizarTodo();
        limpiarInscripcion();
        mostrarInfo("Inscripción registrada correctamente.");
    }

    private void actualizarTotalInscripcion() {
        PlanEntrenamiento plan = cbPlan.getValue();
        double total = plan == null ? 0 : plan.calcularValorBase();

        for (javafx.scene.Node node : serviciosContainer.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox check = (CheckBox) node;
                if (check.isSelected() && check.getUserData() instanceof ServicioAdicional) {
                    total += ((ServicioAdicional) check.getUserData()).getPrecio();
                }
            }
        }

        lblTotalInscripcion.setText(moneda.format(total));
    }

    @FXML
    private void limpiarInscripcion() {
        cbCliente.getSelectionModel().clearSelection();
        cbPlan.getSelectionModel().clearSelection();
        cbEntrenador.getSelectionModel().clearSelection();
        dpInscripcion.setValue(LocalDate.now());

        for (javafx.scene.Node node : serviciosContainer.getChildren()) {
            if (node instanceof CheckBox) {
                ((CheckBox) node).setSelected(false);
            }
        }

        lblTotalInscripcion.setText(moneda.format(0));
        lblInscripcionEstado.setText("LISTO PARA REGISTRAR");
    }

    // =========================
    // REPORTES / CONSULTAS
    // =========================

    @FXML
    private void comprobarNumeroPerfecto() {
        try {
            String valor = txtNumeroPerfecto.getText().trim();
            if (valor.isEmpty()) {
                lblResultadoPerfecto.setText("Introduce un número.");
                return;
            }

            boolean perfecto = gimnasioController.esNumeroPerfecto(valor);
            lblResultadoPerfecto.setText(
                    perfecto
                            ? valor + " es un número perfecto."
                            : valor + " no es un número perfecto.");
        } catch (Exception e) {
            lblResultadoPerfecto.setText("Introduce un número entero válido.");
        }
    }

    @FXML
    private void calcularIngresos() {
        if (dpIngresoInicio.getValue() == null || dpIngresoFin.getValue() == null) {
            mostrarError("Seleccione las dos fechas.");
            return;
        }

        if (dpIngresoInicio.getValue().isAfter(dpIngresoFin.getValue())) {
            mostrarError("La fecha inicial no puede ser posterior a la fecha final.");
            return;
        }

        double ingresos = gimnasioController.calcularIngresos(
                dpIngresoInicio.getValue(), dpIngresoFin.getValue());

        lblIngresosReporte.setText(moneda.format(ingresos));
        lblInscripcionesReporte.setText(String.valueOf(gimnasioController.getListInscripciones().size()));
        lblClientesReporte.setText(String.valueOf(gimnasioController.getListClientes().size()));
    }

    // =========================
    // ACTUALIZACIÓN DE LA VISTA
    // =========================

    private void actualizarTodo() {
        actualizarDashboard();
        actualizarTablas();
        actualizarCombos();
        actualizarGym();
    }

    private void actualizarDashboard() {
        lblTotalClientes.setText(String.valueOf(gimnasioController.getListClientes().size()));
        lblTotalPlanes.setText(String.valueOf(gimnasioController.getListPlanEntrenamientos().size()));
        lblTotalEntrenadores.setText(String.valueOf(gimnasioController.getListEntrenadores().size()));
        lblTotalInscripciones.setText(String.valueOf(gimnasioController.getListInscripciones().size()));
    }

    private void actualizarTablas() {
        tablaClientes.setItems(FXCollections.observableArrayList(gimnasioController.getListClientes()));
        tablaEntrenadores.setItems(FXCollections.observableArrayList(gimnasioController.getListEntrenadores()));
        tablaPlanes.setItems(FXCollections.observableArrayList(gimnasioController.getListPlanEntrenamientos()));
        tablaServicios.setItems(FXCollections.observableArrayList(gimnasioController.getListServiciosAdicionales()));
        tablaInscripciones.setItems(FXCollections.observableArrayList(gimnasioController.getListInscripciones()));
    }

    private void actualizarCombos() {
        Cliente clienteSeleccionado = cbCliente.getValue();
        PlanEntrenamiento planSeleccionado = cbPlan.getValue();
        Entrenador entrenadorSeleccionado = cbEntrenador.getValue();

        cbCliente.setItems(FXCollections.observableArrayList(gimnasioController.getListClientes()));
        cbPlan.setItems(FXCollections.observableArrayList(gimnasioController.getListPlanEntrenamientos()));
        cbEntrenador.setItems(FXCollections.observableArrayList(gimnasioController.getListEntrenadores()));

        if (clienteSeleccionado != null && cbCliente.getItems().contains(clienteSeleccionado)) {
            cbCliente.setValue(clienteSeleccionado);
        }
        if (planSeleccionado != null && cbPlan.getItems().contains(planSeleccionado)) {
            cbPlan.setValue(planSeleccionado);
        }
        if (entrenadorSeleccionado != null && cbEntrenador.getItems().contains(entrenadorSeleccionado)) {
            cbEntrenador.setValue(entrenadorSeleccionado);
        }
    }

    private void actualizarGym() {
        lblGymNombre.setText(gimnasio.getNombreComercial());
        lblGymNit.setText("NIT " + gimnasio.getNit());
        lblGymDireccion.setText(gimnasio.getDireccion());
        lblGymTelefono.setText(gimnasio.getTelefono());
    }

    // =========================
    // UTILIDADES
    // =========================

    private String requerido(TextField campo, String nombre) {
        String valor = campo.getText() == null ? "" : campo.getText().trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("El campo " + nombre + " es obligatorio.");
        }
        return valor;
    }

    private void mostrarInfo(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("SmartGym");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("SmartGym - Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
