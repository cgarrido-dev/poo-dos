package com.tipodecambio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;
import org.json.JSONObject;

public class TipoDeCambioApp extends JFrame {

	private static final long serialVersionUID = 1L;
    private JTextField txtFecha;
    private JTextField txtMoneda;
    private JTextField txtValor;
    private JButton btnObtenerDatos;

    public TipoDeCambioApp() {
        setTitle("Consulta Tipo de Cambio");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel lblFecha = new JLabel("Fecha:");
        txtFecha = new JTextField();
        txtFecha.setEditable(false);

        JLabel lblMoneda = new JLabel("Moneda:");
        txtMoneda = new JTextField();
        txtMoneda.setEditable(false);

        JLabel lblValor = new JLabel("Valor:");
        txtValor = new JTextField();
        txtValor.setEditable(false);


        btnObtenerDatos = new JButton("Obtener Datos");


        add(lblFecha);
        add(txtFecha);
        add(lblMoneda);
        add(txtMoneda);
        add(lblValor);
        add(txtValor);
        add(new JLabel());
        add(btnObtenerDatos);


        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerDatosAPI();
            }
        });
    }

    private void obtenerDatosAPI() {
        try {

			@SuppressWarnings("deprecation")
			URL obj = new URL("http://localhost:3000/");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray tipoCambioArray = jsonResponse.getJSONArray("tipo_cambio");
            JSONObject tipoCambio = tipoCambioArray.getJSONObject(0);

            String fecha = tipoCambio.getString("fecha");
            String moneda = tipoCambio.getString("moneda");
            double valor = tipoCambio.getDouble("valor");

            txtFecha.setText(fecha);
            txtMoneda.setText(moneda);
            txtValor.setText(String.valueOf(valor));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener datos de la API", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TipoDeCambioApp app = new TipoDeCambioApp();
            app.setVisible(true);
        });
    }
}
