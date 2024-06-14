
package Vista;

import Modelo.LoginDao;
import Modelo.login;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class FrmLogin extends javax.swing.JFrame {
    login lg = new login();
    LoginDao login = new LoginDao();
    private Timer tiempo;
    int contador;
    int segundos = 30;

    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtCorreo.setText("info@angelsifuentes.com");
        txtPass.setText("admin");
        barra.setVisible(false);
        ImageIcon img = new ImageIcon(getClass().getResource("/Img/logo.png"));
        this.setIconImage(img.getImage());
    }

    public class BarraProgreso implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            contador++;
            barra.setValue(contador);
            if (contador == 100) {
                tiempo.stop();
                if (barra.getValue() == 100) {
                    Sistema sis = new Sistema(lg);
                    sis.setVisible(true);
                    dispose();
                }
            }
        }
    }

    public void validar(){
        String correo = txtCorreo.getText();
        String pass = String.valueOf(txtPass.getPassword());
        if (!"".equals(correo) || !"".equals(pass)) {
            lg = login.log(correo, pass);
            if (lg.getCorreo()!= null && lg.getPass() != null) {
                barra.setVisible(true);
                contador = -1;
                barra.setValue(0);
                barra.setStringPainted(true);
                tiempo = new Timer(segundos, new BarraProgreso());
                tiempo.start();
            } else {
                JOptionPane.showMessageDialog(null, "Correo o la Contraseña incorrecta");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();
        btnRecuperar = new javax.swing.JButton(); // Nueva línea

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Correo Electrónico");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txtCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreo.setBorder(null);
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 250, 35));

        txtPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPass.setBorder(null);
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 250, 35));

        btnIniciar.setBackground(new java.awt.Color(0, 0, 0));
        btnIniciar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Login");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 93, 35));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 93, 35));
        
        btnRecuperar.setBackground(new java.awt.Color(0, 0, 0));
        btnRecuperar.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnRecuperar.setForeground(new java.awt.Color(255, 255, 255));
        btnRecuperar.setText("Recuperar Contraseña"); // Nueva línea
        btnRecuperar.addActionListener(new java.awt.event.ActionListener() { // Nueva línea
            public void actionPerformed(java.awt.event.ActionEvent evt) { // Nueva línea
                btnRecuperarActionPerformed(evt); // Nueva línea
            } // Nueva línea
        }); // Nueva línea
        jPanel2.add(btnRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 180, 35)); // Ajustar según necesidad

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iniciar.png"))); // NOI18N
        jLabel1.setText("Iniciar Sesión");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 110));

        barra.setBackground(new java.awt.Color(255, 255, 255));
        barra.setForeground(new java.awt.Color(0, 110, 255));
        jPanel2.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 250, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 450)); // Ajuste de altura
        pack();
    }

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        validar();
    }

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        FrmRecuperar frmRecuperar = new FrmRecuperar();
        frmRecuperar.setVisible(true);
        this.dispose();
    } 

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnRecuperar; // Nueva línea
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration                   
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
