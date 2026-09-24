package viewController;

import controller.GimnasioController;
import factory.FactoryPlan;
import factory.FactoryPlanBasico;
import factory.FactoryPlanPersonalizado;
import factory.FactoryPlanPremium;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.BeneficioPlan;
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

    @FXML
    private CheckBox chkAccesoZonas;

    @FXML
    private CheckBox chkClasesGrupales;

    @FXML
    private CheckBox chkAcompanamientoEntrenador;

    @FXML
    private Label lblBeneficiosIncluidos;

    /**
     * Inicializa el controlador.
     *
     * Carga los tipos de planes y los estados disponibles.
     * También controla la visibilidad de los campos
     * correspondientes al plan personalizado.
     */
    @FXML
    public void initialize() {

        gimnasioController =
                new GimnasioController(Gimnasio.getInstancia());

        // Cargar tipos de plan.
        cmbTipoPlan.getItems().addAll(
                "Básico",
                "Premium",
                "Personalizado"
        );

        // Cargar estados.
        cmbEstado.getItems().addAll(
                EstadoPlan.values()
        );

        // Valores iniciales.
        cmbTipoPlan.setValue("Básico");
        cmbEstado.setValue(EstadoPlan.ACTIVO);

        // Ocultar inicialmente el panel personalizado.
        panelPersonalizado.setVisible(false);
        panelPersonalizado.setManaged(false);

        // Mostrar los beneficios del plan básico.
        actualizarBeneficios("Básico");

        /*
         * Detecta cuando cambia el tipo de plan.
         */
        cmbTipoPlan.valueProperty().addListener(
                (observable, valorAnterior, nuevoValor) -> {

                    boolean esPersonalizado =
                            "Personalizado".equals(nuevoValor);

                    // Mostrar u ocultar el panel personalizado.
                    panelPersonalizado.setVisible(esPersonalizado);
                    panelPersonalizado.setManaged(esPersonalizado);

                    // Actualizar los beneficios mostrados.
                    actualizarBeneficios(nuevoValor);

                    /*
                     * Si no es personalizado,
                     * se desmarcan las casillas.
                     */
                    if (!esPersonalizado) {

                        chkAccesoZonas.setSelected(false);
                        chkClasesGrupales.setSelected(false);
                        chkAcompanamientoEntrenador.setSelected(false);
                    }
                }
        );
    }

    /**
     * Actualiza el texto de los beneficios dependiendo
     * del tipo de plan seleccionado.
     *
     * @param tipoPlan tipo de plan seleccionado
     */
    private void actualizarBeneficios(String tipoPlan) {

        if ("Básico".equals(tipoPlan)) {

            lblBeneficiosIncluidos.setText(
                    "Beneficios incluidos:\n"
                            + "• Acompañamiento con entrenador"
            );

        } else if ("Premium".equals(tipoPlan)) {

            lblBeneficiosIncluidos.setText(
                    "Beneficios incluidos:\n"
                            + "• Acceso a zonas deportivas\n"
                            + "• Clases grupales\n"
                            + "• Acompañamiento con entrenador"
            );

        } else {

            /*
             * En personalizado no mostramos otro mensaje aquí,
             * porque el Label que está dentro del panel ya dice:
             * "Seleccione los beneficios".
             */
            lblBeneficiosIncluidos.setText("");
        }
    }

    /**
     * Registra un nuevo plan de entrenamiento.
     *
     * Utiliza una fábrica diferente dependiendo del tipo
     * de plan seleccionado.
     *
     * Para el plan personalizado se pueden seleccionar
     * uno, dos o los tres beneficios disponibles.
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

            /*
             * PLAN BÁSICO
             */
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

                /*
                 * El plan básico incluye:
                 * Acompañamiento con entrenador.
                 */
                plan.agregarBeneficio(
                        BeneficioPlan.ACOMPANAMIENTO_ENTRENADOR
                );

                /*
                 * PLAN PREMIUM
                 */
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

                /*
                 * El plan premium incluye los tres beneficios.
                 */
                plan.agregarBeneficio(
                        BeneficioPlan.ACCESO_ZONAS_DEPORTIVAS
                );

                plan.agregarBeneficio(
                        BeneficioPlan.CLASES_GRUPALES
                );

                plan.agregarBeneficio(
                        BeneficioPlan.ACOMPANAMIENTO_ENTRENADOR
                );

                /*
                 * PLAN PERSONALIZADO
                 */
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

                /*
                 * Se agrega cada beneficio que el usuario
                 * haya seleccionado.
                 *
                 * Puede seleccionar:
                 * - Solo uno.
                 * - Dos.
                 * - Los tres.
                 */

                if (chkAccesoZonas.isSelected()) {

                    plan.agregarBeneficio(
                            BeneficioPlan.ACCESO_ZONAS_DEPORTIVAS
                    );
                }

                if (chkClasesGrupales.isSelected()) {

                    plan.agregarBeneficio(
                            BeneficioPlan.CLASES_GRUPALES
                    );
                }

                if (chkAcompanamientoEntrenador.isSelected()) {

                    plan.agregarBeneficio(
                            BeneficioPlan.ACOMPANAMIENTO_ENTRENADOR
                    );
                }
            }

            /*
             * Registrar el plan en el gimnasio.
             */
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
     * Limpia todos los campos de la interfaz
     * después de registrar un plan.
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

        chkAccesoZonas.setSelected(false);
        chkClasesGrupales.setSelected(false);
        chkAcompanamientoEntrenador.setSelected(false);

        cmbTipoPlan.setValue("Básico");
        cmbEstado.setValue(EstadoPlan.ACTIVO);
    }

    /**
     * Muestra un mensaje informativo al usuario.
     *
     * @param titulo título de la ventana
     * @param mensaje mensaje que se mostrará
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