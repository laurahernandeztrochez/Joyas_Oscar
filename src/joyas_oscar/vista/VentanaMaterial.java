package joyas_oscar.vista;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import joyas_oscar.controlador.MaterialControlador;
import joyas_oscar.modelo.Material;

/**
 * Ventana para consultar y gestionar materiales del inventario, incluyendo
 * sus existencias, peso, precio y tipo.
 */
public class VentanaMaterial extends JFrame {

    private static final Color FONDO = new Color(20, 20, 20);
    private static final Color FONDO_CAMPO = new Color(40, 40, 40);
    private static final Color DORADO = new Color(212, 175, 55);
    private static final Font FUENTE_ETIQUETA = new Font("Georgia", Font.PLAIN, 14);

    private final MaterialControlador controlador;
    private final DefaultTableModel modeloTabla = new DefaultTableModel(
            new String[]{"Id", "Material", "Peso (g)", "Stock", "Precio/g", "Nombre", "Total"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private ArrayList<Material> materialesEnTabla = new ArrayList<>();
    private int idSeleccionado = -1;

    public VentanaMaterial(MaterialControlador controlador) {
        this.controlador = controlador;
        initComponents();
        tabla.setModel(modeloTabla);
        configurarVentana();
        personalizarDiseno();
        configurarEventos();
        cargarTabla();
    }

    private void configurarVentana() {
        setTitle("Joyas Oscar - Registra material");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 640));
        setSize(820, 720);
        setLocationRelativeTo(null);
    }

