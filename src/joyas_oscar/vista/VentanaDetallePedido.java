
package joyas_oscar.vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import joyas_oscar.util.ConexionBD;
import joyas_oscar.modelo.Pedido;


public class VentanaDetallePedido extends javax.swing.JFrame {
    
    private int idPedido;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaDetallePedido.class.getName());

   
    public VentanaDetallePedido(int idPedido) {
        initComponents();
        personalizarDiseño();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
     setSize(960, 620);
    setMinimumSize(new java.awt.Dimension(960, 620));
    setLocationRelativeTo(null);
    setResizable(false);
    
        this.idPedido = idPedido;
        cargarDetalle(idPedido);
   
    }
    
      public VentanaDetallePedido() {
        initComponents();
        personalizarDiseño();
    }
      
private void cargarDetalle(int idPedido) {
    jLabel2.setText("Pedido N° " + idPedido);

 String sqlPedido = "SELECT ped.fecha_pedido, ped.total, ped.estado, "
        + "CONCAT(c.nombre, ' ', c.apellido) AS nombre_completo, "
        + "c.telefono, c.direccion "
        + "FROM pedidos ped "
        + "JOIN clientes c ON c.id_cliente = ped.id_cliente "
        + "WHERE ped.id_pedido = ?";

    String sqlDetalle = "SELECT j.nombre, dp.precio_unitario, dp.cantidad, "
            + "(dp.precio_unitario * dp.cantidad) AS subtotal "
            + "FROM detalle_pedidos dp "
            + "JOIN joyas j ON j.id_joya = dp.id_joya "
            + "WHERE dp.id_pedido = ?";

    try (Connection con = ConexionBD.obtenerConexion()) {

        // --- 1. CABECERA DEL PEDIDO ---
        try (PreparedStatement ps1 = con.prepareStatement(sqlPedido)) {
            ps1.setInt(1, idPedido);
            try (ResultSet rs = ps1.executeQuery()) {
                if (rs.next()) {
                    LabelCliente.setText("Cliente: " + rs.getString("nombre_completo"));
                    LabelTel.setText("Teléfono: " + rs.getString("telefono"));
                    LabelDir.setText("Direccion: " + rs.getString("direccion"));
                    LabelDir1.setText("Direccion de envio: " + rs.getString("direccion"));
                    LabelFecha.setText("Fecha: " + rs.getString("fecha_pedido"));
                    LabelFecha1.setText("Fecha: " + rs.getString("fecha_pedido"));
                    LabelEstado.setText("  " + rs.getString("estado") + "  ");
                    jLabel7.setText("Total: $ " + rs.getDouble("total"));
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró el pedido " + idPedido);
                    return;
                }
            }
        }

        // --- 2. TABLA DE JOYAS ---
        DefaultTableModel modelo = (DefaultTableModel) tblJoya.getModel();
        modelo.setRowCount(0);
        double subtotalGeneral = 0;

        try (PreparedStatement ps2 = con.prepareStatement(sqlDetalle)) {
            ps2.setInt(1, idPedido);
            try (ResultSet rs2 = ps2.executeQuery()) {
                while (rs2.next()) {
                    String nombreJoya = rs2.getString("nombre");
                    double precio = rs2.getDouble("precio_unitario");
                    int cantidad = rs2.getInt("cantidad");
                    double subtotal = rs2.getDouble("subtotal");
                    subtotalGeneral += subtotal;

                    modelo.addRow(new Object[]{nombreJoya, precio, cantidad, subtotal});
                }
            }
        }

        jLabel6.setText("Subtotal: $ " + subtotalGeneral);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar detalle:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void personalizarDiseño() {
    // Colores del mockup - igual que VentanaCliente y VentanaPedido
    java.awt.Color colorFondo = new java.awt.Color(20, 20, 20);
    java.awt.Color colorDorado = new java.awt.Color(212, 175, 55);
    java.awt.Color colorGrisOscuro = new java.awt.Color(40, 40, 40);
    java.awt.Color colorRojo = new java.awt.Color(220, 20, 60);

    getContentPane().setBackground(colorFondo);
    setTitle("Joyas Oscar - Detalle del Pedido");
    setResizable(false);
    setLocationRelativeTo(null);

    java.awt.Font fuenteTitulo = new java.awt.Font("SansSerif", java.awt.Font.BOLD, 16);
    java.awt.Font fuenteSubtitulo = new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14);
    java.awt.Font fuenteGeneral = new java.awt.Font("Georgia", java.awt.Font.PLAIN, 13);
    java.awt.Font fuenteGeneralBold = new java.awt.Font("Georgia", java.awt.Font.BOLD, 13);

    // --- PANELES ---
    jPanel1.setBackground(colorGrisOscuro);
    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(colorDorado, 1));

    jPanel2.setBackground(colorGrisOscuro);
    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(colorDorado, 1));

    jPanel3.setBackground(colorGrisOscuro);
    jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(colorDorado, 1));

    // --- TÍTULO PRINCIPAL ---
    jLabel1.setFont(fuenteTitulo);
    jLabel1.setForeground(colorDorado);
    jLabel1.setText("Detalle del pedido");

    jLabel2.setFont(fuenteSubtitulo);
    jLabel2.setForeground(colorDorado);
    jLabel2.setText("Pedido N°");

    // --- PILL SOLO LECTURA ---
    jLabel8.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 11));
    jLabel8.setForeground(colorRojo);
    jLabel8.setOpaque(true);
    jLabel8.setBackground(colorGrisOscuro);
    jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(colorRojo, 1));
    jLabel8.setText("  SOLO LECTURA  ");

    // --- SUBTÍTULOS ---
    jLabel3.setFont(fuenteSubtitulo);
    jLabel3.setForeground(colorDorado);
    jLabel3.setText("Información del pedido");

    jLabel4.setFont(fuenteSubtitulo);
    jLabel4.setForeground(colorDorado);
    jLabel4.setText("Detalle");

    jLabel5.setFont(fuenteSubtitulo);
    jLabel5.setForeground(colorDorado);
    jLabel5.setText("Resumen");

    // --- ETIQUETAS CON VALOR - TODO LABEL, NADA EDITABLE ---
    // Panel 1 - Cliente
    javax.swing.JLabel[] etiquetas = {LabelCliente, LabelFecha, LabelTel, LabelDir, LabelFecha1, LabelDir1, jLabel6, jLabel7};
    for (javax.swing.JLabel lbl : etiquetas) {
        lbl.setFont(fuenteGeneral);
        lbl.setForeground(colorDorado);
    }

    // --- PILL DE ESTADO ---
    LabelEstado.setFont(fuenteGeneralBold);
    LabelEstado.setForeground(java.awt.Color.BLACK);
    LabelEstado.setOpaque(true);
    LabelEstado.setBackground(colorDorado);
    LabelEstado.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 12, 4, 12));
    // Cuando lo llenes desde la BD, el texto será: "En preparación", "Enviado", etc.
    // Ejemplo: LabelEstado.setText("  En preparación  ");

    // --- TABLA JOYAS ---
    tblJoya.setBackground(colorGrisOscuro);
    tblJoya.setForeground(java.awt.Color.WHITE);
    tblJoya.setGridColor(colorDorado);
    tblJoya.setSelectionBackground(colorDorado);
    tblJoya.setSelectionForeground(java.awt.Color.BLACK);
    tblJoya.getTableHeader().setBackground(colorGrisOscuro);
    tblJoya.getTableHeader().setForeground(colorDorado);
    tblJoya.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
    jScrollPane1.getViewport().setBackground(colorGrisOscuro);
    jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(colorDorado, 1));
    tblJoya.setFillsViewportHeight(true);
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LabelCliente = new javax.swing.JLabel();
        LabelFecha = new javax.swing.JLabel();
        LabelTel = new javax.swing.JLabel();
        LabelDir = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        LabelFecha1 = new javax.swing.JLabel();
        LabelDir1 = new javax.swing.JLabel();
        LabelEstado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJoya = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Detalle del pedido");

        jLabel2.setText("Pedido N°");

        LabelCliente.setText("Cliente:");

        LabelFecha.setText("Fecha:");

        LabelTel.setText("Teléfono:");

        LabelDir.setText("Direccion:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelTel)
                    .addComponent(LabelCliente))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelFecha)
                    .addComponent(LabelDir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCliente)
                    .addComponent(LabelFecha))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTel)
                    .addComponent(LabelDir))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel3.setText("Información del pedido");

        LabelFecha1.setText("Fecha:");

        LabelDir1.setText("Direccion de envio:");

        LabelEstado.setText("Estado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(LabelFecha1)
                                .addGap(48, 48, 48)
                                .addComponent(LabelDir1))
                            .addComponent(LabelEstado))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelFecha1)
                    .addComponent(LabelDir1))
                .addGap(47, 47, 47)
                .addComponent(LabelEstado)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLabel4.setText("Detalle ");

        tblJoya.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblJoya);

        jLabel5.setText("Resumen");

        jLabel6.setText("Subtotal:");

        jLabel7.setText("Total:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel5)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jLabel8.setText("SOLO LECTURA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
        java.awt.EventQueue.invokeLater(() -> new VentanaDetallePedido().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCliente;
    private javax.swing.JLabel LabelDir;
    private javax.swing.JLabel LabelDir1;
    private javax.swing.JLabel LabelEstado;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JLabel LabelFecha1;
    private javax.swing.JLabel LabelTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblJoya;
    // End of variables declaration//GEN-END:variables
}
