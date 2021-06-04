package frontend.view.welcomepage;

import frontend.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame {
    public WelcomePage(Controller controller) {
        super("Welcome page");
        TuneButton tuneButton = new TuneButton(controller);
        JPanel panel = new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(540, 300));
        panel.add(new NetLoadPanel(controller));
        panel.add(new TraceLoadPanel(controller));
        panel.add(tuneButton);
        setContentPane(panel);
        setPreferredSize(new Dimension(540, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}
