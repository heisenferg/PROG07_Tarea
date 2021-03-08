public class Persona {
    String nombre;
    String apellidos;
    String dni;
/*
Constructores
 */

    public Persona() {
    }

    /**
     *
     * @param nombre
     * @param apellidos
     * @param dni
     */
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }
/*
Get y set de las variables
 */
    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     *
     * @return string con los datos.
     */
    @Override
    public String toString() {
        return "CLIENTE: " +
                nombre + " " + apellidos + " con DNI "
               + dni;
    }
}
