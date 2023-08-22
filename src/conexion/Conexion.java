package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexion {
    
    //conexion local
    
    public static Connection conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_joyeria", "root", "");
            return cn;
            
        }catch(SQLException e){
            System.out.println("Error en la coneccion local: " + e );
        }
        return null;
        
    } 
}
