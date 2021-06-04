package frontend.view.welcomepage;

import frontend.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TuneButton extends JButton {
    private final Controller controller;

    public TuneButton(Controller controller) {
        super("tune model");
        this.controller = controller;
        this.setBounds(200, 200, 80, 30);
        this.setBackground(Color.green);
        this.addActionListener(this::buttonClicked);
    }

    private void buttonClicked(ActionEvent e) {
        controller.startTunePage();
    }
}
