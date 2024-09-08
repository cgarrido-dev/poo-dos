package com.ae.eventos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroEventos extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField nombreField, apellidoField, emailField, telefonoField;
    private JComboBox<String> eventoCombo, comidaCombo;
    private JCheckBox accesibilidadCheck, traduccionCheck;
    private JRadioButton masculinoRadio, femeninoRadio, otroRadio;
    private ButtonGroup generoGroup;
    private JButton registrarBtn;

    public RegistroEventos() {
        setTitle("Registro de Eventos");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Sección 1
        JPanel section1 = new JPanel(new GridLayout(6, 2, 5, 5));
        section1.setBorder(BorderFactory.createTitledBorder("Información Personal"));

        section1.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        section1.add(nombreField);

        section1.add(new JLabel("Apellido:"));
        apellidoField = new JTextField();
        section1.add(apellidoField);

        section1.add(new JLabel("Correo electrónico:"));
        emailField = new JTextField();
        section1.add(emailField);

        section1.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        section1.add(telefonoField);

        section1.add(new JLabel("Selecciona evento:"));
        String[] eventos = {"Charla A", "Taller B", "Presentación C"};
        eventoCombo = new JComboBox<>(eventos);
        section1.add(eventoCombo);

        section1.add(new JLabel("Preferencias de comida:"));
        String[] comidas = {"Ninguna", "Vegetariano", "Vegano", "Sin Gluten"};
        comidaCombo = new JComboBox<>(comidas);
        section1.add(comidaCombo);

        // Sección 2
        JPanel section2 = new JPanel(new GridLayout(2, 1));
        section2.setBorder(BorderFactory.createTitledBorder("Requisitos Especiales"));

        accesibilidadCheck = new JCheckBox("Accesibilidad");
        traduccionCheck = new JCheckBox("Traducción");
        section2.add(accesibilidadCheck);
        section2.add(traduccionCheck);

        // Sección 3
        JPanel section3 = new JPanel(new GridLayout(3, 1));
        section3.setBorder(BorderFactory.createTitledBorder("Género"));

        masculinoRadio = new JRadioButton("Masculino");
        femeninoRadio = new JRadioButton("Femenino");
        otroRadio = new JRadioButton("Otro");
        generoGroup = new ButtonGroup();
        generoGroup.add(masculinoRadio);
        generoGroup.add(femeninoRadio);
        generoGroup.add(otroRadio);
        section3.add(masculinoRadio);
        section3.add(femeninoRadio);
        section3.add(otroRadio);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        registrarBtn = new JButton("Registrarse");
        buttonPanel.add(registrarBtn);

        registrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrar();
            }
        });

        mainPanel.add(section1);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(section2);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(section3);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(buttonPanel);
        add(mainPanel);
        setVisible(true);
    }

    private void registrar() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String email = emailField.getText();
        String telefono = telefonoField.getText();
        String evento = (String) eventoCombo.getSelectedItem();
        String comida = (String) comidaCombo.getSelectedItem();

        StringBuilder requisitosEspeciales = new StringBuilder();
        if (accesibilidadCheck.isSelected()) {
            requisitosEspeciales.append("Accesibilidad ");
        }
        if (traduccionCheck.isSelected()) {
            requisitosEspeciales.append("Traducción ");
        }

        String genero = "";
        if (masculinoRadio.isSelected()) {
            genero = "Masculino";
        } else if (femeninoRadio.isSelected()) {
            genero = "Femenino";
        } else if (otroRadio.isSelected()) {
            genero = "Otro";
        }

        System.out.println("DATOS DEL REGISTRO");
        System.out.println("- Nombre: " + nombre);
        System.out.println("- Apellido: " + apellido);
        System.out.println("- Correo electrónico: " + email);
        System.out.println("- Teléfono: " + telefono);
        System.out.println("- Evento seleccionado: " + evento);
        System.out.println("- Preferencia de comida: " + comida);
        System.out.println("- Requisitos especiales: " + requisitosEspeciales.toString());
        System.out.println("- Género: " + genero);
        System.out.println("\n\n");
    }

    public static void main(String[] args) {
        new RegistroEventos();
    }
}
