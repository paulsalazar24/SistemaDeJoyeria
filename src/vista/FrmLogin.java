package vista;

import controlador.Ctrl_Usuario;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class FrmLogin extends javax.swing.JFrame {

    public FrmLogin() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Login - SISTEMA DE JOYERIA");
        this.setSize(new Dimension(546, 426));
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/ventas.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        loginPanel = new javax.swing.JPanel();
        txt_usuario = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jButton_IniciarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPanel.setBackground(new java.awt.Color(0, 0, 0, 80));
        loginPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginPanel.setPreferredSize(new java.awt.Dimension(350, 500));
        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
        });
        loginPanel.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 180, 40));

        txt_password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });
        loginPanel.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 149, 180, 40));

        jButton_IniciarSesion.setBackground(new java.awt.Color(51, 153, 255));
        jButton_IniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_IniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        jButton_IniciarSesion.setText("Ingresar");
        jButton_IniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IniciarSesionActionPerformed(evt);
            }
        });
        loginPanel.add(jButton_IniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 119, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        loginPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 40, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/contra.png"))); // NOI18N
        loginPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 152, 40, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bien.png"))); // NOI18N
        loginPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 60));

        jLabel4.setBackground(new java.awt.Color(255, 204, 153));
        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 153));
        jLabel4.setText("Bienvenido");
        loginPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 170, 60));

        getContentPane().add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 290, 280));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoNuevo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 430));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_IniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IniciarSesionActionPerformed
        this.Login();
    }//GEN-LAST:event_jButton_IniciarSesionActionPerformed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            this.Login();
        }
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            txt_password.requestFocus();
        }
    }//GEN-LAST:event_txt_usuarioKeyPressed

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuarioActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_IniciarSesion;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
/**
    Metodo para iniciar sesión
 */
    private void Login() {
        if(!txt_usuario.getText().isEmpty() && !txt_password.getText().isEmpty()){
            Ctrl_Usuario controlUsuario = new Ctrl_Usuario();
            Usuario usuario = new Usuario();
            usuario.setUsuario(txt_usuario.getText().trim());
            usuario.setPassword(txt_password.getText().trim());
            if(controlUsuario.loginUser(usuario)){
                //JOptionPane.showMessageDialog(null,"Login correcto");
                menu menu  = new menu();
                menu.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Usuario o Contraseña incorrestos");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Ingrese credenciales");
        }
    }

}
