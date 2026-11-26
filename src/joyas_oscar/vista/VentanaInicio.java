
package joyas_oscar.vista;

import javax.swing.JOptionPane;                     
import joyas_oscar.Aplicacion;                         
import joyas_oscar.modelo.Usuario;                     
import joyas_oscar.repositorio.UsuarioRepositorio;

//Personalizacion
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Muestra el menú principal y permite abrir los módulos de gestión
 * disponibles para el usuario que inició sesión.
 */
public class VentanaInicio extends javax.swing.JFrame {
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaInicio.class.getName());

    private final Color fondoOscuro = Color.decode("#141414");
    private final Color tarjetaOscura = Color.decode("#282828");
    private final Color dorado = Color.decode("#D4AF37");
    
    private Aplicacion app;                      
    private Usuario usuario;     
    
    public VentanaInicio(Aplicacion app, Usuario usuario) {
        initComponents();
        aplicarPermisos(usuario);
        personalizarDiseño();
        pack();
        setLocationRelativeTo(null);
       
     
        this.app = app;                        
        this.usuario = usuario;                 

       
        lblBienvenida.setText("Bienvenido, " + usuario.obtenerInformacion());   
    }
    
    private void aplicarPermisos(Usuario usuario) {
    String rol = usuario.getRol().getNombre();
    
   if (rol.equalsIgnoreCase("Administrador")) {
       return;
   }

    if (rol.equalsIgnoreCase("Vendedor")) {
        btnJoyas.setVisible(false);
        btnUsRol.setVisible(false);
        btnMaterial.setVisible(false);
        lblAdministrador.setVisible(false);
    }

    if (rol.equalsIgnoreCase("Joyero")) {
        btnUsRol.setVisible(false);
        btnPedidos.setVisible(false);
        btnPagos.setVisible(false);
        btnClientes.setVisible(false);
         lblAdministrador.setVisible(false);
    }
}
    
    private void personalizarDiseño() {
        getContentPane().setBackground(fondoOscuro);

        // Separador vertical dorado
        jSeparator1.setOrientation(SwingConstants.VERTICAL);
        jSeparator1.setForeground(dorado);
        jSeparator1.setBackground(dorado);
        jSeparator1.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, dorado));

        // Encabezados
        lblBienvenida.setForeground(dorado);
        lblBienvenida.setFont(new Font("Georgia", Font.BOLD, 20));

        jLabel2.setForeground(Color.WHITE);
        jLabel2.setFont(new Font("Georgia", Font.PLAIN, 13));

        jLabel12.setForeground(dorado);
        jLabel12.setFont(new Font("Georgia", Font.BOLD, 18));

        jLabel13.setForeground(Color.WHITE);
        jLabel13.setFont(new Font("Georgia", Font.PLAIN, 13));
        configurarIconoEnLabel(jLabel13, "/joyas_oscar/vista/calendario.png", 24, 24);

        // Botones de gestión (borde dorado, fondo oscuro, icono arriba y texto abajo)
        estilizarBotonModulo(btnJoyas, "/joyas_oscar/vista/diamante.png", 42, 42);
        estilizarBotonModulo(btnClientes, "/joyas_oscar/vista/clientes.png", 42, 42);
        estilizarBotonModulo(btnPedidos, "/joyas_oscar/vista/pedidos.png", 42, 42);
        estilizarBotonModulo(btnPagos, "/joyas_oscar/vista/pago.png", 42, 42);
        estilizarBotonModulo(btnUsRol, "/joyas_oscar/vista/usuario.png", 42, 42);
        estilizarBotonModulo(btnMaterial, "/joyas_oscar/vista/material.png", 42, 42);

        // Tarjetas de resumen del día (icono a la izquierda)
        estilizarTarjetaResumen(jPanel7, jLabel9, "/joyas_oscar/vista/mondea.png", 32, 32);
        estilizarTarjetaResumen(jPanel8, jLabel10, "/joyas_oscar/vista/pedidos.png", 32, 32);
        estilizarTarjetaResumen(jPanel9, jLabel11, "/joyas_oscar/vista/pago.png", 32, 32);
    }

    private void estilizarBotonModulo(JButton boton, String rutaIcono, int ancho, int alto) {
 
    if (boton == null) {
        return;
    }

    boton.setContentAreaFilled(false);
    boton.setOpaque(true);
    boton.setBackground(tarjetaOscura);
    boton.setForeground(Color.WHITE);
    boton.setFont(new Font("Georgia", Font.PLAIN, 12));
    boton.setFocusPainted(false);
    boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton.setPreferredSize(new Dimension(165, 115));

    boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(dorado, 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
    ));

    boton.setHorizontalAlignment(SwingConstants.CENTER);
    boton.setVerticalAlignment(SwingConstants.CENTER);
    boton.setHorizontalTextPosition(SwingConstants.CENTER);
    boton.setVerticalTextPosition(SwingConstants.BOTTOM);
    boton.setIconTextGap(8);

    ImageIcon icono = cargarIconoEscalado(rutaIcono, ancho, alto);
    if (icono != null) {
        boton.setIcon(icono);
    }
}

    private void estilizarTarjetaResumen(JPanel panel, JLabel labelTexto, String rutaIcono, int ancho, int alto) {
        if (panel == null || labelTexto == null) {
            return;
        }
        panel.setBackground(tarjetaOscura);
        panel.removeAll();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 8));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(dorado, 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));

        JLabel labelIcono = new JLabel();
        ImageIcon icono = cargarIconoEscalado(rutaIcono, ancho, alto);
        if (icono != null) {
            labelIcono.setIcon(icono);
        }

        labelTexto.setForeground(dorado);
        labelTexto.setFont(new Font("Georgia", Font.BOLD, 13));

        panel.add(labelIcono);
        panel.add(labelTexto);
        panel.revalidate();
        panel.repaint();
    }

    private void configurarIconoEnLabel(JLabel label, String rutaIcono, int ancho, int alto) {
        if (label == null) {
            return;
        }
        ImageIcon icono = cargarIconoEscalado(rutaIcono, ancho, alto);
        if (icono != null) {
            label.setIcon(icono);
            label.setHorizontalTextPosition(SwingConstants.RIGHT);
            label.setIconTextGap(8);
        }
    }

    private ImageIcon cargarIconoEscalado(String ruta, int ancho, int alto) {
        URL recurso = getClass().getResource(ruta);
        if (recurso == null) {
            System.err.println("No se encontró el recurso de imagen en: " + ruta);
            return null;
        }
        ImageIcon original = new ImageIcon(recurso);
        Image escalada = original.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(escalada);
    }
  

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBienvenida = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnJoyas = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        btnUsRol = new javax.swing.JButton();
        btnMaterial = new javax.swing.JButton();
        lblAdministrador = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBienvenida.setText("Bienvenido Oscar Toro (Administrador)");

        jLabel2.setText("Selecciona una opción para gestionar");

        jLabel9.setText("Ventas del día");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jLabel11.setText("Pagos pendientes");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLabel10.setText("Pedidos pendientes");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jLabel12.setText("Resumen del día");

        jLabel13.setText("(fecha del dia)");

        btnJoyas.setText("Gestionar joyas");
        btnJoyas.addActionListener(this::btnJoyasActionPerformed);

        btnClientes.setText("Administrar clientes");
        btnClientes.addActionListener(this::btnClientesActionPerformed);

        btnPedidos.setText("Crear y revisar pedidos");
        btnPedidos.addActionListener(this::btnPedidosActionPerformed);

        btnPagos.setText("Pagos");
        btnPagos.addActionListener(this::btnPagosActionPerformed);

        btnUsRol.setText("Usuarios y roles");
        btnUsRol.addActionListener(this::btnUsRolActionPerformed);

        btnMaterial.setText("Material/materia prima");
        btnMaterial.addActionListener(this::btnMaterialActionPerformed);

        lblAdministrador.setText("Solo el administrador:");

        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addActionListener(this::btnCerrarSesionActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblBienvenida))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAdministrador)
                                    .addComponent(jLabel2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCerrarSesion))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnJoyas)
                                    .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUsRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPedidos)
                                    .addComponent(btnMaterial))))
                        .addGap(47, 47, 47)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAdministrador)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnJoyas)
                            .addComponent(btnClientes)
                            .addComponent(btnPedidos))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUsRol)
                                    .addComponent(btnMaterial)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion)
                        .addGap(59, 59, 59))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        app.abrirCliente();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
          JOptionPane.showMessageDialog(this, "Módulo en construcción"); 
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnJoyasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoyasActionPerformed
        app.abrirJoya();
    }//GEN-LAST:event_btnJoyasActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
         app.abrirPedido();
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void btnUsRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsRolActionPerformed
        app.abrirUsuario();
    }//GEN-LAST:event_btnUsRolActionPerformed

    private void btnMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaterialActionPerformed
        app.abrirMaterial();
    }//GEN-LAST:event_btnMaterialActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        // Se cierra el menú y se vuelve a abrir el login, para que entre otra persona.
        dispose();                               // Cierra SOLO esta ventana.
        app.iniciar();                           // Aplicacion abre un login nuevo.
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(() -> {
            Usuario prueba = new UsuarioRepositorio().buscarPorNombreUsuario("admin"); // usuario prueba puede ser "admin" o no como "carlos"
            new VentanaInicio(new Aplicacion(), prueba).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnJoyas;
    private javax.swing.JButton btnMaterial;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnUsRol;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAdministrador;
    private javax.swing.JLabel lblBienvenida;
    // End of variables declaration//GEN-END:variables
}
