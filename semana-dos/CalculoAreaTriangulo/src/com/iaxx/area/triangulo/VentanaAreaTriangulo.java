package com.iaxx.area.triangulo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAreaTriangulo extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JTextField txtBase;
    private JTextField txtAltura;
    private JLabel lblResultado;

    public VentanaAreaTriangulo() {
        setTitle("Cálculo del Área de un Triángulo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel lblBase = new JLabel("Base:");
        txtBase = new JTextField();
        JLabel lblAltura = new JLabel("Altura:");
        txtAltura = new JTextField();
        JButton btnCalcular = new JButton("Calcular Área");
        lblResultado = new JLabel("");

        add(lblBase);
        add(txtBase);
        add(lblAltura);
        add(txtAltura);
        add(new JLabel());
        add(btnCalcular);
        add(lblResultado);

        btnCalcular.addActionListener(new CalculoAreaListener());
    }

    private class CalculoAreaListener implements ActionListener {
        
    	@Override
        public void actionPerformed(ActionEvent e) {
            try {

                double base = Double.parseDouble(txtBase.getText());
                double altura = Double.parseDouble(txtAltura.getText());

                if (base <= 0 || altura <= 0) {
                    throw new IllegalArgumentException("La base y la altura deben ser positivas.");
                }

                double area = (base * altura) / 2;

                lblResultado.setText("Área: " + area);

            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Ingrese valores numéricos válidos.");
            } catch (IllegalArgumentException ex) {
                lblResultado.setText("Error: " + ex.getMessage());
            } catch (Throwable ex) {
                lblResultado.setText("Error inesperado: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaAreaTriangulo ventana = new VentanaAreaTriangulo();
            ventana.setVisible(true);
        });
    }
}
