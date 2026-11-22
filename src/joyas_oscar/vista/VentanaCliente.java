
package joyas_oscar.vista;

import javax.swing.JOptionPane;
import joyas_oscar.modelo.Cliente;
import joyas_oscar.repositorio.ClienteRepositorio;
import java.util.ArrayList;                          
import javax.swing.table.DefaultTableModel;         
import joyas_oscar.controlador.ClienteControlador;     


//Para tema de decoracion de interfaz
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;


public class VentanaCliente extends javax.swing.JFrame {
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaCliente.class.getName());
    
    private ClienteControlador controlador;      
    private DefaultTableModel modelo;           
    private ArrayList<Cliente> clientesEnTabla = new ArrayList<>();   
    private int idSeleccionado = -1;
          
 
  

   
    public VentanaCliente(ClienteControlador controlador) {
        
    
        initComponents();     
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                                                
        this.controlador = controlador;          

        
        modelo = new DefaultTableModel(new String[]{"Nombre", "Apellido", "Teléfono","Direccion"}, 0);
        tblCliente.setModel(modelo);
           
        tblCliente.getTableHeader().setReorderingAllowed(false); 
         tblCliente.setDefaultEditor(Object.class,null); 
        personalizarDiseño(); 

        cargarTabla(controlador.listarClientes());         
        setLocationRelativeTo(null);                       
    }
    
    
    
     private void cargarTabla(ArrayList<Cliente> lista) {
        clientesEnTabla = lista;                
        modelo.setRowCount(0);                  
        for (Cliente c : lista) {
            modelo.addRow(new Object[]{c.getNombre(), c.getApellido(), c.getTelefono(), c.getDireccion()});
        }
    }


    private void mostrarResultado(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
        if (mensaje.startsWith("Cliente ")) {    
            limpiar();
            cargarTabla(controlador.listarClientes());
        }
    }
  
    private void limpiar() {
        idSeleccionado = -1;                 
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        tblCliente.clearSelection();            
    }
    
    
    private void mostrarSeleccionado() {
        int fila = tblCliente.getSelectedRow(); 
        if (fila == -1) {
            return;
        }
        Cliente c = clientesEnTabla.get(fila);  
        idSeleccionado = c.getIdCliente();            
        txtNombre.setText(c.getNombre());
        txtApellido.setText(c.getApellido());
        txtTelefono.setText(c.getTelefono());
        txtDireccion.setText(c.getDireccion());
    }   
    
        
    
