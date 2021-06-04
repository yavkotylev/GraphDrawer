package frontend.view.welcomepage;

import com.google.protobuf.util.JsonFormat;
import frontend.controller.Controller;
import protobuf.usernet.UserNet;
import utils.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class NetLoadPanel extends JPanel {

    private final ImageIcon okIcon = new ImageIcon("E:\\new.png");
    private final ImageIcon warningIcon = new ImageIcon("");
    private final Controller controller;
    private final JLabel labelStatus;

    public NetLoadPanel(Controller controller) {
        super(new FlowLayout());
        this.controller = controller;
        setPreferredSize(new Dimension(540, 80));
        JButton loadNetButton = new JButton("Load net");
        loadNetButton.addActionListener(this::buttonClicked);
        JLabel labelStatus = new JLabel("Please load net");
        labelStatus.setIcon(warningIcon);
        this.labelStatus = labelStatus;
        add(loadNetButton);
        add(labelStatus);
    }

    private void buttonClicked(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int option = controller.openFileChooserDialogWelcomePage(fileChooser);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            UserNet loadedNet = loadNet(file);
            //Temp.testNet();
            if (loadedNet != null) {
                labelStatus.setText("Net loaded");
                labelStatus.setIcon(okIcon);
                controller.updateUserNet(loadedNet);
            } else {
                labelStatus.setText("Please load net");
                labelStatus.setIcon(warningIcon);
            }
        }
    }


    private UserNet loadNet(File netFile) {
        try (Reader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(netFile)))) {
            UserNet.Builder builder = UserNet.newBuilder();
            try {
                JsonFormat.parser().ignoringUnknownFields().merge(reader, builder);
                return builder.build();
            } catch (Exception e) {
                controller.showMessageDialogOnWelcomePage("Can't build net: \n" + e);
            }
        } catch (IOException e) {
            controller.showMessageDialogOnWelcomePage("Can't open file: \n" + e);
        }
        return null;
    }
}
