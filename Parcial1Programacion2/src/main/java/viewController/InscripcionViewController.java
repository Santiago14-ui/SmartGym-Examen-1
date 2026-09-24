package viewController;

import controller.GimnasioController;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Cliente;
import model.Entrenador;
import model.Gimnasio;
import model.Inscripcion;
import model.PlanEntrenamiento;
import model.ServicioAdicional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Controlador de la vista de inscripciones.
 *
 * Permite registrar la inscripción de un cliente a un plan
 * de entrenamiento, asignar un entrenador y agregar un
 * servicio adicional.
 */
public class InscripcionViewController {

    private GimnasioController gimnasioController;

    @FXML
    private ComboBox<Cliente> cmbCliente;

    @FXML
    private ComboBox<PlanEntrenamiento> cmbPlan;

    @FXML
    private ComboBox<Entrenador> cmbEntrenador;

    @FXML
    private ComboBox<ServicioAdicional> cmbServicioAdicional;


    /**
     * Inicializa el controlador.
     */
    @FXML
    public void initialize() {

        gimnasioController =
                new GimnasioController(Gimnasio.getInstancia());

        cargarClientes();
        cargarPlanes();
        cargarEntrenadores();
        cargarServiciosAdicionales();
    }


    /**
     * Carga los clientes registrados.
     */
    private void cargarClientes() {

        cmbCliente.getItems().clear();

        cmbCliente.getItems().addAll(
                gimnasioController.getListClientes()
        );
    }


    /**
     * Carga los planes registrados.
     */
    private void cargarPlanes() {

        cmbPlan.getItems().clear();

        cmbPlan.getItems().addAll(
                gimnasioController.getListPlanEntrenamientos()
        );
    }


    /**
     * Carga los entrenadores registrados.
     */
    private void cargarEntrenadores() {

        cmbEntrenador.getItems().clear();

        cmbEntrenador.getItems().addAll(
                gimnasioController.getListEntrenadores()
        );
    }


    /**
     * Carga los servicios adicionales registrados.
     */
    private void cargarServiciosAdicionales() {

        cmbServicioAdicional.getItems().clear();

        cmbServicioAdicional.getItems().addAll(
                gimnasioController.getListServiciosAdicionales()
        );
    }


    /**
     * Registra una nueva inscripción.
     */
    @FXML
    private void registrarInscripcion() {

        try {

            Cliente cliente = cmbCliente.getValue();
            PlanEntrenamiento plan = cmbPlan.getValue();
            Entrenador entrenador = cmbEntrenador.getValue();
            ServicioAdicional servicio =
                    cmbServicioAdicional.getValue();


            if (cliente == null ||
                    plan == null ||
                    entrenador == null) {

                mostrarMensaje(
                        "Error",
                        "Debe seleccionar cliente, plan y entrenador."
                );

                return;
            }


            // Fecha y hora actuales
            LocalDateTime fechaHora = LocalDateTime.now();


            // Crear inscripción
            Inscripcion inscripcion = new Inscripcion(
                    fechaHora,
                    cliente,
                    plan,
                    entrenador
            );


            // Servicio adicional opcional
            if (servicio != null) {
                inscripcion.agregarServicio(servicio);
            }


            // Registrar inscripción
            gimnasioController.registrarInscripcion(inscripcion);


            // Mostrar factura
            mostrarFactura(inscripcion);


            // Limpiar campos
            limpiarCampos();


        } catch (Exception e) {

            mostrarMensaje(
                    "Error",
                    "No fue posible registrar la inscripción: "
                            + e.getMessage()
            );
        }
    }


    /**
     * Muestra el comprobante de inscripción
     * con apariencia de factura.
     */
    private void mostrarFactura(Inscripcion inscripcion) {

        Stage facturaStage = new Stage();

        facturaStage.initModality(Modality.APPLICATION_MODAL);
        facturaStage.setTitle("SmartGym - Comprobante de inscripción");

        VBox principal = new VBox(10);
        principal.setPadding(new Insets(25));
        principal.setPrefWidth(480);

        /*
         * ENCABEZADO
         */

        Label titulo = new Label("SMARTGYM");
        titulo.setStyle(
                "-fx-font-size: 26px;" +
                        "-fx-font-weight: bold;"
        );

        Label subtitulo = new Label(
                "COMPROBANTE DE INSCRIPCIÓN"
        );

        subtitulo.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;"
        );

        VBox encabezado = new VBox(5);
        encabezado.setAlignment(Pos.CENTER);
        encabezado.getChildren().addAll(
                titulo,
                subtitulo
        );


