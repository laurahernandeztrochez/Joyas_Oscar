
package joyas_oscar.vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import joyas_oscar.controlador.LoginControlador;       // El controlador que recibe la ventana.
import joyas_oscar.repositorio.UsuarioRepositorio;     // Lo usa el main para probar la ventana.
import joyas_oscar.Aplicacion;       

/**
 * Presenta el formulario de inicio de sesión y solicita al controlador
 * validar las credenciales antes de abrir el menú principal.
 */
public class VentanaLogin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaLogin.class.getName());
    
      private LoginControlador login;              // Quien valida usuario y contraseña.
      private Aplicacion app;                      // Para abrir la ventana principal al entrar.
    
     public VentanaLogin(LoginControlador login, Aplicacion app) {
        initComponents();
        personalizarDiseño();
        pack();
        setLocationRelativeTo(null);
        
                           // PRIMERO: crea los componentes del diseñador.
        this.login = login;                      // Guarda el controlador recibido.
        this.app = app;                          // Guarda la aplicación.
        lblMensaje.setText("");                  // El mensaje rojo empieza vacío.
        getRootPane().setDefaultButton(btnIngresar);   // La tecla Enter oprime Ingresar.
        setLocationRelativeTo(null);             // Abre la ventana en el centro.
    }
    

    //Personalizacion de la interfaz
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
        txtUsuario.setBackground(colorGrisOscuro);
        txtUsuario.setForeground(Color.WHITE);
        txtUsuario.setCaretColor(Color.WHITE);
        txtUsuario.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
        txtUsuario.setText("");

        txtContrasena.setBackground(colorGrisOscuro);
        txtContrasena.setForeground(Color.WHITE);
        txtContrasena.setCaretColor(Color.WHITE);
        txtContrasena.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
        txtContrasena.setText("");

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


   
    txtUsuario.setPreferredSize(new java.awt.Dimension(344, 32));
    txtContrasena.setPreferredSize(new java.awt.Dimension(344, 32));

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
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabelImagen = new javax.swing.JLabel();
        jLabelImagen2 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Joyas Oscar");

        jLabel3.setText("Inicio de Sesión");

        jLabel4.setText("Usuario");

        txtUsuario.addActionListener(this::txtUsuarioActionPerformed);

        txtContrasena.setText("jPasswordField1");

        jLabel5.setText("Contraseña");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(this::btnIngresarActionPerformed);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        lblMensaje.setForeground(new java.awt.Color(204, 0, 0));
        lblMensaje.setText("Usuario o contraseña incorrectos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabelImagen))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(153, 153, 153)
                            .addComponent(jLabel5))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblMensaje)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelImagen2)
                        .addComponent(jLabelImagen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(lblMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
 String mensaje = login.iniciarSesion(
                txtUsuario.getText(),
                new String(txtContrasena.getPassword()));

        if (login.getUsuarioActual() == null) {     // ¿No entró? Se muestra el error.
            lblMensaje.setText(mensaje);
            txtContrasena.setText("");              // Se borra la contraseña para escribirla otra vez.
            txtContrasena.requestFocus();           // El cursor vuelve a la contraseña.
            return;
        }
        // Entró. Por ahora solo se saluda; en el siguiente paso aquí se abrirá VentanaPrincipal. Esto se borra
        //JOptionPane.showMessageDialog(this, mensaje); esto se borra
        // Entró: se cierra el login y se abre el menú principal con el usuario que entró. esto se borra
        
        dispose();                                           // Cierra SOLO esta ventana.
        app.abrirPrincipal(login.getUsuarioActual());   
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
          System.exit(0);    
    }//GEN-LAST:event_btnSalirActionPerformed


    public static void main(String args[]) {
        /* Create and display the form */
        // java.awt.EventQueue.invokeLater(() -> new VentanaLogin().setVisible(true));   // borrar
        // Para probar esta ventana sola: se crean el repositorio y el controlador. //se borra
        // (Más adelante lo hará el main del proyecto: MiniStore.java). //se borra
        // Aplicacion crea los repositorios y el controlador, y abre el login.
        java.awt.EventQueue.invokeLater(() -> {
            new Aplicacion().iniciar();          // Aplicacion crea todo y abre el login.
        });
    
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
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}

