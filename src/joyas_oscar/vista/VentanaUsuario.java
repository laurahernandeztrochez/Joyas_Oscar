
package joyas_oscar.vista;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import joyas_oscar.modelo.Rol;
import joyas_oscar.repositorio.RolRepositorio;

/**
 * Ventana de administración de usuarios y selección de sus roles.
 */
public class VentanaUsuario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaUsuario.class.getName());
   
    private RolRepositorio repoRol= new RolRepositorio();
   
    public VentanaUsuario() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jComboBox1.removeAllItems();
for (Rol r : repoRol.listarRoles()) {
    jComboBox1.addItem(r.getNombre());

}
        personalizarDiseño(); // <--- Aplica el estilo visual
    }
    
    
    private void personalizarDiseño() {
        Color colorFondo = new Color(20, 20, 20);
        Color colorDorado = new Color(212, 175, 55);
        Color colorGrisOscuro = new Color(40, 40, 40);
        
        getContentPane().setBackground(colorFondo);
        setTitle("Joyas Oscar - Crear Usuario");
        setResizable(false);
        setLocationRelativeTo(null);

        Font fuenteTitulo = new Font("SansSerif", Font.BOLD, 15);
        Font fuenteGeneral = new Font("Georgia", Font.PLAIN, 13);

        // Etiquetas (Dorado)
        jLabel1.setFont(fuenteTitulo); jLabel1.setForeground(colorDorado);
        jLabel2.setFont(fuenteGeneral); jLabel2.setForeground(colorDorado);
        jLabel3.setFont(fuenteGeneral); jLabel3.setForeground(colorDorado);
        jLabel4.setFont(fuenteGeneral); jLabel4.setForeground(colorDorado);
        jLabel5.setFont(fuenteGeneral); jLabel5.setForeground(colorDorado);
        jLabel6.setFont(fuenteGeneral); jLabel6.setForeground(colorDorado);
        jLabel7.setFont(fuenteGeneral); jLabel7.setForeground(colorDorado);

        // Campos de texto (Limpiando textos por defecto)
        javax.swing.JTextField[] campos = {jTextField1, jTextField2};
        for (javax.swing.JTextField campo : campos) {
            campo.setBackground(colorGrisOscuro);
            campo.setForeground(Color.WHITE);
            campo.setCaretColor(Color.WHITE);
            campo.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
            campo.setText("");
        }

        javax.swing.JPasswordField[] passwords = {jPasswordField1, jPasswordField2};
        for (javax.swing.JPasswordField pass : passwords) {
            pass.setBackground(colorGrisOscuro);
            pass.setForeground(Color.WHITE);
            pass.setCaretColor(Color.WHITE);
            pass.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
            pass.setText("");
        }

        // ComboBox de Rol
        jComboBox1.setBackground(colorGrisOscuro);
        jComboBox1.setForeground(colorDorado);
        jComboBox1.setBorder(BorderFactory.createLineBorder(colorDorado, 1));

        // Botones (Guardar y Editar en dorado, Cancelar en gris, Eliminar en rojo)
        estilizarBoton(jButton1, colorGrisOscuro, colorDorado); // Guardar
        
        jButton2.setBackground(new Color(50, 50, 50)); // Cancelar
        jButton2.setForeground(Color.LIGHT_GRAY);
        jButton2.setFocusPainted(false);
        jButton2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        jButton3.setBackground(colorGrisOscuro); // Eliminar usuario (Rojo)
        jButton3.setForeground(new Color(220, 20, 60));
        jButton3.setFocusPainted(false);
        jButton3.setBorder(BorderFactory.createLineBorder(new Color(220, 20, 60), 1));

        estilizarBoton(jButton4, colorGrisOscuro, colorDorado); // Editar

        // Tabla de usuarios
        tblUsuarios.setBackground(colorGrisOscuro);
        tblUsuarios.setForeground(Color.WHITE);
        tblUsuarios.setGridColor(colorDorado);
        tblUsuarios.getTableHeader().setBackground(colorGrisOscuro);
        tblUsuarios.getTableHeader().setForeground(colorDorado);
        
        jScrollPane1.getViewport().setBackground(colorFondo);
        jScrollPane1.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
    }

    private void estilizarBoton(javax.swing.JButton boton, Color fondo, Color texto) {
        boton.setBackground(fondo);
        boton.setForeground(texto);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createLineBorder(texto, 1));
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gestión de usuarios / Crear nuevo usuario");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Usuario");

        jLabel4.setText("Contraseña:");

        jLabel5.setText("Confirmar contraseña:");

        jLabel6.setText("Rol:");

        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Usuario", "Rol", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblUsuarios);

        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        jPasswordField1.setText("jPasswordField1");

        jPasswordField2.setText("jPasswordField1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jLabel7.setText("Usuarios existentes:");

        jButton1.setText("Guardar");

        jButton2.setText("Cancelar");

        jButton3.setText("Eliminar");

        jButton4.setText("Editar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel2))
                                        .addGap(64, 64, 64))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2)
                                    .addComponent(jPasswordField1)
                                    .addComponent(jPasswordField2)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel7)))
                .addGap(0, 122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(90, 90, 90))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(88, 88, 88))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

 
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
        java.awt.EventQueue.invokeLater(() -> new VentanaUsuario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
