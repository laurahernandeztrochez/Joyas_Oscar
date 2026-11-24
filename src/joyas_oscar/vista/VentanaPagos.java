
package joyas_oscar.vista;

//Personalizacion
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
public class VentanaPagos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPagos.class.getName());

 
    
    
    public VentanaPagos() {
        initComponents();
        personalizarDiseño();
        pack();
        setLocationRelativeTo(null);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    
 private void personalizarDiseño() {
        Color fondo = new Color(20, 20, 20);
        Color dorado = new Color(212, 175, 55);
        Color gris = new Color(40, 40, 40);

        getContentPane().setBackground(fondo);
        setTitle("Joyas Oscar - Pagos");
        setResizable(false);
        setLocationRelativeTo(null);
        // SIN borde en toda la ventana

        // --- TITULO CON TU pago.jpg A LOS 2 LADOS ---
        jLabel1.setText("PAGOS");
        jLabel1.setForeground(dorado);
        jLabel1.setFont(new Font("SansSerif", Font.BOLD, 24));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon iconoPago = cargarIconoPago(32, 24);
        if (iconoPago != null) {
            lblIconoIzq.setIcon(iconoPago);
            lblIconoDer.setIcon(iconoPago);
        }
        jLabel1.setBackground(fondo);

        // --- SOLO EL CUADRO DE REGISTRAR PAGO TIENE BORDE ---
        jPanelForm.setBackground(fondo);
        jPanelForm.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(dorado, 1),
            BorderFactory.createEmptyBorder(12, 20, 12, 20)
        ));

        jLabel2.setText("+  Registrar Pago");
        jLabel2.setForeground(dorado);
        jLabel2.setFont(new Font("SansSerif", Font.BOLD, 16));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel8.setText("Historial de pagos");
        jLabel8.setForeground(dorado);
        jLabel8.setFont(new Font("SansSerif", Font.BOLD, 16));
        jLabel8.setHorizontalAlignment(SwingConstants.CENTER);

        // Etiquetas igual que tu otra ventana: todas doradas
        JLabel[] etiquetas = {jLabel3, jLabel4, jLabel5, jLabel6, jLabel7};
        for (JLabel etiqueta : etiquetas) {
            etiqueta.setForeground(dorado);
            etiqueta.setFont(new Font("SansSerif", Font.PLAIN, 13));
        }

        // Campos igual que tu otra ventana
        JTextField[] campos = {txtMonto, txtFecha};
        for (JTextField campo : campos) {
            campo.setBackground(gris);
            campo.setForeground(Color.WHITE);
            campo.setCaretColor(Color.WHITE);
            campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(dorado, 1),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)
            ));
        }

// Combos SIN FONDO, solo borde gris
Color grisBorde = new Color(100, 100, 100);

JComboBox[] combos = {cmbPedido, cmbMetodo, cmbEstado};
for (JComboBox combo : combos) {
    combo.setBackground(fondo); // mismo color de la ventana = se ve sin fondo
    combo.setForeground(Color.WHITE);
    combo.setOpaque(false);
    combo.setBorder(BorderFactory.createLineBorder(grisBorde, 1));
}

       // Botones SIN FONDO, solo marco dorado - menos Cancelar
for (JButton boton : new JButton[]{btnGuardar, btnEditar, btnEliminar}) {
    boton.setBackground(fondo); // mismo color de la ventana = se ve sin fondo
    boton.setForeground(dorado);
    boton.setFocusPainted(false);
    boton.setContentAreaFilled(false); // <- esto quita el relleno
    boton.setOpaque(false);
    boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton.setBorder(BorderFactory.createLineBorder(dorado, 1));
}

// Cancelar SI tiene fondo gris como tu otra ventana
btnCancelar.setBackground(gris);
btnCancelar.setForeground(dorado);
btnCancelar.setFocusPainted(false);
btnCancelar.setOpaque(true);
btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
btnCancelar.setBorder(BorderFactory.createLineBorder(dorado, 1));

        // Tabla IGUAL QUE TU OTRA VENTANA
        tblPagos.setBackground(gris);
        tblPagos.setForeground(Color.WHITE);
        tblPagos.setGridColor(dorado);
        tblPagos.setRowHeight(26);
        tblPagos.getTableHeader().setBackground(gris);
        tblPagos.getTableHeader().setForeground(dorado);
        tblPagos.getTableHeader().setBorder(BorderFactory.createLineBorder(dorado, 1));
        jScrollPane1.getViewport().setBackground(fondo);
        jScrollPane1.setBorder(BorderFactory.createLineBorder(dorado, 1));

        // Centrar celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tblPagos.getColumnCount(); i++) {
            tblPagos.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        // TABLA FIJA - no se mueve nada
tblPagos.getTableHeader().setReorderingAllowed(false); // no arrastrar columnas
tblPagos.getTableHeader().setResizingAllowed(false);   // no estirar columnas
tblPagos.setRowSelectionAllowed(true); // si quieres que se pueda seleccionar la fila para Editar/Eliminar
tblPagos.setColumnSelectionAllowed(false);
tblPagos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
tblPagos.setDragEnabled(false);
tblPagos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    private ImageIcon cargarIconoPago(int ancho, int alto) {
        String[] rutas = {"/joyas_oscar/vista/pago.jpg", "/joyas_oscar/vista/pago.png"};
        for (String ruta : rutas) {
            URL recurso = getClass().getResource(ruta);
            if (recurso != null) {
                Image img = new ImageIcon(recurso).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                return new ImageIcon(img);
            }
        }
        System.err.println("No se encontró pago.jpg en vista");
        return null;
    }
    
  
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanelForm = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbPedido = new javax.swing.JComboBox<>();
        txtFecha = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbMetodo = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblIconoIzq = new javax.swing.JLabel();
        lblIconoDer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pagos");

        jLabel8.setText("Historial de pagos");

        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Pedido", "Cliente", "Fecha", "Metodo", "Monto", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblPagos);

        btnEditar.setText("Editar");

        btnEliminar.setText("Eliminar");

        jLabel2.setText("Registrar Pago");

        jLabel3.setText("Pedido ligado:");

        jLabel4.setText("Monto:");

        jLabel5.setText("Metodo de pago:");

        jLabel6.setText("Fecha de pago:");

        jLabel7.setText("Estado");

        cmbPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel4))
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5))
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMonto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );
        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cmbPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(14, 14, 14)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lblIconoIzq)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIconoDer)
                            .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIconoIzq)
                            .addComponent(lblIconoDer)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)))
                .addGap(26, 26, 26)
                .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
      
    // SIN NIMBUS - si lo dejas, te pinta todo de blanco
    try {
        javax.swing.UIManager.setLookAndFeel(
            javax.swing.UIManager.getCrossPlatformLookAndFeelClassName()
        );
    } catch (Exception ex) {
        logger.log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaPagos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbMetodo;
    private javax.swing.JComboBox<String> cmbPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIconoDer;
    private javax.swing.JLabel lblIconoIzq;
    private javax.swing.JTable tblPagos;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables

}
