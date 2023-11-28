package vista;

import conexion.Conexion;
import controlador.Ctrl_Cliente;
import controlador.Ctrl_RegistrarVenta;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.CabeceraVenta;
import modelo.Cliente;

public class gestionarVentas extends javax.swing.JFrame {

    private int idCliente = 0;
    private int idVenta;

    public gestionarVentas() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar ventas");
        // Agrega la siguiente línea para inicializar jScrollPane1
        jScrollPane1 = new javax.swing.JScrollPane();
        // cargar tabla
        this.CargarComboCliente();
        this.CargarTablaVentas();

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //insertar img en el label 
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ventas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_totalPagar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jButton_actualizar = new javax.swing.JButton();
        jComboBox_estado = new javax.swing.JComboBox<>();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar ventas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_ventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_ventas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 200));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 820, 220));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Total pagar: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 90, -1));

        txt_totalPagar.setBackground(new java.awt.Color(255, 255, 255));
        txt_totalPagar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_totalPagar.setEnabled(false);
        jPanel3.add(txt_totalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cliente: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 90, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Estado: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 90, 30));

        txt_fecha.setBackground(new java.awt.Color(255, 255, 255));
        txt_fecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_fecha.setEnabled(false);
        jPanel3.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 170, -1));

        jButton_actualizar.setBackground(new java.awt.Color(255, 255, 255));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(0, 0, 0));
        jButton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_act.png"))); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jComboBox_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_estadoActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 170, -1));

        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 740, 150));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        Ctrl_RegistrarVenta controlRegistrarVenta = new Ctrl_RegistrarVenta();
        String cliente, estado;
        cliente = jComboBox_cliente.getSelectedItem().toString().trim();
        estado = jComboBox_estado.getSelectedItem().toString().trim();

        //obtenemos el id del cliente 
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select idCliente, concat(nombre, ' ', apellido) as cliente "
                    + "from tb_cliente where concat(nombre, ' ', apellido) = '" + cliente + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error en cargar el id cliente: " + e);
        }
        
        //actualizar datos
        if(!cliente.equalsIgnoreCase("Seleccione cliente:")){
            cabeceraVenta.setIdCliente(idCliente);
            if(estado.equalsIgnoreCase("Activo")){
                cabeceraVenta.setEstado(1);
            }else{
                cabeceraVenta.setEstado(0);
            }
            
            if(controlRegistrarVenta.actualizar(cabeceraVenta, idVenta)){
                JOptionPane.showMessageDialog(null, "¡Registro actualizado!");
                this.CargarTablaVentas();
                this.Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }
                   
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione registro para actualizar datos");
        }

    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jComboBox_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_estadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gestionarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestionarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestionarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestionarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gestionarVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_ventas;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_totalPagar;
    // End of variables declaration//GEN-END:variables

//metodo para limpiar
    private void Limpiar() {
        txt_totalPagar.setText("");
        txt_fecha.setText("");
        jComboBox_cliente.setSelectedItem("Seleccione cliente:");
        jComboBox_estado.setSelectedItem("Activo");
        idCliente = 0;
    }

    //metodo para mostrar todas los clientes registrados
    private void CargarTablaVentas() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select cv.idCabeceraVenta as id, concat(c.nombre, ' ', c.apellido) as cliente,"
                + " cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado "
                + "from tb_cabecera_venta as cv, tb_cliente as c where cv.idCliente = c.idCliente;";

        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            model.addColumn("N°"); // ID
            model.addColumn("Cliente");
            model.addColumn("Total pagar");
            model.addColumn("Fecha venta");
            model.addColumn("estado");
            while (rs.next()) {
                Object fila[] = new Object[5];
                for (int i = 0; i < 5; i++) {
                    if (i == 4) {
                        String estado = String.valueOf(rs.getObject(i + 1));
                        if (estado.equalsIgnoreCase("1")) {
                            fila[i] = "Activo";
                        } else {
                            fila[i] = "Inactivo";
                        }
                    } else {

                        fila[i] = rs.getObject(i + 1);
                    }
                }
                model.addRow(fila);
            }
            jTable_ventas.setModel(model);
            con.close();
        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla ventas: " + e);
        }
        jTable_ventas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_ventas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idVenta = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosVentasSeleccionada(idVenta);
                }
            }
        });
    }

    //metodo para ver clientes de la tabla 
    private void EnviarDatosVentasSeleccionada(int idVenta) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select cv.idCabeceraVenta, cv.idCliente,  concat(c.nombre, ' ', c.apellido) as cliente,"
                    + " cv.valorPagar, cv.fechaVenta, cv.estado "
                    + "from tb_cabecera_venta as cv, tb_cliente as c"
                    + " where cv.idCabeceraVenta= '" + idVenta + "' and cv.idCliente = c.idCliente;");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jComboBox_cliente.setSelectedItem(rs.getString("cliente"));
                txt_totalPagar.setText(rs.getString("valorPagar"));
                txt_fecha.setText(rs.getString("fechaVenta"));
                int estado = rs.getInt("estado");
                if (estado == 1) {
                    jComboBox_estado.setSelectedItem("Activo");
                } else {
                    jComboBox_estado.setSelectedItem("Inactivo");
                }

            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar venta: " + e);
        }
    }

    //metodo para cargar clientes en el jComboBox
    private void CargarComboCliente() {
        Connection con = Conexion.conectar();
        String sql = "select * from tb_cliente ";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_cliente.removeAllItems();
            jComboBox_cliente.addItem("Seleccione cliente:");

            while (rs.next()) {
                jComboBox_cliente.addItem(rs.getString("nombre") + " " + rs.getNString("apellido"));
            }
            con.close();
        } catch (Exception e) {

            System.err.println("Error al cargar clientes: " + e);
        }

    }

}
