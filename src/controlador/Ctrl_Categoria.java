package controlador;

import conexion.Conexion;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import modelo.Categoria;
import java.sql.SQLException;
import java.sql.ResultSet;



public class Ctrl_Categoria {

//metodo para registrar categoria
    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar categoria: " + e);
        }

        return respuesta;

    }

    //metodo para validar si existe categoria
    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "select descripcion from tb_categoria where descripcion = '"+ categoria +"';";
        Statement st;

    
        try {
             Connection cn = Conexion.conectar();
             st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             
             while(rs.next()){
                 respuesta = true;
             }

        } catch (SQLException e) {
            System.out.println("Error al consultar categoria: " + e);
        }

        return respuesta;

    }

}
