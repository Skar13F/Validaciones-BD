/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministradoresReg {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        // Crear un nuevo marco (JFrame)
        JFrame frame = new JFrame("Registro de Administradores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setResizable(false);  // Evita que el marco sea redimensionable

        // Crear un panel para organizar componentes
        JPanel panel = new JPanel();
        panel.setLayout(null); // Utilizamos el administrador de diseño null en el panel también
        frame.add(panel);

        // Etiquetas y campos de entrada
        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(10, 50, 80, 30);

        JTextField nombre = new JTextField();
        nombre.setBounds(100, 50, 120, 30); // (x, y, ancho, alto)

        JLabel lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(10, 90, 80, 30);

        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(100, 90, 120, 30);

        JLabel emailLabel = new JLabel("Correo Electrónico:");
        emailLabel.setBounds(10, 130, 80, 30);

        JTextField emailField = new JTextField();
        emailField.setBounds(100, 130, 120, 30);

        // Botón de registro
        JButton registerButton = new JButton("Registrar");
        registerButton.setBounds(110, 170, 100, 30);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nombre.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();

                // Aquí puedes realizar acciones con los datos ingresados, como guardarlos en una base de datos.
                System.out.println("Nombre: " + name);
                System.out.println("Apellido: " + lastName);
                System.out.println("Correo Electrónico: " + email);
            }
        });

        // Agregar componentes al panel en lugar de al marco
        panel.add(nameLabel);
        panel.add(nombre);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(emailLabel);
        panel.add(emailField);
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
