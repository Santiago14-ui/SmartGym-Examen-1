package model;

/**
 * Representa un servicio adicional ofrecido por el gimnasio.
 */
public class ServicioAdicional {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;

    private Gimnasio gimnasio;

    /**
     * Crea un servicio adicional.
     */
    public ServicioAdicional(String codigo, String nombre,
                             String descripcion, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    /**
     * Obtiene el código del servicio.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el nombre del servicio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la descripción del servicio.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el precio del servicio.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene el gimnasio asociado al servicio.
     */
    public Gimnasio getGimnasio() {
        return gimnasio;
    }


    @Override
    public String toString() {
        return "ServicioAdicional{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}