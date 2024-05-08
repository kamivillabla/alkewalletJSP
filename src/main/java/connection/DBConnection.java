package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/alkewalletkami";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // La instancia única de Connection
    private static Connection instance;

    // Constructor privado para prevenir instanciación
    private DBConnection() {}

    /**
     * Devuelve la única instancia de Connection.
     * @return la instancia de la conexión a la base de datos
     * @throws SQLException si ocurre un error de SQL al obtener la conexión
     */
    public static Connection getConnection() throws SQLException {
        if (instance == null || instance.isClosed()) {
            synchronized (DBConnection.class) {
                if (instance == null || instance.isClosed()) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        instance = DriverManager.getConnection(URL, USER, PASSWORD);
                    } catch (ClassNotFoundException e) {
                        System.out.println("No se ha encontrado el controlador MySQL JDBC.");
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }

    public static void testConnection() {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("Conexión establecida con éxito.");
            } else {
                System.out.println("No se pudo establecer conexión.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testConnection();
    }
}
