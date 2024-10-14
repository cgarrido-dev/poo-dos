package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/empresadb";
        String user = "root";
        String password = "123456789";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida.");

            String query0 = "SELECT e.Nombre, e.Salario, d.Nombre AS Departamento "
                          + "FROM Empleado e "
                          + "JOIN Departamento d ON e.DepartamentoID = d.DepartamentoID";
            Statement stmt0 = conexion.createStatement();
            ResultSet rs0 = stmt0.executeQuery(query0);
            System.out.println("\n*** Empleados y sus departamentos (Antes de las operaciones):");
            while (rs0.next()) {
                System.out.println("Nombre: " + rs0.getString("Nombre") + ", Salario: " + rs0.getDouble("Salario") +
                                   ", Departamento: " + rs0.getString("Departamento"));
            }
            rs0.close();
            stmt0.close();

            // 1. Mostrar empleados del departamento de Desarrollo con salario mayor a 60000
            String query1 = "SELECT Nombre, Salario FROM Empleado WHERE DepartamentoID = "
                          + "(SELECT DepartamentoID FROM Departamento WHERE Nombre = 'Desarrollo') "
                          + "AND Salario > 60000.00";
            Statement stmt1 = conexion.createStatement();
            ResultSet rs1 = stmt1.executeQuery(query1);
            System.out.println("\n*** Empleados del Departamento de Desarrollo con salario mayor a 60000:");
            while (rs1.next()) {
                System.out.println("Nombre: " + rs1.getString("Nombre") + ", Salario: " + rs1.getDouble("Salario"));
            }
            rs1.close();
            stmt1.close();
            
            // 2. Agregar un nuevo departamento llamado Marketing
            String query2 = "INSERT INTO Departamento (DepartamentoID, Nombre, Ubicacion) VALUES (4, 'Marketing', 'Piso 4, Edificio D')";
            Statement stmt2 = conexion.createStatement();
            stmt2.executeUpdate(query2);
            System.out.println("\n*** Nuevo departamento 'Marketing' agregado.");
            stmt2.close();

            // 3. Actualizar el salario de Juan Pérez, incrementar en un 10%
            String query3 = "UPDATE Empleado SET Salario = Salario * 1.10 WHERE Nombre = 'Juan Pérez' "
                          + "AND DepartamentoID = (SELECT DepartamentoID FROM Departamento WHERE Nombre = 'Ventas')";
            Statement stmt3 = conexion.createStatement();
            stmt3.executeUpdate(query3);
            System.out.println("\n*** Salario de Juan Pérez incrementado en un 10%.");
            stmt3.close();

            // 4. Eliminar al empleado con ID 105
            String query4 = "DELETE FROM Empleado WHERE EmpleadoID = 105";
            Statement stmt4 = conexion.createStatement();
            stmt4.executeUpdate(query4);
            System.out.println("\n*** Empleado con ID 105 eliminado.");
            stmt4.close();

            String query5 = "SELECT e.Nombre, e.Salario, d.Nombre AS Departamento "
                          + "FROM Empleado e "
                          + "JOIN Departamento d ON e.DepartamentoID = d.DepartamentoID";
            Statement stmt5 = conexion.createStatement();
            ResultSet rs5 = stmt5.executeQuery(query5);
            System.out.println("\n*** Empleados y sus departamentos (Después de las operaciones):");
            while (rs5.next()) {
                System.out.println("Nombre: " + rs5.getString("Nombre") + ", Salario: " + rs5.getDouble("Salario") +
                                   ", Departamento: " + rs5.getString("Departamento"));
            }
            rs5.close();
            stmt5.close();

            conexion.close();
            System.out.println("Conexión cerrada.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
