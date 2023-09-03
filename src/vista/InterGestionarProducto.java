package vista;

import conexion.Conexion;
import controlador.Ctrl_Categoria;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Categoria;
import modelo.Producto;

public class InterGestionarProducto extends javax.swing.JInternalFrame {

    private int idProducto;
    int obtenerIdCategoria = 0;

    public InterGestionarProducto() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar productos");
        this.CargarTablaProducto();
        this.cargarComboCategoria();

        //insertar img en el label 
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        jComboBox_igv = new javax.swing.JComboBox<>();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(41, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(0, 0, 0));
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setForeground(new java.awt.Color(0, 0, 0));
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        txt_nombre.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cantidad: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripción: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("IGV: ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categoria: ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 90, -1));

        txt_cantidad.setBackground(new java.awt.Color(255, 255, 255));
        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        txt_precio.setBackground(new java.awt.Color(255, 255, 255));
        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        txt_descripcion.setBackground(new java.awt.Color(255, 255, 255));
        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        jComboBox_igv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_igv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione IGV:", "Sin IGV", "18%" }));
        jPanel3.add(jComboBox_igv, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 150, -1));

        jComboBox_categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione categoria--", "1", "2", "3" }));
        jPanel3.add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 150, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
//        if(!txt_descripcion.getText().isEmpty()){
//            Categoria categoria = new Categoria();
//            Ctrl_Categoria controlCategoria = new Ctrl_Categoria();
//            
//            categoria.setDescripcion(txt_descripcion.getText().trim());
//            if(controlCategoria.actualizar(categoria, idCategoria)){
//                 JOptionPane.showMessageDialog(null, "Categoria actualizada");
//                 txt_descripcion.setText("");
//                 this.CargarTablaCategoria();
//            }else{
//                 JOptionPane.showMessageDialog(null, "Error al actualizar categoria");
//            }
//        }else{
//            JOptionPane.showMessageDialog(null, "Selecione una categoria");
//        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
//        if(!txt_descripcion.getText().isEmpty()){
//            Categoria categoria = new Categoria();
//            Ctrl_Categoria controlCategoria = new Ctrl_Categoria();
//            
//            categoria.setDescripcion(txt_descripcion.getText().trim());
//            if(!controlCategoria.eliminar(idCategoria)){
//                 JOptionPane.showMessageDialog(null, "Categoria eliminada");
//                 txt_descripcion.setText("");
//                 this.CargarTablaCategoria();
//            }else{
//                 JOptionPane.showMessageDialog(null, "Error al eliminar categoria");
//            }
//        }else{
//            JOptionPane.showMessageDialog(null, "Selecione una categoria");
//        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JComboBox<String> jComboBox_igv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

//cargar las categorias 
    private void cargarComboCategoria() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_categoria";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_categoria.removeAll();
            jComboBox_categoria.addItem("Seleccione categoria: ");
            while (rs.next()) {
                jComboBox_categoria.addItem(rs.getString("descripcion"));
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar categorias: " + e);

        }

    }

    //metodo para mostrar todas los productos registrados
    String descripcionCategoria = "";
    double precio = 0.0;
    int porcentajeIgv = 0;
    double IGV = 0;

    private void CargarTablaProducto() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select p.idProducto, p.nombre, p.cantidad, p.precio , p.descripcion, p.porcentajeIva, c.descripcion, p.estado from tb_producto As p, tb_categoria As c where p.idCategoria = c.idCategoria;";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarProducto.jTable_productos = new JTable(model);
            InterGestionarProducto.jScrollPane1.setViewportView(InterGestionarProducto.jTable_productos);

            model.addColumn("N°"); //ID
            model.addColumn("nombre");
            model.addColumn("cantidad");
            model.addColumn("precio");
            model.addColumn("descripcion");
            model.addColumn("igv");
            model.addColumn("categoria");
            model.addColumn("estado");

            while (rs.next()) {
                precio = rs.getDouble("precio");
                porcentajeIgv = rs.getInt("porcentajeIva");

                Object fila[] = new Object[8];

                for (int i = 0; i < 8; i++) {
                    if (i == 5) {
                        this.calcularIgv(precio, porcentajeIgv);
                        fila[i] = IGV;
                        rs.getObject(i + 1);
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }

                model.addRow(fila);
            }

            con.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla productos: " + e);

        }

        jTable_productos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_productos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idProducto = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProductoSeleccionado(idProducto); //metodo
                }
            }

        });

    }

    //metodo para calcular igv 
    private double calcularIgv(double precio, int igv) {
        int p_igv = igv;
        switch (p_igv) {
            case 0 ->IGV = 0.0;
            case 18 ->IGV = precio * 0.18;
            default ->{
            }
        }
        //redondear decimales 
        IGV = (double) Math.round(IGV * 100) / 100;

        return IGV;
    }

    //metodo para ver producto de la tabla 
    private void EnviarDatosProductoSeleccionado(int idProducto) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_producto where idProducto = '" + idProducto + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_nombre.setText(rs.getString("nombre"));
                txt_cantidad.setText(rs.getString("cantidad"));
                txt_precio.setText(rs.getString("precio"));
                txt_descripcion.setText(rs.getString("descripcion"));
                int igv = rs.getInt("porcentajeIva");
                switch (igv) {
                    case 0 -> jComboBox_igv.setSelectedItem("Sin IGV");
                    case 18 -> jComboBox_igv.setSelectedItem("18%");
                    default -> jComboBox_igv.setSelectedItem("Selecione IGV:");
                }
                int idCate = rs.getInt("idCategoria");
                jComboBox_categoria.setSelectedItem(relacionarCategoria(idCate));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar producto: " + e);
        }
    }
    
    
    //metodo para relacionar categoria 
    private String relacionarCategoria(int idCategoria){
       
        String sql = "select descripcion from tb_categoria where idCategoria = '" + idCategoria +"'";
        Statement st;

        try {
             Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                descripcionCategoria = rs.getString("descripcion");
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al obtener el id de la categoria: " + e);

        }
        return descripcionCategoria;
    }

}
