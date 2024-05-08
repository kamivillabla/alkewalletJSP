package model;

/**
 * Clase que representa a un usuario en el sistema. Contiene información básica del usuario,
 * como su nombre, apellido, email, contraseña y RUT.
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String rut;

    /**
     * Constructor por defecto que crea un nuevo usuario sin inicializar sus atributos.
     */
    public Usuario() {
    }

    /**
     * Obtiene el ID único del usuario.
     * @return El ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID único del usuario.
     * @param id El ID a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     * @return El apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     * @param apellido El apellido a establecer.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el email del usuario.
     * @return El email del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del usuario.
     * @param email El email a establecer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contraseña La contraseña a establecer.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el RUT del usuario.
     * @return El RUT del usuario.
     */
    public String getRut() {
        return rut;
    }

    /**
     * Establece el RUT del usuario.
     * @param rut El RUT a establecer.
     */
    public void setRut(String rut) {
        this.rut = rut;
    }
}
