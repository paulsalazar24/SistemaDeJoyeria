package vista;

import com.mysql.jdbc.PreparedStatement;
import conexion.Conexion;
import controlador.Ctrl_RegistrarVenta;
import controlador.ventaPDF;
import java.lang.ref.Cleaner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;

public class RegistrarVenta extends javax.swing.JFrame {

    //modelo de datos
    private DefaultTableModel modeloDatosProductos;

    //lista para el detalle de venta de productos
    ArrayList<DetalleVenta> listaProductos = new ArrayList<>();
    private DetalleVenta producto;

    private int idCliente = 0;

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;
    private int porcentajeIgv = 0;

    private int cantidad = 0;  //cantidad de productos a comprar
    private double subtotal = 0.0; // cantidad por precio
    private double descuento = 0.0;
    private double igv = 0.0;
    private double totalPagar = 0.0;

    private int auxIdDetalle = 1; //id del detalle de venta

    //variables globales para calculos 
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double igvGeneral = 0.0;
    private double totalpagarGeneral = 0.0;

    //fin
    public RegistrarVenta() {
        initComponents();
        this.setTitle("Registrar venta");
        // Agrega la siguiente línea para inicializar jScrollPane1
        jScrollPane1 = new javax.swing.JScrollPane();
        // cargar tabla
        this.CargarComboCliente();
        this.CargarComboProductos();
        this.inicializarTablaProducto();

        txt_efectivo.setEnabled(false);
        btn_calcularCambio.setEnabled(false);

        txt_subTotal.setText("0.0");
        txt_igv.setText("0.0");
        txt_descuento.setText("0.0");
        txt_totalPagar.setText("0.0");

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    //metodo para mostrar datos en la tabla productos
    private void inicializarTablaProducto() {
        modeloDatosProductos = new DefaultTableModel();
        //agregamos columnas 
        modeloDatosProductos.addColumn("NRO.");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. unitario");
        modeloDatosProductos.addColumn("subTotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("IGV");
        modeloDatosProductos.addColumn("Total pagar");
        modeloDatosProductos.addColumn("Accion");

        //agregar datos del modelo en la tabla 
        RegistrarVenta.jTable_productos.setModel(modeloDatosProductos);
    }

    //metodo para presentar informacion en la tabla - productos seleccionados
    private void listaTablaProductos() {
        this.modeloDatosProductos.setRowCount(listaProductos.size());
        for (int i = 0; i < listaProductos.size(); i++) {
            this.modeloDatosProductos.setValueAt(i + 1, i, 0);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getNombre(), i, 1);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCantidad(), i, 2);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getPrecioUnitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getSubtotal(), i, 4);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getDescuento(), i, 5);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getIgv(), i, 6);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getTotalPagar(), i, 7);
            this.modeloDatosProductos.setValueAt("ELIMINAR", i, 8); //Aqui se eliminara el producto seleccionado
        }
        //añador al jTable

        jTable_productos.setModel(modeloDatosProductos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_wallpaper = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_cambio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_subTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_descuento = new javax.swing.JTextField();
        txt_igv = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_totalPagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btn_calcularCambio = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        jComboBox_producto = new javax.swing.JComboBox<>();
        txt_cantidad = new javax.swing.JTextField();
        txt_buscar_cliente = new javax.swing.JTextField();
        btn_agregarProdutco = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btn_registrarVenta = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jLabel_wallpaper.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("IGV: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, -1));

        txt_cambio.setBackground(new java.awt.Color(255, 255, 255));
        txt_cambio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cambio.setEnabled(false);
        jPanel3.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Subtotal: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, -1));

        txt_subTotal.setBackground(new java.awt.Color(255, 255, 255));
        txt_subTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_subTotal.setEnabled(false);
        jPanel3.add(txt_subTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cambio: ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Descuento: ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, -1));

        txt_descuento.setBackground(new java.awt.Color(255, 255, 255));
        txt_descuento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_descuento.setEnabled(false);
        jPanel3.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 170, -1));

        txt_igv.setBackground(new java.awt.Color(255, 255, 255));
        txt_igv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_igv.setEnabled(false);
        jPanel3.add(txt_igv, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 170, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Total a pagar: ");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, -1));

        txt_totalPagar.setBackground(new java.awt.Color(255, 255, 255));
        txt_totalPagar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_totalPagar.setEnabled(false);
        jPanel3.add(txt_totalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 170, -1));

        txt_efectivo.setBackground(new java.awt.Color(255, 255, 255));
        txt_efectivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 170, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Efectivo: ");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));

        btn_calcularCambio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_calcularCambio.setText("Calcular cambio");
        btn_calcularCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularCambioActionPerformed(evt);
            }
        });
        jPanel3.add(btn_calcularCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 320, 250));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 750, 270));

        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 150, 30));

        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 150, 30));

        txt_cantidad.setBackground(new java.awt.Color(255, 255, 255));
        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 70, -1));

        txt_buscar_cliente.setBackground(new java.awt.Color(255, 255, 255));
        txt_buscar_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_buscar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 170, -1));

        btn_agregarProdutco.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_agregarProdutco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calcularPro.png"))); // NOI18N
        btn_agregarProdutco.setText("Añadir producto ");
        btn_agregarProdutco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarProdutcoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregarProdutco, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 220, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Producto: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cantidad: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 90, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Cliente: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, 30));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, 30));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 490, 170));

        btn_registrarVenta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_registrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregarPro.png"))); // NOI18N
        btn_registrarVenta.setText("Registrar venta");
        btn_registrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_registrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 220, 70));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 730, 380));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 730, 380));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 380));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 730, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_calcularCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularCambioActionPerformed
        if (!txt_efectivo.getText().isEmpty()) {
            //validamos que el usuario no ingrese otro caracteres no numericos 
            boolean validacion = validarDouble(txt_efectivo.getText());
            if (validacion == true) {
                //validar que el efectivo sea mayor al total a pagar
                double efc = Double.parseDouble(txt_efectivo.getText().trim());
                double top = Double.parseDouble(txt_totalPagar.getText().trim());

                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "El dinero en efectivo no es suficiente");
                } else {
                    double cambio = (efc - top);
                    double cambi = (double) Math.round(cambio * 100) / 100;
                    String camb = String.valueOf(cambi);
                    txt_cambio.setText(camb);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se admiten caractericos no numericos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo para calcular cambio");
        }
    }//GEN-LAST:event_btn_calcularCambioActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btn_registrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarVentaActionPerformed
        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        DetalleVenta detalleVenta = new DetalleVenta();
        Ctrl_RegistrarVenta controlVenta = new Ctrl_RegistrarVenta();
        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
        if (!jComboBox_cliente.getSelectedItem().equals("Seleccione cliente:")) {
            if (listaProductos.size() > 0) {
                
                //metodo para obtener el id del cliente
                this.ObtenerIdCliente();
                //registrar la cabecera de la venta
                cabeceraVenta.setIdCabeceraVenta(0);
                cabeceraVenta.setIdCliente(idCliente);
                cabeceraVenta.setValorPagar(Double.parseDouble(txt_totalPagar.getText()));
                cabeceraVenta.setFechaVenta(fechaActual);
                cabeceraVenta.setEstado(1);
                if (controlVenta.guardar(cabeceraVenta)) {
                    JOptionPane.showMessageDialog(null, "¡Venta registrada!");
                    
                    //generar la factura
                    ventaPDF pdf = new ventaPDF();
                    pdf.DatosCliente(idCliente);
                    pdf.generadorFacturaPDF();
                    
                    //guardar detalle venta
                    for (DetalleVenta elemento : listaProductos) {
                        detalleVenta.setIdDetalleVenta(0);
                        detalleVenta.setIdCabeceraVenta(0);
                        detalleVenta.setIdProducto(elemento.getIdProducto());
                        detalleVenta.setCantidad(elemento.getCantidad());
                        detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
                        detalleVenta.setSubtotal(elemento.getSubtotal());
                        detalleVenta.setDescuento(elemento.getDescuento());
                        detalleVenta.setIgv(elemento.getIgv());
                        detalleVenta.setTotalPagar(elemento.getTotalPagar());
                        detalleVenta.setEstado(1);
                        
                        if (controlVenta.guardarDetalle(detalleVenta)) {
                            System.err.println("Detalle de venta registrado");
                            
                            txt_subTotal.setText("0.0");
                            txt_igv.setText("0.0");
                            txt_descuento.setText("0.0");
                            txt_totalPagar.setText("0.0");
                            txt_efectivo.setText(" ");
                            txt_cambio.setText("0.0");
                            auxIdDetalle = 1;
                            
                            this.CargarComboCliente();
                            this.RestarStockProductos(elemento.getIdProducto(), elemento.getCantidad());
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "¡Error al guardar detalle de venta!");
                        }
                    }
                    //vaciamos la lista
                    listaProductos.clear();
                    listaTablaProductos();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al guardar cabecera de venta!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Seleccione un cliente!");
        }

    }//GEN-LAST:event_btn_registrarVentaActionPerformed

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
// TODO add your handlng code here:
        String clienteBuscar = txt_buscar_cliente.getText().trim();
        Connection cn = Conexion.conectar();
        String sql = "select nombre, apellido from tb_cliente where cedula = '" + clienteBuscar + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                jComboBox_cliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                jComboBox_cliente.setSelectedItem("Seleccione cliente:");
                JOptionPane.showMessageDialog(null, "¡Dni de cliente incorrecto o no encontrado!");
            }

            txt_buscar_cliente.setText("");
            cn.close();
        } catch (Exception e) {
            System.err.println("Error al buscar cliente" + e);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_agregarProdutcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarProdutcoActionPerformed
        try {
            String combo = this.jComboBox_producto.getSelectedItem().toString();
            //validar la seleccion del producto
            if (combo.equalsIgnoreCase("Seleccione producto:")) {
                JOptionPane.showMessageDialog(null, "Seleccione producto");
            } else {
                //validar que ingrese una cantidad
                if (!txt_cantidad.getText().isEmpty()) {
                    //validar que no ingrese caracteres no numericos
                    boolean validacion = validar(txt_cantidad.getText());
                    if (validacion == true) {
                        //validar que la cantidad sea mayor a 0 
                        if (Integer.parseInt(txt_cantidad.getText()) > 0) {
                            cantidad = Integer.parseInt(txt_cantidad.getText());
                            //ejecutar el metodo para obtener datos del producto
                            this.DatosDelProducto();
                            //validar de cantidad de productos selecionados no sea mayor a ala base de datos
                            if (cantidad <= cantidadProductoBBDD) {
                                subtotal = precioUnitario * cantidad;
                                totalPagar = subtotal + igv + descuento;

                                //redondeamos decimales 
                                subtotal = (double) Math.round(subtotal * 100) / 100; //redondemaos a 2 decimales
                                igv = (double) Math.round(igv * 100) / 100;
                                descuento = (double) Math.round(descuento * 100) / 100;
                                totalPagar = (double) Math.round(totalPagar * 100) / 100;

                                //crear un nuevo producto
                                producto = new DetalleVenta(auxIdDetalle,
                                        1,
                                        idProducto,
                                        nombre,
                                        Integer.parseInt(txt_cantidad.getText()),
                                        precioUnitario,
                                        subtotal,
                                        descuento,
                                        igv,
                                        totalPagar,
                                        1);

                                System.out.println("producto datos: " + producto);

                                //agregar a la lisat de productos
                                listaProductos.add(producto);

                                JOptionPane.showMessageDialog(null, "Productos agregado");

                                auxIdDetalle++;
                                txt_cantidad.setText(""); //LIMPIAR CAMPO DE LA CANTIDAD

                                //volver a cargar el combo de productos
                                this.CargarComboProductos();
                                this.CalcularTotalPagar();

                                //
                                txt_efectivo.setEnabled(true);
                                btn_calcularCambio.setEnabled(true);

                            } else {
                                JOptionPane.showMessageDialog(null, "La cantidad supera el stock");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero (0), tampoco negativo");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no númerico");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ingresa la cantidad del producto");
                }

            }

            this.listaTablaProductos();

        } catch (Exception e) {
            System.err.println("Error al cargar en la tabla productos: " + e);

        }

    }//GEN-LAST:event_btn_agregarProdutcoActionPerformed

    int idArrayList = 0;

    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
        int fila_point = jTable_productos.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }

        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar producto?");
        //opciones de ConfirmDialog - (si = 0, no =1, cancel = 2, close = -1)
        switch (opcion) {
            case 0: // PRECIONE SI
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.listaTablaProductos();
                break;
            case 1: //PRECIONE NO
                break;
            default: //PRECIONE CANCEL O CLOSE
                break;
        }
    }//GEN-LAST:event_jTable_productosMouseClicked

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
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregarProdutco;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_calcularCambio;
    private javax.swing.JButton btn_registrarVenta;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txt_buscar_cliente;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_igv;
    private javax.swing.JTextField txt_subTotal;
    public static javax.swing.JTextField txt_totalPagar;
    // End of variables declaration//GEN-END:variables

    //metodo para limpiar
    private void Limpiar() {
        txt_cantidad.setText("");
        txt_cambio.setText("");
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

    //metodo para cargar productos en el jComboBox
    private void CargarComboProductos() {
        Connection con = Conexion.conectar();
        String sql = "select * from tb_producto";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_producto.removeAllItems();
            jComboBox_producto.addItem("Seleccione producto:");

            while (rs.next()) {
                jComboBox_producto.addItem(rs.getString("nombre"));
            }
            con.close();
        } catch (Exception e) {
            System.err.println("Error al cargar productos: " + e);
        }
    }

    // creamois metodo para validar cantidad
    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //metodo para mostrar los datos del producto
    private void DatosDelProducto() {
        try {
            String sql = "select * from tb_producto where nombre = '" + this.jComboBox_producto.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();  // Inicializar el Statement aquí
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("cantidad");
                precioUnitario = rs.getDouble("precio");
                porcentajeIgv = rs.getInt("porcentajeIgv");
                this.CalcularIgv(precioUnitario, porcentajeIgv); // calcula y retorna el igv
            }
            System.out.println("igv: " + porcentajeIgv);
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto" + e);
        }
    }

    //metodo para calcular el igv del producto
    private double CalcularIgv(double precio, int porcentajeIgv) {
        int p_igv = porcentajeIgv;
        switch (p_igv) {
            case 0 ->
                igv = 0.0;
            case 18 ->
                igv = (precio * cantidad) * 0.18;
            default -> {
            }
        }
        return igv;
    }

    //metodo para calcular venta 
    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        igvGeneral = 0;
        totalpagarGeneral = 0;
        for (DetalleVenta elemento : listaProductos) {
            subtotalGeneral += elemento.getSubtotal();
            descuentoGeneral += elemento.getDescuento();
            igvGeneral += elemento.getIgv();
            totalpagarGeneral += elemento.getTotalPagar();
        }
        //redondear decimales
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        igvGeneral = (double) Math.round(igvGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        totalpagarGeneral = (double) Math.round(totalpagarGeneral * 100) / 100;
        // enviar datos a la vista 
        txt_subTotal.setText(String.valueOf(subtotalGeneral));
        txt_igv.setText(String.valueOf(igvGeneral));
        txt_descuento.setText(String.valueOf(descuentoGeneral));
        txt_totalPagar.setText(String.valueOf(totalpagarGeneral));
    }

    //  metodo para validar cantidad
    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //metodo para obtener id del cliente
    private void ObtenerIdCliente() {
        try {
            String sql = "select * from tb_cliente where concat(nombre, ' ', apellido) = '" + this.jComboBox_cliente.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();  
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener id del cliente: " + e);
        }
    }
    
    //metodo para restar stock de producto
    private void RestarStockProductos(int idProducto, int cantidad){
        int cantidadProductosBD = 0;
        try {
            String sql = "select idProducto, cantidad from tb_producto where idProducto = '" + idProducto + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();  
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                 cantidadProductosBD = rs.getInt("cantidad");
            }
            cn.close();
            
            
         } catch (SQLException e) {
            System.out.println("Error al restar cantidad de stock: " + e);
        }
        
        
        try {
             Connection cn = Conexion.conectar();
             PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update tb_producto set cantidad =? where idProducto = '" + idProducto +"'");
             int cantidadNueva = cantidadProductosBD - cantidad;
             consulta.setInt(1, cantidadNueva);
             
             if(consulta.executeUpdate() > 0){
                 System.out.println("Todo bien. ");
             }
             
             
             
         } catch (SQLException e) {
            System.out.println("Error al restar cantidad de stock 2: " + e);
        }
    }
}
