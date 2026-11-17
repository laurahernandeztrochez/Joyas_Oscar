package joyas_oscar.vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;

public class VentanaLogin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaLogin.class.getName());

    public VentanaLogin() {
        initComponents();
        personalizarDiseño();
        pack();
        setLocationRelativeTo(null);
    }

    private void personalizarDiseño() {
        
        // Colores basados en tu mockup
        Color colorFondo = new Color(20, 20, 20);
        Color colorDorado = new Color(212, 175, 55);
        Color colorGrisOscuro = new Color(40, 40, 40);
        
        getContentPane().setBackground(colorFondo);
        setTitle("Joyas Oscar - Iniciar sesión");
        setResizable(false);
        setLocationRelativeTo(null);

        // Fuentes y Estilos
        Font fuenteTitulo = new Font("Serif", Font.BOLD, 24);
        Font fuenteSubtitulo = new Font("SansSerif", Font.BOLD, 12);
        Font fuenteGeneral = new Font("Georgia", Font.PLAIN, 13);

        jLabel2.setFont(fuenteTitulo);
        jLabel2.setForeground(colorDorado);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("♦  Joyas Oscar  ♦");

        jLabel3.setFont(fuenteSubtitulo);
        jLabel3.setForeground(colorDorado);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inicio de Sesión");

        jLabel4.setFont(fuenteGeneral);
        jLabel4.setForeground(colorDorado);
        jLabel4.setText("Usuario");

        jLabel5.setFont(fuenteGeneral);
        jLabel5.setForeground(colorDorado);
        jLabel5.setText("Contraseña");

        // Campos de Texto
        jTextField1.setBackground(colorGrisOscuro);
        jTextField1.setForeground(Color.WHITE);
        jTextField1.setCaretColor(Color.WHITE);
        jTextField1.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
        jTextField1.setText("");

        jPasswordField1.setBackground(colorGrisOscuro);
        jPasswordField1.setForeground(Color.WHITE);
        jPasswordField1.setCaretColor(Color.WHITE);
        jPasswordField1.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
        jPasswordField1.setText("");

        // Botones
        btnIngresar.setBackground(colorGrisOscuro);
        btnIngresar.setForeground(colorDorado);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBorder(BorderFactory.createLineBorder(colorDorado, 1));

        btnSalir.setBackground(new Color(50, 50, 50));
        btnSalir.setForeground(Color.LIGHT_GRAY);
        btnSalir.setFocusPainted(false);
        btnSalir.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
    
    // Centra los dos botones automáticamente sin importar el diseño generado
btnIngresar.setAlignmentX(javax.swing.JComponent.CENTER_ALIGNMENT);


    // AQUÍ LE PONES EL TAMAÑO A LA FUERZA, SIN TOCAR LO AZUL
    jTextField1.setPreferredSize(new java.awt.Dimension(344, 32));
    jPasswordField1.setPreferredSize(new java.awt.Dimension(344, 32));

    btnIngresar.setPreferredSize(new java.awt.Dimension(110, 32));
    btnSalir.setPreferredSize(new java.awt.Dimension(110, 32));

    btnIngresar.setContentAreaFilled(false);
    btnIngresar.setOpaque(true);
    btnSalir.setContentAreaFilled(false);
    btnSalir.setOpaque(true);

    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Joyas Oscar");

        jLabel3.setText("Inicio de Sesión");

        jLabel4.setText("Usuario");

        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jPasswordField1.setText("jPasswordField1");

        jLabel5.setText("Contraseña");

        btnIngresar.setText("Ingresar");

        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel2)
                                .addGap(21, 21, 21))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btnIngresar)
                        .addGap(32, 32, 32)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnSalir))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> new VentanaLogin().setVisible(true));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
private javax.swing.JLabel lblError;
}