    private void configurarEventos() {
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                mostrarSeleccionado();
            }
        });
        btnCalcular.addActionListener(evt -> calcularTotal());
        btnGuardar.addActionListener(evt -> guardarMaterial());
        btnCancelar.addActionListener(evt -> limpiarFormulario());
        btnEliminar.addActionListener(evt -> desactivarMaterial());
        btnEditar.addActionListener(evt -> actualizarMaterial());
    }

    private void personalizarDiseno() {
        getContentPane().setBackground(FONDO);

        JLabel[] etiquetas = {
            lblTitulo, lblTipoMaterial, lblPeso, lblStock, lblPrecio, lblNombre, lblExistentes
        };
        for (JLabel etiqueta : etiquetas) {
            etiqueta.setForeground(DORADO);
            etiqueta.setFont(FUENTE_ETIQUETA);
        }
        lblTitulo.setFont(new Font("Georgia", Font.BOLD, 30));
        lblExistentes.setFont(new Font("Georgia", Font.PLAIN, 16));

        for (JTextField campo : new JTextField[]{
            txtTipoMaterial, txtPeso, txtStock, txtPrecio, txtNombre, txtTotal
        }) {
            campo.setBackground(FONDO_CAMPO);
            campo.setForeground(Color.WHITE);
            campo.setCaretColor(Color.WHITE);
            campo.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(DORADO),
                    BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        }
        txtTotal.setEditable(false);
        txtTotal.setFocusable(false);

        for (JButton boton : new JButton[]{
            btnCalcular, btnGuardar, btnCancelar, btnEliminar, btnEditar
        }) {
            boton.setBackground(FONDO_CAMPO);
            boton.setForeground(DORADO);
            boton.setFocusPainted(false);
            boton.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(DORADO),
                    BorderFactory.createEmptyBorder(7, 12, 7, 12)));
            boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }

        tabla.setBackground(FONDO_CAMPO);
        tabla.setForeground(Color.WHITE);
        tabla.setGridColor(DORADO);
        tabla.setSelectionBackground(new Color(95, 78, 28));
        tabla.setSelectionForeground(Color.WHITE);
        tabla.getTableHeader().setBackground(FONDO_CAMPO);
        tabla.getTableHeader().setForeground(DORADO);
        tabla.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 12));
        tabla.setRowHeight(23);
        tabla.setFillsViewportHeight(true);
        scrollMateriales.setBorder(BorderFactory.createLineBorder(DORADO));
        scrollMateriales.getViewport().setBackground(FONDO_CAMPO);
    }

    private void calcularTotal() {
        try {
            double peso = leerDecimal(txtPeso, "El peso");
            double precio = leerDecimal(txtPrecio, "El precio");
            if (peso <= 0 || precio <= 0) {
                throw new IllegalArgumentException("Peso y precio deben ser mayores que cero");
            }
            txtTotal.setText(formatoMoneda.format(peso * precio));
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        }
    }

    private void guardarMaterial() {
        try {
            String mensaje = controlador.guardarMaterial(
                    txtNombre.getText(),
                    txtTipoMaterial.getText(),
                    leerStock(),
                    leerDecimal(txtPeso, "El peso"),
                    leerDecimal(txtPrecio, "El precio"));
            mostrarResultado(mensaje);
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        } catch (RuntimeException ex) {
            mostrarError(ex.getMessage());
        }
    }

    private void actualizarMaterial() {
        if (idSeleccionado < 0) {
            mostrarError("Seleccione un material de la tabla");
            return;
        }

        try {
            String mensaje = controlador.actualizarMaterial(
                    idSeleccionado,
                    txtNombre.getText(),
                    txtTipoMaterial.getText(),
                    leerStock(),
                    leerDecimal(txtPeso, "El peso"),
                    leerDecimal(txtPrecio, "El precio"));
            mostrarResultado(mensaje);
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        } catch (RuntimeException ex) {
            mostrarError(ex.getMessage());
        }
    }

    private void desactivarMaterial() {
        if (idSeleccionado < 0) {
            mostrarError("Seleccione un material de la tabla");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                this, "¿Desea desactivar el material seleccionado?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            mostrarResultado(controlador.desactivarMaterial(idSeleccionado));
        } catch (RuntimeException ex) {
            mostrarError(ex.getMessage());
        }
    }

    private int leerStock() {
        String texto = txtStock.getText().trim();
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("El stock es obligatorio");
        }
        try {
            int stock = Integer.parseInt(texto);
            if (stock < 0) {
                throw new IllegalArgumentException("El stock no puede ser negativo");
            }
            return stock;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("El stock debe ser un número entero");
        }
    }

    private double leerDecimal(JTextField campo, String etiqueta) {
        String texto = campo.getText().trim();
        if (texto.isEmpty()) {
            throw new IllegalArgumentException(etiqueta + " es obligatorio");
        }
        try {
            return Double.parseDouble(texto.replace(',', '.'));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(etiqueta + " debe ser numérico");
        }
    }

    private void mostrarResultado(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
        if (mensaje.equals("Material guardado")
                || mensaje.equals("Material actualizado")
                || mensaje.equals("Material desactivado")) {
            limpiarFormulario();
            cargarTabla();
        }
    }

    private void cargarTabla() {
        try {
            materialesEnTabla = controlador.listarMateriales();
            modeloTabla.setRowCount(0);
            for (Material material : materialesEnTabla) {
                modeloTabla.addRow(new Object[]{
                    material.getIdMaterial(),
                    material.getTipoMaterial(),
                    material.getPeso(),
                    material.getStock(),
                    formatoMoneda.format(material.getPrecio()),
                    material.getNombre(),
                    formatoMoneda.format(material.calcularTotal())
                });
            }
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila < 0 || fila >= materialesEnTabla.size()) {
            return;
        }
        Material material = materialesEnTabla.get(fila);
        idSeleccionado = material.getIdMaterial();
        txtTipoMaterial.setText(material.getTipoMaterial());
        txtPeso.setText(String.valueOf(material.getPeso()));
        txtStock.setText(String.valueOf(material.getStock()));
        txtPrecio.setText(String.valueOf(material.getPrecio()));
        txtNombre.setText(material.getNombre());
        txtTotal.setText(formatoMoneda.format(material.calcularTotal()));
    }

    private void limpiarFormulario() {
        txtTipoMaterial.setText("");
        txtPeso.setText("");
        txtStock.setText("");
        txtPrecio.setText("");
        txtNombre.setText("");
        txtTotal.setText("");
        tabla.clearSelection();
        idSeleccionado = -1;
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Revisar datos",
                JOptionPane.WARNING_MESSAGE);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblTitulo = new JLabel("MATERIAL");
        lblTipoMaterial = new JLabel("MATERIAL");
        lblPeso = new JLabel("PESO (g)");
        lblStock = new JLabel("STOCK");
        lblPrecio = new JLabel("PRECIO / g");
        lblNombre = new JLabel("NOMBRE");
        lblExistentes = new JLabel("Material existente");
        txtTipoMaterial = new JTextField();
        txtPeso = new JTextField();
        txtStock = new JTextField();
        txtPrecio = new JTextField();
        txtNombre = new JTextField();
        txtTotal = new JTextField();
        btnCalcular = new JButton("+ Calcular total");
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        btnEliminar = new JButton("Eliminar material");
        btnEditar = new JButton("Editar material");
        scrollMateriales = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabla.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Id", "Material", "Peso (g)", "Stock", "Precio/g", "Nombre", "Total"}));
        scrollMateriales.setViewportView(tabla);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24)
                        .addComponent(lblTipoMaterial, 130, 130, 130)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTipoMaterial, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                        .addGap(24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24)
                        .addComponent(lblPeso, 130, 130, 130)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPeso, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                        .addGap(24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24)
                        .addComponent(lblStock, 130, 130, 130)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStock, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                        .addGap(24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24)
                        .addComponent(lblPrecio, 130, 130, 130)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecio, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                        .addGap(24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24)
                        .addComponent(lblNombre, 130, 130, 130)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                        .addGap(24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCalcular)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(45, 45, 45)
                        .addComponent(btnCancelar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblExistentes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollMateriales)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(40, 40, 40)
                        .addComponent(btnEditar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblTitulo)
            .addGap(18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblTipoMaterial)
                .addComponent(txtTipoMaterial, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblPeso)
                .addComponent(txtPeso, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblStock)
                .addComponent(txtStock, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblPrecio)
                .addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblNombre)
                .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnCalcular)
                .addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnGuardar)
                .addComponent(btnCancelar))
            .addGap(16)
            .addComponent(lblExistentes)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(scrollMateriales, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnEliminar)
                .addComponent(btnEditar))
            .addContainerGap()
        );
        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private final NumberFormat formatoMoneda =
            NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-CO"));

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCalcular;
    private JButton btnCancelar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnGuardar;
    private JLabel lblExistentes;
    private JLabel lblNombre;
    private JLabel lblPeso;
    private JLabel lblPrecio;
    private JLabel lblStock;
    private JLabel lblTipoMaterial;
    private JLabel lblTitulo;
    private javax.swing.JScrollPane scrollMateriales;
    private javax.swing.JTable tabla;
    private JTextField txtNombre;
    private JTextField txtPeso;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtTipoMaterial;
    private JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
