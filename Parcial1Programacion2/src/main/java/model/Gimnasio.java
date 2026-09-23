package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Gimnasio {

    private static Gimnasio instancia;

    private String nombreComercial;
    private String nit;
    private String direccion;
    private int telefono;
    private String correoElectronico;
    private String paginaWeb;

    private List<Cliente> clientes;
    private List<Entrenador> entrenadores;
    private List<PlanEntrenamiento> planes;
    private List<ServicioAdicional> serviciosAdicionales;
    private List<Inscripcion> inscripciones;

    private Gimnasio() {
        clientes = new ArrayList<>();
        entrenadores = new ArrayList<>();
        planes = new ArrayList<>();
        serviciosAdicionales = new ArrayList<>();
        inscripciones = new ArrayList<>();
    }

    public static Gimnasio getInstancia() {
        if (instancia == null) {
            instancia = new Gimnasio();
        }

        return instancia;
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorTelefono(int telefono) {

        for (Cliente cliente : clientes) {

            if (cliente.getTelefono() == telefono) {
                return cliente;
            }
        }

        return null;
    }

    public boolean esNumeroPerfecto(int numero) {

        if (numero <= 1) {
            return false;
        }

        int suma = 0;

        for (int i = 1; i < numero; i++) {

            if (numero % i == 0) {
                suma += i;
            }
        }

        return suma == numero;
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void registrarEntrenador(Entrenador entrenador) {
        entrenadores.add(entrenador);
    }

    public void registrarPlan(PlanEntrenamiento plan) {
        planes.add(plan);
    }

    public void registrarServicioAdicional(ServicioAdicional servicio) {
        serviciosAdicionales.add(servicio);
    }

    public void registrarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public double calcularIngresos(LocalDate fechaInicio, LocalDate fechaFin) {

        double total = 0;

        for (Inscripcion inscripcion : inscripciones) {

            if (!inscripcion.getFechaInscripcion().isBefore(fechaInicio)
                    && !inscripcion.getFechaInscripcion().isAfter(fechaFin)) {

                total += inscripcion.getValorTotal();
            }
        }

        return total;
    }
}
