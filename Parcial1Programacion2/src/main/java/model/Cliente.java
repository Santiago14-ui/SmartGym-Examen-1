package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para instanciar nuevos clientes
 */
public class Cliente {

    /**
     * Atributos
     */
    private String nombreCompleto;
    private String documentoIdentidad;
    private String telefono;
    private String correoElectronico;
    private int edad;
    private LocalDate fechaRegistro;
    private Gimnasio gimnasio;
    private List<Inscripcion> listInscripciones;
    private List<ServicioAdicional>  ListservicioAdicionales;

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
        this.ListservicioAdicionales = new ArrayList<>();
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

    /**
     * Obtiene el nombre completo del cliente.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Obtiene el documento de identidad del cliente.
     */
    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    /**
     * Obtiene el teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Obtiene la edad del cliente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene la fecha de registro del cliente.
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Obtiene el gimnasio al que pertenece el cliente.
     */
    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    /**
     * Obtiene las inscripciones del cliente.
     */
    public List<Inscripcion> getListInscripciones() {
        return listInscripciones;
    }

    public void setListInscripciones(List<Inscripcion> listInscripciones) {
        this.listInscripciones = listInscripciones;
    }

    public List<ServicioAdicional> getListservicioAdicionales() {
        return ListservicioAdicionales;
    }

    public void setListservicioAdicionales(List<ServicioAdicional> listservicioAdicionales) {
        ListservicioAdicionales = listservicioAdicionales;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", telefono=" + telefono +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", edad=" + edad +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}