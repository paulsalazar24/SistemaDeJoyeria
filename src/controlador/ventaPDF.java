
package controlador;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ventaPDF {
    private String nombreCliente;
    private String dniCliente;
    private String telefonoCliente;
    private String direccionCliente;
    
    private String fechaActual = "";
    private String nombrePdf = "";
    
    public void DatosCliente (int idCliente){
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_cliente where idCliente = '" + idCliente +"'";
        Statement st;
        try {
            st = cn.createStatement();  
            ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 nombreCliente = rs.getString("nombre")+ " " + rs.getString("apellido");
                 dniCliente = rs.getString("cedula");
                 telefonoCliente  = rs.getString("telefono");
                 direccionCliente  = rs.getString("direccion");
            }
             cn.close();
            
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: " + e);
        }
        
    }
    
    
}
