import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {
    private final static java.util.logging.Logger LOGGER = Logger.getLogger(AppTest.class.getName());
    private final Gimnasio smartGym = Gimnasio.getInstancia();
    private Cliente cliente1, cliente2, cliente3;
    private Entrenador entrenador1, entrenador2;

    @BeforeEach
    public void setUp()
    {

        cliente1 = new Cliente("Santiago Del Toro", "123456789", "3111111111", "Santiaguito@gamil.com", 24, LocalDate.now());
        cliente2 = new Cliente("Jaime Andres Romero Gil", "987654321", "3222222222", "superGil@gmail.com", 19, LocalDate.now());
        cliente3 = new Cliente("Maria Luisa Cardona Ruiz", "741852963", "3333333333", "mariaruiz@gmail.com", 22, LocalDate.now());
        smartGym.registrarCliente(cliente1); smartGym.registrarCliente(cliente2);  smartGym.registrarCliente(cliente3);

        entrenador1 = new Entrenador("321654987", "Marcos Alvarez Suarez", "Cardio", "3444444444", 35000);
        entrenador2 = new Entrenador("852741963", "Camilo Montoya Blanco", "Peso muerto", "3555555555", 40000);
        smartGym.registrarEntrenador(entrenador1);   smartGym.registrarEntrenador(entrenador2);
    }

    @Test
    public void testAssertNotNull() {
        LOGGER.info("Inicio de testAssertNotNull");
        assertNotNull(cliente1);
        assertNotNull(cliente2);
        assertNotNull(cliente3);
        assertNotNull(entrenador1);
        assertNotNull(entrenador2);
        LOGGER.info("Fin de testAssertNotNull");
    }


}
