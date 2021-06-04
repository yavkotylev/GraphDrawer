package frontend.view.tunepage;

import frontend.controller.tunepage.TunePageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.stream.Stream;

public class TunePage extends JFrame {
    private final TunePageController controller;
    private final GraphCanvas graphCanvas;

    public TunePage(TunePageController controller) {
        super("Tune net variables");
        this.controller = controller;
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                controller.closePage();
            }
        });
        setPreferredSize(new Dimension(1200, 800));
        JPanel mainPanel = new JPanel(new FlowLayout());
        mainPanel.setPreferredSize(new Dimension(1200, 750));
        mainPanel.add(buildTunePanel());
        JPanel graphPanel = buildGraphDrawPanel();
        this.graphCanvas = Stream.of(graphPanel.getComponents())
                .filter(GraphCanvas.class::isInstance)
                .map(GraphCanvas.class::cast)
                .findAny()
                .orElseThrow(() -> new RuntimeException("can't find canvas"));
        mainPanel.add(graphPanel);
        setContentPane(mainPanel);
        pack();
    }

    private JPanel buildTunePanel() {
        JPanel tunePanel = new JPanel(new BorderLayout());
        tunePanel.setBorder(BorderFactory.createEtchedBorder(Color.darkGray, Color.gray));
        tunePanel.setPreferredSize(new Dimension(1190, 400));

        JPanel valuesTunePanel = new JPanel(new BorderLayout());
        valuesTunePanel.setPreferredSize(new Dimension(1190, 350));
        valuesTunePanel.add(new AgentNetTunePanel(controller.getAgentNetValuesController()), BorderLayout.WEST);
        valuesTunePanel.add(new EventTypeTunePanel(controller.getEventTypeTuneController()), BorderLayout.EAST);
        tunePanel.add(valuesTunePanel, BorderLayout.NORTH);

        JPanel buttonSavePanel = new JPanel(new BorderLayout());
        buttonSavePanel.setPreferredSize(new Dimension(1190, 50));
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener((ActionEvent e) -> {
            controller.saveAgentNetMethodValues();
            controller.saveEventTypeValues();
            controller.repaintGraphPanel();
        });
        buttonSavePanel.add(saveButton, BorderLayout.EAST);
        tunePanel.add(buttonSavePanel, BorderLayout.SOUTH);
        return tunePanel;
    }

    private JPanel buildGraphDrawPanel() {
        JPanel graphDrawPanel = new JPanel();
        graphDrawPanel.setBackground(Color.white);
        graphDrawPanel.setLayout(new BoxLayout(graphDrawPanel, BoxLayout.Y_AXIS));
        graphDrawPanel.setBorder(BorderFactory.createEtchedBorder(Color.darkGray, Color.gray));
        graphDrawPanel.setSize(new Dimension(1190, 340));
        GraphCanvas graphCanvas = new GraphCanvas(controller);
        graphDrawPanel.add(graphCanvas);
        JButton visualizationButton = new JButton("Start visualization");
        visualizationButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        visualizationButton.addActionListener((ActionEvent e) -> controller.startVisualization());
        graphDrawPanel.add(visualizationButton);
        return graphDrawPanel;
    }

    public void repaintGraphPanel() {
        this.graphCanvas.repaint();
    }
}
