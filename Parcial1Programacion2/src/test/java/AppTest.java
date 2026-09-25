import org.junit.jupiter.api.BeforeEach;

import model.*;
import factory.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private final static java.util.logging.Logger LOGGER = Logger.getLogger(AppTest.class.getName());
    private final Gimnasio smartGym = Gimnasio.getInstancia();
    private Cliente cliente1, cliente2, cliente3;
    private Entrenador entrenador1, entrenador2;
    private Inscripcion inscripcion1, inscripcion2;

    @BeforeEach
    public void setUp()
    {

        cliente1 = new Cliente("Santiago Del Toro", "123456789", "3111111111", "Santiaguito@gmail.com", 24, LocalDate.now());
        cliente2 = new Cliente("Jaime Andres Romero Gil", "987654321", "3222222222", "superGil@gmail.com", 19, LocalDate.now());
        cliente3 = new Cliente("Maria Luisa Cardona Ruiz", "741852963", "6", "mariaruiz@gmail.com", 22, LocalDate.now());
        smartGym.registrarCliente(cliente1); smartGym.registrarCliente(cliente2);  smartGym.registrarCliente(cliente3);

        FactoryPlanBasico factoryPlanBasico = new FactoryPlanBasico();
        PlanEntrenamiento planBasico = factoryPlanBasico.crearPlan("001", "Plan Basico",
                "Ingreso al gimnasio, uso de maquinas de ejericio y uso de casilleros",
                2, 30000, EstadoPlan.ACTIVO);
        inscripcion1 = new Inscripcion(LocalDateTime.now(), cliente1, planBasico, entrenador1);
        smartGym.registrarInscripcion(inscripcion1);
        FactoryPlanPersonalizado factoryPlanPersonalizado = new FactoryPlanPersonalizado();
        PlanEntrenamiento planPersonalizado = factoryPlanPersonalizado.crearPlan("002", "Plan Premium",
                "Todo lo del plan basico mas horario extendido, acceso a zonas vip, seguimiento personal", 3, 60000, EstadoPlan.ACTIVO);
        inscripcion2 = new Inscripcion(LocalDateTime.now(), cliente2, planPersonalizado, entrenador2);


        entrenador1 = new Entrenador("321654987", "Marcos Alvarez Suarez", "Cardio", "3444444444", 35000);
        entrenador2 = new Entrenador("852741963", "Camilo Montoya Blanco", "Peso muerto", "3555555555", 40000);
        smartGym.registrarEntrenador(entrenador1);   smartGym.registrarEntrenador(entrenador2);
    }

    @Test
    public void testAssertNotNull() {
        LOGGER.info("Inicio de testAssertNotNull");
        assertNotNull(smartGym.buscarClientePorTelefono(cliente1.getTelefono()));
        assertNotNull(cliente2);
        assertNotNull(cliente3);
        assertNotNull(entrenador1);
        assertNotNull(entrenador2);
        LOGGER.info("Fin de testAssertNotNull");
    }

    @Test
    public void testAssertTrue() {
        LOGGER.info("Inicio de testAssertTrue");
        assertTrue(cliente1.getTelefono().length() == 10);
        assertTrue(cliente2.getTelefono().length() == 10);
        assertTrue(smartGym.getTelefono().length() == 10);
        assertTrue(entrenador1.getTelefono().length() == 10);
        assertTrue(entrenador2.getTelefono().length() == 10);
        assertTrue(smartGym.esNumeroPerfecto(cliente3.getTelefono()));
        assertTrue(smartGym.calcularIngresos(LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 30)) > 10000);
        LOGGER.info("Fin de testAssertTrue");
    }


    @Test
    public void testAssertFalse() {
        LOGGER.info("Inicio de testAssertFalse");
        assertFalse(smartGym.getListInscripciones().isEmpty());
        assertFalse(inscripcion1.getFechaInscripcion().isAfter(LocalDateTime.now()));
        assertFalse(inscripcion2.getCliente() == null);
        assertFalse(smartGym.esNumeroPerfecto(cliente2.getTelefono()));
        LOGGER.info("Fin de testAssertFalse");
    }

}
