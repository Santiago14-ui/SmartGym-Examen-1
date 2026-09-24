package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase del gimnasio utilizando Singleton
 */
public final class Gimnasio {

    /**
     * Instancia unica de la clase
     */
    private static Gimnasio instancia;

    /**
     * Atributos de la clase
     */
    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private List<Cliente> listClientes;
    private List<Entrenador> listEntrenadores;
    private List<PlanEntrenamiento> listPlanes;
    private List<ServicioAdicional> listServiciosAdicionales;
    private List<Inscripcion> listInscripciones;

    /**
     * Constructor privado con datos por defecto
     */
    private Gimnasio() {
        this.nombreComercial = "SmartGym";
        this.nit = "123456";
        this.direccion = "Universidad del Quindio";
        this.telefono = "3000000000";
        this.correoElectronico = "smartGym@yahoo.com";

        listClientes = new ArrayList<>();
        listEntrenadores = new ArrayList<>();
        listPlanes = new ArrayList<>();
        listServiciosAdicionales = new ArrayList<>();
        listInscripciones = new ArrayList<>();
    }

    /**
     * Punto de acceso a la unica instancia de la clase
     * @return Retorna una unica instancia
     */
    public static Gimnasio getInstancia() {
        if (instancia == null) {
            instancia = new Gimnasio();
        }

        return instancia;
    }

    /**
     * Funcion para agregar un cliente a la lista de clientes
     * @param cliente Cliente a agregar
     */
    public void registrarCliente(Cliente cliente) {
        listClientes.add(cliente);
    }

    /**
     * Funcion para buscar un cliente por telefono registrado
     * @param telefono telefono utilizado para buscar en la base de datos
     * @return
     */
    public Cliente buscarClientePorTelefono(String telefono) {

        for (Cliente cliente : listClientes) {

            if (cliente.getTelefono().equals(telefono)) {
                return cliente;
            }
        }

        return null;
    }

    /**
     * Funcion para determinar si un numero entero es perfecto
     * @param numero Numero a determinar si es perfecto o no
     * @return boolean
     */
    public boolean esNumeroPerfecto(String numero) {
        long numeroLong = Long.parseLong(numero);
        if (numeroLong <= 1) return false;

        long suma = 1; // El 1 siempre es divisor de cualquier número

        // Buscamos divisores de forma eficiente usando la raíz cuadrada
        for (long i = 2; i * i <= numeroLong; i++) {
            if (numeroLong % i == 0) {
                suma += i;
                // Si el divisor hermano es diferente, también lo sumamos
                if (i * i != numeroLong) {
                    suma += (numeroLong / i);
                }
            }
        }

        return suma == numeroLong;
    }

    //Getters y setters
    public void eliminarCliente(Cliente cliente) {
        listClientes.remove(cliente);
    }

    public void registrarEntrenador(Entrenador entrenador) {
        listEntrenadores.add(entrenador);
    }

    public void registrarPlan(PlanEntrenamiento plan) {
        listPlanes.add(plan);
    }

    public void registrarServicioAdicional(ServicioAdicional servicio) {
        listServiciosAdicionales.add(servicio);
    }

    public void registrarInscripcion(Inscripcion inscripcion) {
        listInscripciones.add(inscripcion);
    }

    public double calcularIngresos(LocalDate fechaInicio, LocalDate fechaFin) {

        double total = 0;

        for (Inscripcion inscripcion : listInscripciones) {

            if (!inscripcion.getFechaInscripcion().isBefore(fechaInicio)
                    && !inscripcion.getFechaInscripcion().isAfter(fechaFin)) {

                total += inscripcion.getValorTotal();
            }
        }

        return total;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public List<Entrenador> getListEntrenadores() {
        return listEntrenadores;
    }

    public void setListEntrenadores(List<Entrenador> listEntrenadores) {
        this.listEntrenadores = listEntrenadores;
    }

    public List<PlanEntrenamiento> getListPlanes() {
        return listPlanes;
    }

    public void setListPlanes(List<PlanEntrenamiento> listPlanes) {
        this.listPlanes = listPlanes;
    }

    public List<ServicioAdicional> getListServiciosAdicionales() {
        return listServiciosAdicionales;
    }

    public void setListServiciosAdicionales(List<ServicioAdicional> listServiciosAdicionales) {
        this.listServiciosAdicionales = listServiciosAdicionales;
    }

    public List<Inscripcion> getListInscripciones() {
        return listInscripciones;
    }

    public void setListInscripciones(List<Inscripcion> listInscripciones) {
        this.listInscripciones = listInscripciones;
    }

    @Override
    public String toString() {
        return "Gimnasio{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", clientes=" + listClientes +
                ", entrenadores=" + listEntrenadores +
                ", planes=" + listPlanes +
                ", serviciosAdicionales=" + listServiciosAdicionales +
                ", inscripciones=" + listInscripciones +
                '}';
    }
}
