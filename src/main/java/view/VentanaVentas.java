package view;

import controller.InventarioController;
import entity.Inventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaVentas extends JFrame {
    private InventarioController inventarioController = new InventarioController();
    private JTextField campoIdProducto;
    private JTextField campoCantidad;
    private JButton botonVender;
    private JButton botonCerrar; // Nuevo botón para cerrar la ventana
    private JLabel etiquetaResultado;

    public VentanaVentas() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Ventana de Ventas");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel etiquetaIdProducto = new JLabel("ID del Producto:");
        campoIdProducto = new JTextField(20);

        JLabel etiquetaCantidad = new JLabel("Cantidad:");
        campoCantidad = new JTextField(5);

        botonVender = new JButton("Realizar Venta");
        botonCerrar = new JButton("Cerrar"); // Agregar botón para cerrar
        etiquetaResultado = new JLabel("");

        botonVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonVenderActionPerformed(e);
            }
        });

        botonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana
            }
        });

        panel.add(etiquetaIdProducto);
        panel.add(campoIdProducto);
        panel.add(etiquetaCantidad);
        panel.add(campoCantidad);
        panel.add(botonVender);
        panel.add(etiquetaResultado);
        panel.add(botonCerrar); // Agregar el botón de cerrar

        this.add(panel);
    }

    private void botonVenderActionPerformed(ActionEvent evt) {
        String idProducto = campoIdProducto.getText();
        int cantidadVendida = Integer.parseInt(campoCantidad.getText());

        Inventario inventario = inventarioController.consultarExistenciaProducto(idProducto);

        if (inventario != null && inventario.getExistencia() >= cantidadVendida) {
            boolean ventaExitosa = inventarioController.realizarVenta(idProducto, cantidadVendida);

            if (ventaExitosa) {
                etiquetaResultado.setText("Venta exitosa.");
            } else {
                etiquetaResultado.setText("No se pudo realizar la venta.");
            }
        } else {
            etiquetaResultado.setText("No hay suficientes existencias.");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVentas().setVisible(true);
            }
        });
    }
}