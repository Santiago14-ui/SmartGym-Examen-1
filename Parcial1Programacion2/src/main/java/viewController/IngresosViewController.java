package viewController;

import controller.GimnasioController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import model.Gimnasio;

import java.time.LocalDate;

/**
 * Controlador encargado de consultar los ingresos
 * generados por las inscripciones del gimnasio.
 */
public class IngresosViewController {

    private GimnasioController gimnasioController;

    @FXML
    private DatePicker dpFechaInicio;

    @FXML
    private DatePicker dpFechaFin;

    @FXML
    private Label lblResultado;

    /**
     * Inicializa el controlador.
     */
    @FXML
    public void initialize() {

        gimnasioController =
                new GimnasioController(Gimnasio.getInstancia());
    }

    /**
     * Consulta los ingresos generados durante
     * el período seleccionado.
     */
    @FXML
    private void consultarIngresos() {

        LocalDate fechaInicio = dpFechaInicio.getValue();
        LocalDate fechaFin = dpFechaFin.getValue();

        if (fechaInicio == null || fechaFin == null) {

            lblResultado.setText(
                    "Debe seleccionar ambas fechas."
            );

            return;
        }

        if (fechaInicio.isAfter(fechaFin)) {

            lblResultado.setText(
                    "La fecha inicial no puede ser posterior a la fecha final."
            );

            return;
        }

        double ingresos =
                gimnasioController.calcularIngresos(
                        fechaInicio,
                        fechaFin
                );

        lblResultado.setText(
                "Ingresos del período: $" +
                        String.format("%.2f", ingresos)
        );
    }
}