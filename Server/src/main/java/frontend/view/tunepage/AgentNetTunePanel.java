package frontend.view.tunepage;

import frontend.controller.tunepage.AgentNetValuesController;
import model.internalmodel.net.AgentNet;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.util.Collection;

public class AgentNetTunePanel extends JPanel {
    private final AgentNetValuesController controller;

    public AgentNetTunePanel(AgentNetValuesController controller) {
        super(new BorderLayout());
        this.controller = controller;
        setPreferredSize(new Dimension(540, 350));
        add(getAgentNetNamesScrollPanel(), BorderLayout.WEST);
        add(getAgentNetMethodValueTunePanel(), BorderLayout.EAST);
    }

    JPanel getAgentNetNamesScrollPanel() {
        JPanel scrollPanel = new JPanel(new BorderLayout());
        scrollPanel.setPreferredSize(new Dimension(230, 350));

        JPanel labelAgentScrollPanel = new JPanel(new BorderLayout());
        labelAgentScrollPanel.setPreferredSize(new Dimension(230, 50));
        JLabel labelAgentScrollLabel = new JLabel("Agent net list:");
        labelAgentScrollLabel.setFont(new Font(labelAgentScrollLabel.getFont().getName(), Font.BOLD, 14));
        labelAgentScrollPanel.add(labelAgentScrollLabel, BorderLayout.WEST);
        scrollPanel.add(labelAgentScrollPanel, BorderLayout.NORTH);

        scrollPanel.add(getAgentNetNamesScrollPane(), BorderLayout.SOUTH);
        return scrollPanel;
    }

    JScrollPane getAgentNetNamesScrollPane() {
        Collection<AgentNet> data = controller.getAgentNets();
        DefaultListModel<AgentNet> defaultListModel = new DefaultListModel<>();
        data.forEach(defaultListModel::addElement);
        JList<AgentNet> agentNetJList = new JList<>(defaultListModel);
        agentNetJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        agentNetJList.setLayoutOrientation(JList.VERTICAL);
        controller.setAgentNetJList(agentNetJList);
        JScrollPane agentNetScrollPane = new JScrollPane(agentNetJList,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        agentNetScrollPane.setPreferredSize(new Dimension(100, 300));
        agentNetScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        agentNetJList.addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                controller.updateEventTypeListModel();
                controller.updateAgentNetMethodValues();
                controller.redrawGraphPanel();
            }
        });
        return agentNetScrollPane;
    }


    JPanel getAgentNetMethodValueTunePanel() {
        JPanel labelAgentValesPanel = new JPanel(new BorderLayout());
        labelAgentValesPanel.setPreferredSize(new Dimension(270, 50));
        JLabel labelMethodValueLabel = new JLabel("Method value for agent net:");
        labelMethodValueLabel.setFont(new Font(labelMethodValueLabel.getFont().getName(), Font.BOLD, 14));
        labelAgentValesPanel.add(labelMethodValueLabel, BorderLayout.WEST);


        Dimension methodValueTunePanelDimension = new Dimension(270, 40);
        JPanel thresholdPanel = new JPanel(new BorderLayout());
        thresholdPanel.setPreferredSize(methodValueTunePanelDimension);
        JLabel thresholdLabel = new JLabel("Threshold of visualization");
        JTextField thresholdTextField = new JTextField(5);
        thresholdPanel.add(thresholdLabel, BorderLayout.WEST);
        thresholdPanel.add(thresholdTextField, BorderLayout.EAST);
        controller.setThresholdTextField(thresholdTextField);

        JPanel timeIntervalPanel = new JPanel(new BorderLayout());
        timeIntervalPanel.setPreferredSize(methodValueTunePanelDimension);
        JLabel timeIntervalLabel = new JLabel("Time interval");
        JTextField timeIntervalTextField = new JTextField(5);
        timeIntervalPanel.add(timeIntervalLabel, BorderLayout.WEST);
        timeIntervalPanel.add(timeIntervalTextField, BorderLayout.EAST);
        controller.setIntervalDurationTextField(timeIntervalTextField);

        JPanel timeIntervalDistancePanel = new JPanel(new BorderLayout());
        timeIntervalDistancePanel.setPreferredSize(methodValueTunePanelDimension);
        JLabel timeIntervalDistanceLabel = new JLabel("Time distance between intervals");
        JTextField timeIntervalDistanceTextField = new JTextField(5);
        timeIntervalDistancePanel.add(timeIntervalDistanceLabel, BorderLayout.WEST);
        timeIntervalDistancePanel.add(timeIntervalDistanceTextField, BorderLayout.EAST);
        controller.setDistanceBetweenIntervalsTextField(timeIntervalDistanceTextField);

        JPanel methodValuePanel = new JPanel(new FlowLayout());
        methodValuePanel.setPreferredSize(new Dimension(270, 350));
        methodValuePanel.add(labelAgentValesPanel);
        methodValuePanel.add(thresholdPanel);
        methodValuePanel.add(timeIntervalPanel);
        methodValuePanel.add(timeIntervalDistancePanel);

        return methodValuePanel;
    }
}
