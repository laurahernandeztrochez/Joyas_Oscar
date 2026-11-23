
package joyas_oscar.vista;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;

import joyas_oscar.modelo.Usuario;
import joyas_oscar.repositorio.UsuarioRepositorio;
import joyas_oscar.controlador.UsuarioControlador;
import java.util.ArrayList;    
import javax.swing.table.DefaultTableModel; 
import javax.swing.JOptionPane;


/**
 * Ventana de administración de usuarios y selección de sus roles.
 */
public class VentanaUsuario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaUsuario.class.getName());
    
    private UsuarioControlador controlador;      
    private DefaultTableModel modelo;           
    private ArrayList<Usuario> usuariosEnTabla = new ArrayList<>();   
    private int idSeleccionado = -1;
   
    
    public VentanaUsuario(UsuarioControlador controlador) {
    initComponents();
    this.controlador = controlador;

  
    modelo = new DefaultTableModel(new String[]{"NombreCompleto", "NombreUsuario", "ContrasenaHash", "Rol"}, 0);
    tblUsuarios.setModel(modelo);

 
    cargarRoles();
    cargarTabla(controlador.listaUsuario());

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    tblUsuarios.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            mostrarSeleccionado();
        }
    });

    tblUsuarios.getTableHeader().setReorderingAllowed(false);
    tblUsuarios.setDefaultEditor(Object.class, null);
    personalizarDiseño();
    setLocationRelativeTo(null);
}

private void cargarTabla(ArrayList<Usuario> lista) {
    usuariosEnTabla = lista;
    modelo.setRowCount(0);
    for (Usuario u : lista) {
        modelo.addRow(new Object[]{u.getNombreCompleto(), u.getNombreUsuario(), u.getContrasenaHash(), u.getRol().getNombre()});
    }
}

private void mostrarResultado(String mensaje) {
    JOptionPane.showMessageDialog(this, mensaje);
    if (mensaje.startsWith("Usuario ")) {
        limpiar();
        cargarTabla(controlador.listaUsuario());
    }
}

private void limpiar() {
    idSeleccionado = -1;
    txtNombre.setText("");
    txtUsuario.setText("");
    jPasswordField1.setText("");
    jPasswordField2.setText("");
    tblUsuarios.clearSelection();
    btnActualizar.setText("Editar");
}

private void mostrarSeleccionado() {
    int fila = tblUsuarios.getSelectedRow();
    if (fila == -1) {
        return;
    }

    Usuario u = usuariosEnTabla.get(fila);
    idSeleccionado = u.getIdUsuario();
    txtNombre.setText(u.getNombreCompleto());
    txtUsuario.setText(u.getNombreUsuario());
    jPasswordField1.setText(u.getContrasenaHash());
    jPasswordField2.setText(u.getContrasenaHash());
    btnActualizar.setText("Actualizar");
}

private void cargarRoles() {
    cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(
        controlador.listarRoles().toArray(new String[0])
    ));
}
    
    
    //Personalizacion
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
        javax.swing.JTextField[] campos = {txtNombre, txtUsuario};
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
        cmbRol.setBackground(colorGrisOscuro);
        cmbRol.setForeground(colorDorado);
        cmbRol.setBorder(BorderFactory.createLineBorder(colorDorado, 1));

        // Botones (Guardar y Editar en dorado, Cancelar en gris, Eliminar en rojo)
        estilizarBoton(btnGuardar, colorGrisOscuro, colorDorado); // Guardar
        
        btnLimpiar.setBackground(new Color(50, 50, 50)); 
         btnLimpiar.setForeground(Color.LIGHT_GRAY);
         btnLimpiar.setFocusPainted(false);
         btnLimpiar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        btnEliminar.setBackground(colorGrisOscuro); // Eliminar usuario (Rojo)
        btnEliminar.setForeground(new Color(220, 20, 60));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBorder(BorderFactory.createLineBorder(new Color(220, 20, 60), 1));

        estilizarBoton(btnActualizar, colorGrisOscuro, colorDorado); // Editar

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
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        txtUsuario = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        cmbRol = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gestión de usuarios / Crear nuevo usuario");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Usuario");

        jLabel4.setText("Contraseña:");

        jLabel5.setText("Confirmar contraseña:");

        jLabel6.setText("Rol:");

        txtNombre.addActionListener(this::txtNombreActionPerformed);

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

        txtUsuario.addActionListener(this::txtUsuarioActionPerformed);

        jPasswordField1.setText("jPasswordField1");

        jPasswordField2.setText("jPasswordField1");

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbRol.addActionListener(this::cmbRolActionPerformed);

        jLabel7.setText("Usuarios existentes:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnActualizar.setText("Editar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

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
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre)
                                    .addComponent(txtUsuario)
                                    .addComponent(jPasswordField1)
                                    .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                                    .addComponent(cmbRol, 0, 465, Short.MAX_VALUE))))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnLimpiar)
                                .addGap(0, 13, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(96, 96, 96))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void cmbRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRolActionPerformed
       
    }//GEN-LAST:event_cmbRolActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
          String pass = new String(jPasswordField1.getPassword());
String confirmar = new String(jPasswordField2.getPassword());

if (!pass.equals(confirmar)) {
    JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
    jPasswordField2.requestFocus();
    return; // esto es lo importante, para que no guarde
}
        
        String mensaje = controlador.guardarUsuario(
                txtNombre.getText(),
                txtUsuario.getText(),
                 jPasswordField1.getText(),
                 cmbRol.getSelectedItem().toString());
                
        mostrarResultado(mensaje);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (btnActualizar.getText().equals("Editar")) {
        JOptionPane.showMessageDialog(this, "Seleccione un usuario de la tabla");
        return;
        }

    // Si ya dice Actualizar, guarda de una
    String mensaje = controlador.actualizarUsuario(
            idSeleccionado,
            txtNombre.getText(),
            txtUsuario.getText(),
            jPasswordField1.getText(),
           jPasswordField2.getText());
    mostrarResultado(mensaje);
    btnActualizar.setText("Editar");
    
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         int fila = tblUsuarios.getSelectedRow();
        if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un usuario de la tabla");
        return;
    }

    int idSeleccionado = usuariosEnTabla.get(fila).getIdUsuario();

    int respuesta = JOptionPane.showConfirmDialog(this,
            "¿Eliminar el usuario seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION);

    if (respuesta == JOptionPane.YES_OPTION) {
        mostrarResultado(controlador.desactivarUsuario(idSeleccionado));
        cargarTabla(controlador.listaUsuario());
    
    }
    
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        txtBuscar.setText("");                 
        limpiar();
        cargarTabla(controlador.listaUsuario());
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (txtBuscar.getText().trim().isEmpty()) {
            cargarTabla(controlador.listaUsuario());
            return;
        }

        Usuario u = controlador.buscarUsuario(txtBuscar.getText());
        ArrayList<Usuario> resultado = new ArrayList<>();
        if (u != null) {
            resultado.add(u);
        } else {
            JOptionPane.showMessageDialog(this, "No existe un usuario con ese nombre");
        }
        
        cargarTabla(resultado);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

 
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
     
            
            UsuarioRepositorio usuarios = new UsuarioRepositorio();                 
            UsuarioControlador controlador = new UsuarioControlador(usuarios);    
            new VentanaUsuario (controlador).setVisible(true);                      
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbRol;
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
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}