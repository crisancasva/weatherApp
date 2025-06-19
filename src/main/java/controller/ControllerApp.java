package controller;

import model.ModelApp;
import model.Repositorio;
import org.json.JSONObject;
import view.ViewApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerApp {

    private final ModelApp model;
    private final ViewApp view;
    private final Repositorio repo;

    public ControllerApp(ModelApp model, ViewApp view) {
        this.model = model;
        this.view = view;
        this.repo = new Repositorio();

        this.view.buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudad = view.ciudadTextField.getText().trim();
                if (ciudad.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Por favor ingresa una ciudad.");
                    return;
                }

                try {
                    JSONObject clima = model.obtenerClima(ciudad);
                    double temperatura = clima.getJSONObject("main").getDouble("temp");
                    int humedad = clima.getJSONObject("main").getInt("humidity");

                    view.temperaturaLabel.setText("Temperatura: " + temperatura + " °C");
                    view.humedadLabel.setText("Humedad: " + humedad + " %");

                    // Guardar en MongoDB
                    repo.guardarConsulta(ciudad, temperatura, humedad);

                } catch (Exception ex) {
                    view.temperaturaLabel.setText("Temperatura: error");
                    view.humedadLabel.setText("Humedad: error");
                    JOptionPane.showMessageDialog(view,
                            "No se pudo obtener el clima para la ciudad: " + ciudad,
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
