
package config.bd_test;

import java.sql.Connection;
import java.sql.SQLException;
import config.bd.ConectaBD;


public class test_conectabd {
    
     public static void main(String[] args) {
        ConectaBD bd = new ConectaBD();
        try (Connection cn = bd.getConnection()) {
            System.out.println("Conexion OK..");
        } catch (SQLException e) {
            System.out.println("Error: ");
            System.out.println(e.getMessage());
        }
    }
}
