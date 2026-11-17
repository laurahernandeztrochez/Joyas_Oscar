package joyas_oscar.vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class VentanaLogin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaLogin.class.getName());

    public VentanaLogin() {
        initComponents();
        personalizarDiseño();
        pack();
        setLocationRelativeTo(null);
    }

    private void personalizarDiseño() {
  
    // 1. Cargamos y escalamos la imagen UNA SOLA VEZ para optimizar
    javax.swing.ImageIcon iconoOriginal = new javax.swing.ImageIcon(getClass().getResource("/joyas_oscar/vista/login.png"));
    java.awt.Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
    javax.swing.ImageIcon iconoFinal = new javax.swing.ImageIcon(imagenEscalada);

    // 2. Se la asignas a tu primera etiqueta
    jLabelImagen.setIcon(iconoFinal);

    // 3. Se la asignas a tu segunda etiqueta 
    jLabelImagen2.setIcon(iconoFinal);


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
        jLabel2.setText("  Joyas Oscar  ");

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
        jLabelImagen = new javax.swing.JLabel();
        jLabelImagen2 = new javax.swing.JLabel();

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
                .addGap(62, 62, 62)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabelImagen2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24)
                        .addComponent(jLabelImagen)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelImagen2)
                    .addComponent(jLabelImagen))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelImagen2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
private javax.swing.JLabel lblError;
}