//Diseño
    private void personalizarDiseño() {
        // Colores basados en el mockup
        Color colorFondo = new Color(20, 20, 20);
        Color colorDorado = new Color(212, 175, 55);
        Color colorGrisOscuro = new Color(40, 40, 40);
        
        getContentPane().setBackground(colorFondo);
        setTitle("Joyas Oscar - Cliente");
        setResizable(false);
        setLocationRelativeTo(null);

        // Fuentes y Estilos de Texto
        Font fuenteTitulo = new Font("SansSerif", Font.BOLD, 15);
        Font fuenteGeneral = new Font("Georgia", Font.PLAIN, 13);

        // Títulos y Etiquetas (Dorado)
        jLabel2.setFont(fuenteGeneral); jLabel2.setForeground(colorDorado);
        jLabel3.setFont(fuenteGeneral); jLabel3.setForeground(colorDorado);
        jLabel4.setFont(fuenteGeneral); jLabel4.setForeground(colorDorado);
        jLabel5.setFont(fuenteGeneral); jLabel5.setForeground(colorDorado);
        
        jLabel6.setFont(fuenteTitulo);
        jLabel6.setForeground(colorDorado);
        jLabel6.setText("Datos Del Cliente");

        jLabel7.setFont(fuenteGeneral);
        jLabel7.setForeground(colorDorado);
        jLabel7.setText("Lista de clientes:");

        // Campos de Texto (Estilo Oscuro con borde dorado)
        javax.swing.JTextField[] campos = {txtNombre, txtApellido, txtTelefono, txtDireccion,txtBuscar};
        for (javax.swing.JTextField campo : campos) {
            campo.setBackground(colorGrisOscuro);
            campo.setForeground(Color.WHITE);
            campo.setCaretColor(Color.WHITE);
            campo.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
        }

        // Estilos de los Botones
        estilizarBoton(btnGuardar, colorGrisOscuro, colorDorado);
        estilizarBoton(btnActualizar, colorGrisOscuro, colorDorado);
        estilizarBoton(btnEliminar, colorGrisOscuro, colorDorado);
       estilizarBoton(btnBuscar, colorGrisOscuro, colorDorado);
        
        // Botón Limpiar en color rojo como el mockup
        btnLimpiar.setBackground(colorGrisOscuro);
        btnLimpiar.setForeground(new Color(220, 20, 60));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setBorder(BorderFactory.createLineBorder(new Color(220, 20, 60), 1));

        // Estilo de la Tabla y Scroll
        tblCliente.setBackground(colorGrisOscuro);
        tblCliente.setForeground(Color.WHITE);
        tblCliente.setGridColor(colorDorado);
        tblCliente.getTableHeader().setBackground(colorGrisOscuro);
        tblCliente.getTableHeader().setForeground(colorDorado);
        
        
        jScrollPane1.getViewport().setBackground(colorFondo);
        tblCliente.setFillsViewportHeight(true); 
jScrollPane1.getViewport().setBackground(colorGrisOscuro); 
        jScrollPane4.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
        
        
        // Limpiar textos adicionales para que no se encimen
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Teléfono:");

        txtNombre.addActionListener(this::txtNombreActionPerformed);

        txtDireccion.addActionListener(this::txtDireccionActionPerformed);

        jLabel4.setText("Apellido:");

        jLabel5.setText("Dirección");

        jLabel6.setText("Datos del Cliente");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnActualizar.setText("Editar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        jLabel7.setText("Lista de Clientes");

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Nombre completo", "Telefono", "Direccion"
            }
        ));
        jScrollPane4.setViewportView(tblCliente);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 614, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addGap(275, 275, 275))
                                                    .addComponent(txtApellido)))
                                            .addComponent(txtDireccion))))))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
  String mensaje = controlador.guardarCliente(
                txtNombre.getText(),
                txtApellido.getText(),
                txtTelefono.getText(),
                txtDireccion.getText());
        mostrarResultado(mensaje);

   //Cierra boton guardar:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
      
       String mensaje = controlador.actualizarCliente(
                idSeleccionado,                 
                txtNombre.getText(),
                txtApellido.getText(),
                txtTelefono.getText(),
                txtDireccion.getText());
        mostrarResultado(mensaje);
        
    //Cierra boton editar
  
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      
    int fila = tblCliente.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente de la tabla");
        return;
    }

    int idSeleccionado = clientesEnTabla.get(fila).getIdCliente();

    int respuesta = JOptionPane.showConfirmDialog(this,
            "¿Eliminar el cliente seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION);

    if (respuesta == JOptionPane.YES_OPTION) {
        mostrarResultado(controlador.desactivarCliente(idSeleccionado));
        cargarTabla(controlador.listarClientes());
    
}
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
      
        txtBuscar.setText("");                 
        limpiar();
        cargarTabla(controlador.listarClientes());
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
 
        if (txtBuscar.getText().trim().isEmpty()) {
            cargarTabla(controlador.listarClientes());
            return;
        }
     
        Cliente c = controlador.buscarCliente(txtBuscar.getText());
        ArrayList<Cliente> resultado = new ArrayList<>();
        if (c != null) {                       
            resultado.add(c);
        } else {
            JOptionPane.showMessageDialog(this, "No existe un cliente con ese nombre");
        }
        cargarTabla(resultado);
    }//GEN-LAST:event_btnBuscarActionPerformed

   
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
        javax.swing.UIManager.put("ScrollPane.border", javax.swing.BorderFactory.createEmptyBorder());
        java.awt.EventQueue.invokeLater(() -> {
            
            
            ClienteRepositorio clientes = new ClienteRepositorio();                 
            ClienteControlador controlador = new ClienteControlador(clientes);    
            new VentanaCliente (controlador).setVisible(true);                      
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}