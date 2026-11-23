
package joyas_oscar.vista;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import joyas_oscar.modelo.Joya;
import joyas_oscar.repositorio.JoyaRepositorio;
import joyas_oscar.controlador.JoyaControlador;
import java.util.ArrayList;         

/**
 * Ventana para consultar y gestionar las joyas del inventario desde
 * una tabla y un formulario.
 */
public class VentanaJoya extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaJoya.class.getName());
   
    private Joya joyaEnEdicion;
    
    private JoyaControlador controlador;    
    private int idSeleccionado = -1;
    private ArrayList<Joya> joyasEnTabla = new ArrayList<>(); 
    private DefaultTableModel modelo;  

  
    public VentanaJoya(JoyaControlador controlador) {
    
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         this.controlador = controlador;   
         modelo = new DefaultTableModel(new String[]{"Nombre", "Material", "Precio","Stock"}, 0);
        tblJoyas.setModel(modelo);
         
        tblJoyas.setDefaultEditor(Object.class, null);
        tblJoyas.getTableHeader().setReorderingAllowed(false);
        tblJoyas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarSeleccionado();
            }
        });
        
        personalizarDiseno();
       
        cargarTabla(controlador.listarJoya());         
        setLocationRelativeTo(null);      
    }
    
 private void cargarTabla(ArrayList<Joya> lista) {
    joyasEnTabla = lista;
    modelo.setRowCount(0); // limpia la tabla
    for (Joya j : lista) {
        modelo.addRow(new Object[]{
            j.getIdJoya(),
            j.getNombre(),
            j.getMaterial(),
            j.getPrecio(),
            j.getStock()
        });
    }
}
    private void mostrarResultado(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
        if (mensaje.startsWith("Joya ")) {    
            limpiar();
            cargarTabla(controlador.listarJoya());
        }
    }
    
      private void limpiar() {
        idSeleccionado = -1;                 
        txtNombre.setText("");
        txtTipo.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        tblJoyas.clearSelection();            
    }
        
    private void mostrarSeleccionado() {
        int fila = tblJoyas.getSelectedRow(); 
        if (fila == -1) {
            return;
        }
        Joya j = joyasEnTabla.get(fila);  
        idSeleccionado = j.getIdJoya();            
        txtNombre.setText(j.getNombre());
        txtTipo.setText(j.getMaterial());
        txtPrecio.setText(String.valueOf(j.getPrecio()));
        txtStock.setText(String.valueOf(j.getStock()));
    }   
    
    
    private void personalizarDiseno() {
        Color fondo = new Color(20, 20, 20);
        Color dorado = new Color(212, 175, 55);
        Color gris = new Color(40, 40, 40);

        getContentPane().setBackground(fondo);
        setTitle("Joyas Oscar - Joya");
        setResizable(false);
        setLocationRelativeTo(null);

        javax.swing.JLabel[] etiquetas = {jLabel1, jLabel2, jLabel3, jLabel4,
            jLabel5, jLabel6, jLabel7};
        for (javax.swing.JLabel etiqueta : etiquetas) {
            etiqueta.setForeground(dorado);
        }

        javax.swing.JTextField[] campos = {txtNombre, txtTipo, txtPrecio, txtStock};
        for (javax.swing.JTextField campo : campos) {
            campo.setBackground(gris);
            campo.setForeground(Color.WHITE);
            campo.setCaretColor(Color.WHITE);
            campo.setBorder(BorderFactory.createLineBorder(dorado, 1));
        }

        for (javax.swing.JButton boton : new javax.swing.JButton[]{
            btnGuardar, btnEditar, btnEliminar, btnLimpiar, btnBuscar}) {
            boton.setBackground(gris);
            boton.setForeground(dorado);
            boton.setFocusPainted(false);
            boton.setBorder(BorderFactory.createLineBorder(dorado, 1));
        }

        tblJoyas.setBackground(gris);
        tblJoyas.setForeground(Color.WHITE);
        tblJoyas.setGridColor(dorado);
        tblJoyas.getTableHeader().setBackground(gris);
        tblJoyas.getTableHeader().setForeground(dorado);
        jScrollPane1.getViewport().setBackground(fondo);
        jScrollPane1.setBorder(BorderFactory.createLineBorder(dorado, 1));
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
        tblJoyas = new javax.swing.JTable();
        txtStock = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gestión de joyas");

        jLabel2.setText("Registro de joya");

        jLabel3.setText("Nombre joya:");

        jLabel4.setText("Tipo material:");

        jLabel5.setText("Precio:");

        jLabel6.setText("Stock:");

        tblJoyas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre joya", "Material", "Stock", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tblJoyas);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        jLabel7.setText("Historial de joyas");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel3)
                                    .addGap(54, 54, 54)
                                    .addComponent(txtNombre))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel7)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    if (txtBuscar.getText().trim().isEmpty()) {
        cargarTabla(controlador.listarJoya());
        return;
    }

    ArrayList<Joya> resultado = controlador.buscarJoya(txtBuscar.getText());

    if (resultado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No existe una joya con ese nombre");
    }

    cargarTabla(resultado);
    
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
 try {
        String mensaje = controlador.guardarJoya(
            txtNombre.getText(),
            txtTipo.getText(),
            Double.parseDouble(txtPrecio.getText()),
            Integer.parseInt(txtStock.getText())
        );
        mostrarResultado(mensaje);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Precio y stock deben ser números");
    }
 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

           String mensaje = controlador.actualizarJoya(
            idSeleccionado,
            txtNombre.getText(),
            txtTipo.getText(),
            Double.parseDouble(txtPrecio.getText()),
            Integer.parseInt(txtStock.getText())
        );
        mostrarResultado(mensaje);
    
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
            int fila = tblJoyas.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una joya de la tabla");
        return;
    }

    int idSeleccionado = joyasEnTabla.get(fila).getIdJoya();

    int respuesta = JOptionPane.showConfirmDialog(this,
            "¿Eliminar la joya seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION);

    if (respuesta == JOptionPane.YES_OPTION) {
        mostrarResultado(controlador.desactivarJoya(idSeleccionado));
        cargarTabla(controlador.listarJoya());
    }
    
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        txtBuscar.setText("");
        limpiar();
        cargarTabla(controlador.listarJoya());
    }//GEN-LAST:event_btnLimpiarActionPerformed

    
   
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
        JoyaRepositorio joyas = new JoyaRepositorio();                 
            JoyaControlador controlador = new JoyaControlador(joyas); 
            
            new VentanaJoya (controlador).setVisible(true);                      
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblJoyas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
