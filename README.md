# Alke Wallet


## Características

- **Inicio de sesión**: Autenticación para acceder a las cuentas personales.
- **Gestión de fondos**: Capacidad para depositar y retirar fondos.
- **Consulta de saldo**: Visualización del saldo actual.

## Tecnologías Utilizadas

- **Java SE 21**: Lenguaje de programación utilizado para la lógica del servidor.
- **Servlets y JSP**: Tecnologías para la gestión de solicitudes y respuestas en el entorno web.
- **MySQL**: Sistema de gestión de bases de datos para el almacenamiento de datos.
- **HTML/CSS**: Utilizados para la estructuración y diseño de la interfaz de usuario.
- **Bootstrap**: Framework de CSS para diseños responsivos y estilizados.
- **JavaScript**: Utilizado para añadir interactividad a la interfaz de usuario. Incluye funciones para la manipulación de elementos del DOM, como alternar la visibilidad de la barra lateral, formatear números y gestionar alertas dinámicas.

## Requisitos

Para ejecutar y desarrollar Alke Wallet se requiere lo siguiente:

- **Java Development Kit (JDK) versión 21**.
- **Apache Tomcat 10**: 
- **MySQL Server**: Para el manejo de la base de datos.
- **MySQL Connector/J 8.4.0**: Conector JDBC para MySQL. Puedes descargarlo [aquí](https://dev.mysql.com/downloads/connector/j/) y agregar el archivo JAR `mysql-connector-java-8.4.0.jar` al directorio `lib` de tu proyecto.
- **Eclipse IDE**: Con soporte para Dynamic Web Module 6.0, utilizado para el desarrollo del proyecto.


## Configuración

1. **Clonar el repositorio**: Descarga o clona el repositorio en tu entorno local.
2. **Configurar la base de datos**:
   - Importa el script `alkewallet-kami.sql` a tu servidor MySQL para crear las tablas necesarias.
   - Asegúrate de ajustar las credenciales de conexión a la base de datos en el archivo `DBConnection.java`.
3. **Desplegar en el servidor**:

## Uso

Para comenzar a usar Alke Wallet, simplemente accede a la dirección web donde se ha desplegado la aplicación, y utiliza las credenciales proporcionadas o registradas para iniciar sesión.


