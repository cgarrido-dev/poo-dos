package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionMySQL {

    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/empresadb";
        String user = "root";
        String password = "123456789";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado correctamente.");
            
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida correctamente.");
            
            String consulta = "SELECT * FROM Empleado";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            
            while (rs.next()) {
                System.out.println("Empleado ID: " + rs.getInt("EmpleadoID") +
                                   ", Nombre: " + rs.getString("Nombre"));
            }
            
            rs.close();
            stmt.close();
            conexion.close();
            System.out.println("Conexión cerrada.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
