package controlador;

import java.sql.Connection;
import modelo.Categoria;
import java.sql.SQLException;


public class Ctrl_Categoria {
    
    public boolean guardar(Categoria objeto){
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            
        } catch (SQLException e) {
            System.out.println("Error al guardar categoria: " + e);
        }
        
    }
    
}
