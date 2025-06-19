package view;

import javax.swing.*;
import java.awt.*;

public class ViewApp extends JFrame {
    public JTextField ciudadTextField = new JTextField();
    public JButton buscarButton = new JButton("Buscar");
    public JLabel temperaturaLabel = new JLabel("Temperatura: ");
    public JLabel humedadLabel = new JLabel("Humedad: ");

    public ViewApp() {
        setTitle("Clima App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        panel.add(new JLabel("Dime la ciudad:"));
        panel.add(ciudadTextField);
        panel.add(buscarButton);
        panel.add(temperaturaLabel);
        panel.add(humedadLabel);

        add(panel);
    }
}
