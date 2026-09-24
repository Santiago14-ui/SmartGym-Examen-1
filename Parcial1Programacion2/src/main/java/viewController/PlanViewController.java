package viewController;

import controller.GimnasioController;
import factory.FactoryPlan;
import factory.FactoryPlanBasico;
import factory.FactoryPlanPersonalizado;
import factory.FactoryPlanPremium;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.EstadoPlan;
import model.Gimnasio;
import model.PlanEntrenamiento;

/**
 * Controlador de la vista de planes de entrenamiento.
 *
 * Permite registrar planes básicos, premium y personalizados
 * utilizando el patrón Factory Method.
 */
public class PlanViewController {

    private GimnasioController gimnasioController;

    @FXML
    private ComboBox<String> cmbTipoPlan;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtDuracion;

    @FXML
    private TextField txtValorMensual;

    @FXML
    private ComboBox<EstadoPlan> cmbEstado;

    @FXML
    private VBox panelPersonalizado;

    @FXML
    private TextField txtSesiones;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtObjetivos;

    /**
     * Inicializa el controlador.
     */
    @FXML
    public void initialize() {

        gimnasioController =
                new GimnasioController(Gimnasio.getInstancia());

        cmbTipoPlan.getItems().addAll(
                "Básico",
                "Premium",
                "Personalizado"
        );

        cmbEstado.getItems().addAll(
                EstadoPlan.values()
        );

        cmbTipoPlan.setValue("Básico");
        cmbEstado.setValue(EstadoPlan.ACTIVO);

        // Inicialmente se ocultan los campos personalizados.
        panelPersonalizado.setVisible(false);
        panelPersonalizado.setManaged(false);

        // Detecta cuando cambia el tipo de plan.
        cmbTipoPlan.valueProperty().addListener(
                (observable, valorAnterior, nuevoValor) -> {

                    boolean esPersonalizado =
                            "Personalizado".equals(nuevoValor);

                    panelPersonalizado.setVisible(esPersonalizado);
                    panelPersonalizado.setManaged(esPersonalizado);
                }
        );
    }

    /**
     * Registra un nuevo plan de entrenamiento.
     */
    @FXML
    private void registrarPlan() {

        try {

            String tipoPlan = cmbTipoPlan.getValue();
            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();

            int duracionMeses =
                    Integer.parseInt(txtDuracion.getText());

            double valorMensual =
                    Double.parseDouble(txtValorMensual.getText());

            EstadoPlan estado =
                    cmbEstado.getValue();

            PlanEntrenamiento plan;

            if ("Básico".equals(tipoPlan)) {

                FactoryPlan factory =
                        new FactoryPlanBasico();

                plan = factory.crearPlan(
                        codigo,
                        nombre,
                        descripcion,
                        duracionMeses,
                        valorMensual,
                        estado
                );

            } else if ("Premium".equals(tipoPlan)) {

                FactoryPlan factory =
                        new FactoryPlanPremium();

                plan = factory.crearPlan(
                        codigo,
                        nombre,
                        descripcion,
                        duracionMeses,
                        valorMensual,
                        estado
                );

            } else {

                int sesiones =
                        Integer.parseInt(txtSesiones.getText());

                String especialidad =
                        txtEspecialidad.getText();

                String objetivos =
                        txtObjetivos.getText();

                FactoryPlanPersonalizado factory =
                        new FactoryPlanPersonalizado();

                plan = factory.crearPlan(
                        codigo,
                        nombre,
                        descripcion,
                        duracionMeses,
                        valorMensual,
                        estado,
                        sesiones,
                        especialidad,
                        objetivos
                );
            }

            gimnasioController.registrarPlan(plan);

            mostrarMensaje(
                    "Registro exitoso",
                    "El plan fue registrado correctamente."
            );

            limpiarCampos();

        } catch (NumberFormatException e) {

            mostrarMensaje(
                    "Error",
                    "Revise los campos numéricos."
            );

        } catch (Exception e) {

            mostrarMensaje(
                    "Error",
                    "No fue posible registrar el plan: "
                            + e.getMessage()
            );
        }
    }

    /**
     * Limpia los campos de la interfaz.
     */
    private void limpiarCampos() {

        txtCodigo.clear();
        txtNombre.clear();
        txtDescripcion.clear();
        txtDuracion.clear();
        txtValorMensual.clear();

        txtSesiones.clear();
        txtEspecialidad.clear();
        txtObjetivos.clear();

        cmbTipoPlan.setValue("Básico");
        cmbEstado.setValue(EstadoPlan.ACTIVO);
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