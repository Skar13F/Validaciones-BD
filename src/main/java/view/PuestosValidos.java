package view;

import controller.PuestosValidosController;
import entity.Empleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuestosValidos {

    public static PuestosValidosController controller;
    public static Empleado empleado;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            crearYMostrarFormulario();
        });
    }

    private static void crearYMostrarFormulario() {
        controller = new PuestosValidosController();
        empleado = new Empleado();

        // Crear un nuevo marco (JFrame)
        JFrame frame = new JFrame("Registro de Empleados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setResizable(false);  // Evita que el marco sea redimensionable

        // Crear un panel para organizar componentes
        JPanel panel = new JPanel();
        panel.setLayout(null); // Utilizamos el administrador de diseño null en el panel también
        frame.add(panel);

        // Etiquetas y campos de entrada
        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(10, 50, 80, 30);

        JTextField idEmpleado = new JTextField();
        idEmpleado.setBounds(100, 50, 120, 30);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 90, 80, 30);

        JTextField nombre = new JTextField();
        nombre.setBounds(100, 90, 120, 30);

        JLabel puestoLabel = new JLabel("Puesto:");
        puestoLabel.setBounds(10, 130, 80, 30);

        String[] puestosValidos = {"Gerente", "Administrativo", "Vendedor"};
        JComboBox<String> puestoComboBox = new JComboBox<>(puestosValidos);
        puestoComboBox.setBounds(100, 130, 120, 30);

        // Botón de registro
        JButton registerButton = new JButton("Registrar");
        registerButton.setBounds(110, 170, 100, 30);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empleado.setIdEmpleado(idEmpleado.getText());
                empleado.setNombre(nombre.getText());
                String selectedPuesto = (String) puestoComboBox.getSelectedItem();
                empleado.setPuesto(selectedPuesto);

                try {
                    controller.crearRegistro(empleado);
                    JOptionPane.showMessageDialog(null, "Registro de empleado insertado con éxito.");
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "El registro no pudo insertarse");
                }
            }
        });

        // Agregar componentes al panel en lugar de al marco
        panel.add(idLabel);
        panel.add(idEmpleado);
        panel.add(nombreLabel);
        panel.add(nombre);
        panel.add(puestoLabel);
        panel.add(puestoComboBox);
        panel.add(registerButton);

        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Obtener el tamaño del marco
        Dimension frameSize = frame.getSize();

        // Calcular la ubicación para centrar el marco
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;

        // Establecer la ubicación del marco en el centro de la pantalla
        frame.setLocation(x, y);
        frame.setVisible(true);
    }
}