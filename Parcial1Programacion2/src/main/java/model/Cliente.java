package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para instanciar nuevos clientes.
 */
public class Cliente {

    // Atributos de la clase
    private String nombreCompleto;
    private String documentoIdentidad;
    private String telefono;
    private String correoElectronico;
    private int edad;
    private LocalDate fechaRegistro;
    private Gimnasio gimnasio;
    private List<Inscripcion> listInscripciones;
    private List<ServicioAdicional> listservicioAdicionales;

    /**
     * Construye un cliente con la información suministrada.
     */
    public Cliente(String nombreCompleto, String documentoIdentidad, String telefono,
                   String correoElectronico, int edad, LocalDate fechaRegistro) {

        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.edad = edad;
        this.fechaRegistro = fechaRegistro;
        this.listInscripciones = new ArrayList<>();
        this.listservicioAdicionales = new ArrayList<>();
    }

    /**
     * Agrega una inscripción al cliente.
     */
    public void agregarInscripcion(Inscripcion inscripcion) {
        listInscripciones.add(inscripcion);
    }

    /**
     * Elimina una inscripción del cliente.
     */
    public void eliminarInscripcion(Inscripcion inscripcion) {
        listInscripciones.remove(inscripcion);
    }

    // Getters

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    public List<Inscripcion> getListInscripciones() {
        return listInscripciones;
    }

    public List<ServicioAdicional> getListservicioAdicionales() {
        return listservicioAdicionales;
    }

    // Setters

    public void setListInscripciones(List<Inscripcion> listInscripciones) {
        this.listInscripciones = listInscripciones;
    }

    public void setListservicioAdicionales(List<ServicioAdicional> listservicioAdicionales) {
        this.listservicioAdicionales = listservicioAdicionales;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setGimnasio(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    /**
     * Permite mostrar solamente el nombre del cliente
     * cuando se utiliza en un ComboBox.
     */
    @Override
    public String toString() {
        return nombreCompleto;
    }
}