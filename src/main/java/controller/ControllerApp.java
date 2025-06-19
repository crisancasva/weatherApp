package controller;

import model.ModelApp;
import view.ViewApp;
import org.json.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerApp {

    private final ModelApp model;
    private final ViewApp view;

    public ControllerApp(ModelApp model, ViewApp view) {
        this.model = model;
        this.view = view;

        this.view.buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudad = view.ciudadTextField.getText();

                try {
                    JSONObject clima = model.obtenerClima(ciudad);
                    double temperatura = clima.getJSONObject("main").getDouble("temp");
                    int humedad = clima.getJSONObject("main").getInt("humidity");

                    view.temperaturaLabel.setText("Temperatura: " + temperatura + "°C");
                    view.humedadLabel.setText("Humedad: " + humedad + "%");

                } catch (Exception ex) {
                    view.temperaturaLabel.setText("Error al obtener clima");
                    view.humedadLabel.setText("");
                    ex.printStackTrace();
                }
            }
        });
    }
}
