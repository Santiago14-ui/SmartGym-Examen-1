package controller;

import java.util.LinkedList;

/**
 * Clase del gimnasio
 */
public class SmartGym {
    /**
     * Atributos de la clase
     */
    private String nombre, nit;
    private LinkedList<Cliente> listClientes;
    private LinkedList<Entrenador> listEntrenadores;
    private LinkedList<Entrenamiento> listEntrenamientos;

    private static SmartGym instancia;

    /**
     * Constructor
     * @param nombre nombre del gimnasio
     * @param nit nit del gimnasio
     */
    private SmartGym(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        listClientes = new LinkedList<>();
        listEntrenadores = new LinkedList<>();
        listEntrenamientos = new LinkedList<>();
    }

    /**
     * Punto de acceso a la instancia unica
     * @return
     */
    public static SmartGym getInstancia() {
        if (instancia == null) {
            instancia = new SmartGym("SmartGym", "123456");
        }
        return instancia;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public LinkedList<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(LinkedList<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public LinkedList<Entrenador> getListEntrenadores() {
        return listEntrenadores;
    }

    public void setListEntrenadores(LinkedList<Entrenador> listEntrenadores) {
        this.listEntrenadores = listEntrenadores;
    }

    public LinkedList<Entrenamiento> getListEntrenamientos() {
        return listEntrenamientos;
    }

    public void setListEntrenamientos(LinkedList<Entrenamiento> listEntrenamientos) {
        this.listEntrenamientos = listEntrenamientos;
    }

    @Override
    public String toString() {
        return "SmartGym{" +
                "nit='" + nit + '\'' +
                ", listClientes=" + listClientes.toString() +
                ", listEntrenadores=" + listEntrenadores.toString() +
                ", listEntrenamientos=" + listEntrenamientos.toString() +
                '}';
    }
}
