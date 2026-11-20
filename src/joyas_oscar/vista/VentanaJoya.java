
package joyas_oscar.vista;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import joyas_oscar.modelo.Joya;
import joyas_oscar.repositorio.JoyaRepositorio;

public class VentanaJoya extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaJoya.class.getName());
    private final JoyaRepositorio repositorio = new JoyaRepositorio();
    private Joya joyaEnEdicion;

  
    public VentanaJoya() {
        initComponents();
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarJoya();
            }
        });
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnEditar.addActionListener(this::btnEditarActionPerformed);
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);
        personalizarDiseno();
        cargarTabla();
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
        jTable1 = new javax.swing.JTable();
        txtStock = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gestión de joyas");

        jLabel2.setText("Registro de joya");

        jLabel3.setText("Nombre joya:");

        jLabel4.setText("Tipo material:");

        jLabel5.setText("Precio:");

        jLabel6.setText("Stock:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnBuscar.setText("Buscar");

        jLabel7.setText("Historial de joyas");

        btnEliminar.setText("Eliminar");

        btnEditar.setText("Editar");

        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(83, 83, 83)
                .addComponent(btnCancelar)
                .addGap(152, 152, 152))
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel3)
                                    .addGap(54, 54, 54)
                                    .addComponent(txtNombre))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnEliminar)
                        .addGap(28, 28, 28)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel7)))
                .addContainerGap(18, Short.MAX_VALUE))
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
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();
        cargarTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

/*
 * =========================================================================
 * Buscar una o varias joyas por nombre
 * =========================================================================
 */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            cargarTabla();
            return;
        }

        try {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);

            java.util.ArrayList<Joya> resultados =
                    repositorio.buscarPorNombre(nombre);

            for (Joya joya : resultados) {
                modelo.addRow(new Object[]{
                    joya.getIdJoya(),
                    joya.getNombre(),
                    joya.getMaterial(),
                    joya.getStock(),
                    joya.getPrecio()
                });
            }

            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No se encontraron joyas con ese nombre");
            }
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
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
            btnGuardar, btnEditar, btnEliminar, btnCancelar, btnBuscar}) {
            boton.setBackground(gris);
            boton.setForeground(dorado);
            boton.setFocusPainted(false);
            boton.setBorder(BorderFactory.createLineBorder(dorado, 1));
        }

        jTable1.setBackground(gris);
        jTable1.setForeground(Color.WHITE);
        jTable1.setGridColor(dorado);
        jTable1.getTableHeader().setBackground(gris);
        jTable1.getTableHeader().setForeground(dorado);
        jScrollPane1.getViewport().setBackground(fondo);
        jScrollPane1.setBorder(BorderFactory.createLineBorder(dorado, 1));
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Joya joya = leerCampos();
            repositorio.guardar(joya);
            cargarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Joya guardada");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        if (joyaEnEdicion == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una joya de la tabla");
            return;
        }

        try {
            Joya joya = leerCampos();
            joya.setIdJoya(joyaEnEdicion.getIdJoya());
            if (repositorio.actualizar(joya)) {
                cargarTabla();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Joya actualizada");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar la joya");
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        if (joyaEnEdicion == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una joya de la tabla");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Desea eliminar la joya seleccionada?", "Confirmar",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            repositorio.desactivar(joyaEnEdicion.getIdJoya());
            cargarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Joya eliminada");
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private Joya leerCampos() {
        String nombre = txtNombre.getText().trim();
        String material = txtTipo.getText().trim();
        String precioTexto = txtPrecio.getText().trim();
        String stockTexto = txtStock.getText().trim();

        if (nombre.isEmpty() || material.isEmpty()
                || precioTexto.isEmpty() || stockTexto.isEmpty()) {
            throw new IllegalArgumentException("Debe llenar todas las casillas");
        }

        double precio;
        int stock;
        try {
            precio = Double.parseDouble(precioTexto);
            stock = Integer.parseInt(stockTexto);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Precio y stock deben contener valores numericos");
        }

        if (precio < 0 || stock < 0) {
            throw new IllegalArgumentException("Precio y stock no pueden ser negativos");
        }

        Joya joya = new Joya();
        joya.setNombre(nombre);
        joya.setMaterial(material);
        joya.setPrecio(precio);
        joya.setStock(stock);
        joya.setActivo(true);
        return joya;
    }

    private void cargarTabla() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            for (Joya joya : repositorio.listar()) {
                modelo.addRow(new Object[]{
                    joya.getIdJoya(),
                    joya.getNombre(),
                    joya.getMaterial(),
                    joya.getStock(),
                    joya.getPrecio()
                });
            }
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void seleccionarJoya() {
        int fila = jTable1.getSelectedRow();
        if (fila < 0) {
            return;
        }

        int id = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
        joyaEnEdicion = repositorio.buscarPorId(id);
        if (joyaEnEdicion != null) {
            txtNombre.setText(joyaEnEdicion.getNombre());
            txtTipo.setText(joyaEnEdicion.getMaterial());
            txtStock.setText(String.valueOf(joyaEnEdicion.getStock()));
            txtPrecio.setText(String.valueOf(joyaEnEdicion.getPrecio()));
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtTipo.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        jTable1.clearSelection();
        joyaEnEdicion = null;
    }
   
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
        java.awt.EventQueue.invokeLater(() -> new VentanaJoya().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
