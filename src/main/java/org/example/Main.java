package org.example;

import view.ViewApp;

import javax.swing.*;

import controller.ControllerApp;
import model.ModelApp;
import view.ViewApp;

public class Main {
    public static void main(String[] args) {
        ModelApp model = new ModelApp();
        ViewApp view = new ViewApp();
        new ControllerApp(model, view);
        view.setVisible(true);
    }
}
