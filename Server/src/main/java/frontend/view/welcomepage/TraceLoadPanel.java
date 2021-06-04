package frontend.view.welcomepage;

import com.google.protobuf.util.JsonFormat;
import frontend.controller.Controller;
import protobuf.usertrace.UserTrace;
import utils.TempTrace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class TraceLoadPanel extends JPanel {
    private final ImageIcon okIcon = new ImageIcon("E:\\new.png");
    private final ImageIcon warningIcon = new ImageIcon("E:\\new.png");
    private final Controller controller;
    private final JLabel labelStatus;

    public TraceLoadPanel(Controller controller) {
        super(new FlowLayout());
        this.controller = controller;
        setPreferredSize(new Dimension(540, 80));
        JButton loadTraceButton = new JButton("Load trace");
        loadTraceButton.addActionListener(this::buttonClicked);
        JLabel labelStatus = new JLabel("Please load trace");
        labelStatus.setIcon(warningIcon);
        this.labelStatus = labelStatus;
        add(loadTraceButton);
        add(labelStatus);
    }

    public void buttonClicked(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int option = controller.openFileChooserDialogWelcomePage(fileChooser);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            UserTrace userTrace = loadTrace(file);
            //TempTrace.testTrace();
            if (userTrace != null) {
                labelStatus.setText("Trace loaded");
                labelStatus.setIcon(okIcon);
                controller.updateTrace(userTrace);
            } else {
                labelStatus.setText("Please load trace");
                labelStatus.setIcon(warningIcon);
            }
        }
    }

    private UserTrace loadTrace(File traceFile) {
        try (Reader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(traceFile)))) {
            try {
                UserTrace.Builder builder = UserTrace.newBuilder();
                JsonFormat.parser().ignoringUnknownFields().merge(reader, builder);
                return builder.build();
            } catch (Exception e) {
                controller.showMessageDialogOnWelcomePage("Can't read trace correctly: \n" + e);
            }
        } catch (IOException e) {
            controller.showMessageDialogOnWelcomePage("Can't open file: \n" + e);
        }
        return null;
    }
}
