
package joyas_oscar.vista;

//Personalizacion
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;

import joyas_oscar.controlador.PedidoControlador;
public class VentanaPedido extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPedido.class.getName());

    
    
    public VentanaPedido(PedidoControlador controlador) {
        initComponents();
        personalizarDiseño(); 
    }
    
    
    
    //Diseño
   private void personalizarDiseño() {
        Color colorFondo = new Color(20, 20, 20);
        Color colorDorado = new Color(212, 175, 55);
        Color colorGrisOscuro = new Color(40, 40, 40);
        Color colorRojo = new Color(220, 20, 60);

        getContentPane().setBackground(colorFondo);
        setTitle("Joyas Oscar - Pedidos");
        setResizable(false);
        setLocationRelativeTo(null);

        Font fuenteTitulo = new Font("SansSerif", Font.BOLD, 16);
        Font fuenteSubtitulo = new Font("SansSerif", Font.BOLD, 14);
        Font fuenteGeneral = new Font("Georgia", Font.PLAIN, 13);

        // Paneles
        Jpanel.setBackground(colorFondo);
        Jpanel.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
        jPanel2.setBackground(colorGrisOscuro);
        jPanel2.setBorder(BorderFactory.createLineBorder(colorDorado, 1));

        // Títulos
        jLabel1.setFont(fuenteTitulo);
        jLabel1.setForeground(colorDorado);
        jLabel1.setText("Pedidos registrados");

        jLabel3.setFont(fuenteSubtitulo);
        jLabel3.setForeground(colorDorado);
        jLabel3.setText("Crear pedido");

        jLabel9.setFont(fuenteSubtitulo);
        jLabel9.setForeground(colorDorado);
        jLabel9.setText("Resumen");

        // Etiquetas doradas
        javax.swing.JLabel[] etiquetas = {jLabel2, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel10, jLabel11};
        for (javax.swing.JLabel lbl : etiquetas) {
            lbl.setFont(fuenteGeneral);
            lbl.setForeground(colorDorado);
        }
        jLabel2.setText("Buscar: por nombre");
        jLabel4.setText("Cliente existente");
        jLabel5.setText("Fecha");
        jLabel6.setText("Estado");
        jLabel7.setText("Direccion de envio");
        jLabel8.setText("Detalle");
        jLabel10.setText("Subtotal:");
        jLabel11.setText("Total:");

        // Campos de texto
        javax.swing.JTextField[] campos = {txtBuscar, txtFecha, txtDireccion, txtSubtotal, txtTotal};
        for (javax.swing.JTextField campo : campos) {
            campo.setBackground(colorGrisOscuro);
            campo.setForeground(Color.WHITE);
            campo.setCaretColor(Color.WHITE);
            campo.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
        }
        txtFecha.setText("yyyy-mm-dd");
        txtDireccion.setText("");
        txtSubtotal.setEditable(false);
        txtTotal.setEditable(false);

        // Combos
        javax.swing.JComboBox[] combos = {cmbCliente, cmbEstado};
        for (javax.swing.JComboBox cmb : combos) {
            cmb.setBackground(colorGrisOscuro);
            cmb.setForeground(Color.WHITE);
            cmb.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
        }

        // Tabla Pedidos
        tblPedidos.setBackground(colorGrisOscuro);
        tblPedidos.setForeground(Color.WHITE);
        tblPedidos.setGridColor(colorDorado);
        tblPedidos.setSelectionBackground(colorDorado);
        tblPedidos.setSelectionForeground(Color.BLACK);
        tblPedidos.getTableHeader().setBackground(colorGrisOscuro);
        tblPedidos.getTableHeader().setForeground(colorDorado);
        tblPedidos.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        jScrollPane1.getViewport().setBackground(colorGrisOscuro);
        jScrollPane1.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
        tblPedidos.setFillsViewportHeight(true);

        // Tabla Detalle
        tblDetalle.setBackground(colorGrisOscuro);
        tblDetalle.setForeground(Color.WHITE);
        tblDetalle.setGridColor(colorDorado);
        tblDetalle.setSelectionBackground(colorDorado);
        tblDetalle.setSelectionForeground(Color.BLACK);
        tblDetalle.getTableHeader().setBackground(colorGrisOscuro);
        tblDetalle.getTableHeader().setForeground(colorDorado);
        tblDetalle.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        jScrollPane2.getViewport().setBackground(colorGrisOscuro);
        jScrollPane2.setBorder(BorderFactory.createLineBorder(colorDorado, 1));
        tblDetalle.setFillsViewportHeight(true);
        
        // Forzar encabezado dorado aunque Nimbus esté
estilizarEncabezado(tblPedidos, colorGrisOscuro, colorDorado);
estilizarEncabezado(tblDetalle, colorGrisOscuro, colorDorado);

        // Botones dorados
        estilizarBoton(btnGuardar, colorGrisOscuro, colorDorado);
        estilizarBoton(btnEditar, colorGrisOscuro, colorDorado);
        estilizarBoton(btnJoya, colorGrisOscuro, colorDorado);
        estilizarBoton(btnCliente, colorGrisOscuro, colorDorado);
        estilizarBoton(btnDetalle, colorGrisOscuro, colorDorado);

        // Botones rojos
        btnEliminar.setBackground(colorGrisOscuro);
        btnEliminar.setForeground(colorRojo);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBorder(BorderFactory.createLineBorder(colorRojo, 1));

        btnCancelar.setBackground(colorGrisOscuro);
        btnCancelar.setForeground(colorRojo);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBorder(BorderFactory.createLineBorder(colorRojo, 1));
    }

  private void estilizarBoton(javax.swing.JButton boton, Color fondo, Color texto) {
    boton.setContentAreaFilled(false);
    boton.setOpaque(false);
    boton.setForeground(texto);
    boton.setFocusPainted(false);
    boton.setBorder(BorderFactory.createLineBorder(texto, 1));
    boton.setBorderPainted(true);
    boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    boton.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            boton.setContentAreaFilled(true);
            boton.setBackground(new Color(212, 175, 55));
            boton.setForeground(Color.BLACK);
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            boton.setContentAreaFilled(false);
            boton.setForeground(texto);
        }
    });
} // <-- aquí cierra estilizarBoton, solo UNA llave