        /*
         * FECHA Y HORA
         */

        DateTimeFormatter formatoFecha =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter formatoHora =
                DateTimeFormatter.ofPattern("HH:mm:ss");

        Label fecha = new Label(
                "Fecha: "
                        + inscripcion.getFechaInscripcion()
                        .format(formatoFecha)
        );

        Label hora = new Label(
                "Hora: "
                        + inscripcion.getFechaInscripcion()
                        .format(formatoHora)
        );


        /*
         * SEPARADOR
         */

        Label separador1 = new Label(
                "────────────────────────────────"
        );


        /*
         * DATOS DEL CLIENTE
         */

        Label tituloCliente =
                new Label("DATOS DEL CLIENTE");

        tituloCliente.setStyle(
                "-fx-font-weight: bold;" +
                        "-fx-font-size: 14px;"
        );

        Label cliente = new Label(
                "Cliente: " + inscripcion.getCliente()
        );


        /*
         * DATOS DEL PLAN
         */

        Label tituloPlan =
                new Label("DATOS DEL PLAN");

        tituloPlan.setStyle(
                "-fx-font-weight: bold;" +
                        "-fx-font-size: 14px;"
        );

        Label nombrePlan = new Label(
                "Plan: " + inscripcion.getPlan().getNombre()
        );

        Label duracion = new Label(
                "Duración: "
                        + inscripcion.getPlan().getDuracionMeses()
                        + " meses"
        );

        Label valorMensual = new Label(
                "Valor mensual: $"
                        + String.format(
                        "%.2f",
                        inscripcion.getPlan().getValorMensual()
                )
        );

        Label entrenador = new Label(
                "Entrenador: "
                        + inscripcion.getEntrenador()
        );


        /*
         * SERVICIO ADICIONAL
         */

        Label tituloServicios =
                new Label("SERVICIOS ADICIONALES");

        tituloServicios.setStyle(
                "-fx-font-weight: bold;" +
                        "-fx-font-size: 14px;"
        );

        VBox serviciosBox = new VBox(5);

        if (inscripcion.getServiciosAdicionales().isEmpty()) {

            serviciosBox.getChildren().add(
                    new Label("No se seleccionaron servicios adicionales.")
            );

        } else {

            for (ServicioAdicional servicio :
                    inscripcion.getServiciosAdicionales()) {

                Label servicioLabel = new Label(
                        servicio.getNombre()
                                + " - $"
                                + String.format(
                                "%.2f",
                                servicio.getPrecio()
                        )
                );

                serviciosBox.getChildren().add(
                        servicioLabel
                );
            }
        }


        /*
         * TOTAL
         */

        Label separador2 = new Label(
                "────────────────────────────────"
        );

        Label total = new Label(
                "TOTAL: $"
                        + String.format(
                        "%.2f",
                        inscripcion.getValorTotal()
                )
        );

        total.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;"
        );


        /*
         * MENSAJE FINAL
         */

        Label gracias = new Label(
                "¡Gracias por elegir SmartGym!"
        );

        gracias.setStyle(
                "-fx-font-weight: bold;" +
                        "-fx-font-size: 14px;"
        );

        gracias.setAlignment(Pos.CENTER);


        /*
         * BOTÓN CERRAR
         */

        Button cerrar = new Button("Cerrar");

        cerrar.setPrefWidth(100);

        cerrar.setOnAction(event ->
                facturaStage.close()
        );

        HBox botonBox = new HBox(cerrar);
        botonBox.setAlignment(Pos.CENTER);


        /*
         * AGREGAR TODO A LA FACTURA
         */

        principal.getChildren().addAll(

                encabezado,

                fecha,
                hora,

                separador1,

                tituloCliente,
                cliente,

                tituloPlan,
                nombrePlan,
                duracion,
                valorMensual,
                entrenador,

                tituloServicios,
                serviciosBox,

                separador2,

                total,
                gracias,
                botonBox
        );


        /*
         * ESCENA
         */

        Scene escena = new Scene(
                principal,
                480,
                600
        );


        facturaStage.setScene(escena);

        facturaStage.showAndWait();
    }


    /**
     * Limpia los campos de la vista.
     */
    private void limpiarCampos() {

        cmbCliente.setValue(null);
        cmbPlan.setValue(null);
        cmbEntrenador.setValue(null);
        cmbServicioAdicional.setValue(null);
    }


    /**
     * Muestra mensajes de error.
     */
    private void mostrarMensaje(
            String titulo,
            String mensaje) {

        Alert alert =
                new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}