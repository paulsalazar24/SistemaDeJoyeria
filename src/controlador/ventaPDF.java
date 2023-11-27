
package controlador;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ventaPDF {
    private String nombreCliente;
    private String dniCliente;
    private String telefonoCliente;
    private String direccionCliente;
    
    private String fechaActual = "";
    private String nombrePdf = "";
    
    
    //metodo para obtener datos del cliente 
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
    
    
    //
    public void generadorFacturaPDF(){
        try {
            //cargar la fecha actual
            Date date  = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            
            //cambiar el formato de la fecha 
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if(fechaNueva.charAt(i) == '/'){
                    fechaNueva = fechaActual.replace("/","_");
                }
            }
            
            nombrePdf = "venta_" + nombreCliente + "_" + fechaNueva + ".pdf";
            
            FileOutputStream archivo;
            File file = new File("src/pdf/"+nombrePdf);
            archivo = new FileOutputStream(file);
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            
            Image img = Image.getInstance("src/img/ventas.png");
            
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE); //AGREGAMOS NUEVA LINEA
            fecha.add("Boleta: 001" + "\nFecha: " + fechaActual + "\n\n");
            
            
            PdfPTable Encabezado = new PdfPTable(4);
            
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0); //para quitar border de la tabla
            
            //tamaño de las celdas
            float [] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregamos celdas 
            Encabezado.addCell(img);
            
            String ruc = "";
            String nombre = "";
            String telefono = "";
            String direccion = "";
            String razon = "";
            
            
            Encabezado.addCell("");
            Encabezado.addCell("RUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            
            
            //CUERPO
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);
            
            //DATOS DEL CLIENTE
            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0); //quitamos el border
            
            //TAMAÑO DE LAS CELDAS
            float[] ColumnaCliente = new float[]{25f, 45f, 30f, 40f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            
            
       } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }
    
}
