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
        frame.setSize(600, 500);
        frame.setLayout(new GridLayout(4, 2));

        // Etiquetas y campos de entrada
        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = new JTextField(20);

        JLabel lastNameLabel = new JLabel("Apellido:");
        JTextField lastNameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Correo Electrónico:");
        JTextField emailField = new JTextField(20);

        // Botón de registro
        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                
                // Aquí puedes realizar acciones con los datos ingresados, como guardarlos en una base de datos.
                System.out.println("Nombre: " + name);
                System.out.println("Apellido: " + lastName);
                System.out.println("Correo Electrónico: " + email);
            }
        });

        // Agregar componentes al marco
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(lastNameLabel);
        frame.add(lastNameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(registerButton);

        frame.setVisible(true);
    }
}