private void estilizarEncabezado(javax.swing.JTable tabla, Color fondo, Color texto) {
    tabla.getTableHeader().setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
        @Override
        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBackground(fondo);
            setForeground(texto);
            setFont(new Font("SansSerif", Font.BOLD, 12));
            setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            setBorder(BorderFactory.createLineBorder(texto, 1));
            return this;
        }
    });
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Jpanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        btnCliente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        btnJoya = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnDetalle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pedidos registrados");

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cliente", "Estado", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblPedidos);

        jLabel2.setText("Buscar: por nombre");

        jLabel3.setText("Crear pedido");

        jLabel4.setText("Cliente existente");

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCliente.setText("+ Nuevo cliente");

        jLabel5.setText("Fecha");

        txtFecha.setText("yyyy-mm-dd");

        jLabel6.setText("Estado");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Direccion de envio");

        txtDireccion.setText("jTextField1");

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Joya", "Precio unitario", "Cantidad", "Subtotal"
            }
        ));
        jScrollPane2.setViewportView(tblDetalle);
        if (tblDetalle.getColumnModel().getColumnCount() > 0) {
            tblDetalle.getColumnModel().getColumn(3).setHeaderValue("Acciones");
        }

        btnJoya.setText("+ Agregar joya");

        jLabel8.setText("Detalle");

        jLabel9.setText("Resumen");

        jLabel10.setText("Subtotal:");

        txtSubtotal.addActionListener(this::txtSubtotalActionPerformed);

        jLabel11.setText("Total:");

        txtTotal.addActionListener(this::txtTotalActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSubtotal))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel9)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCliente))
                    .addComponent(jLabel4)
                    .addComponent(txtFecha)
                    .addComponent(txtDireccion))
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(JpanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnJoya, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpanelLayout.createSequentialGroup()
                                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(12, 12, 12)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnJoya, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnEliminar.setText("Eliminar");

        btnEditar.setText("Editar");

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnDetalle.setText("Ver detalle");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(btnDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3)))
                        .addGap(0, 104, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(12, 12, 12)
                        .addComponent(btnEditar)
                        .addGap(15, 15, 15)
                        .addComponent(btnDetalle))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

  
    public static void main(String args[]) {
        
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
 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnJoya;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

