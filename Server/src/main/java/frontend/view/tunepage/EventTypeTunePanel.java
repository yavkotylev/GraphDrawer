package frontend.view.tunepage;

import frontend.controller.tunepage.EventTypeTuneController;
import model.internalmodel.trace.EventType;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;

public class EventTypeTunePanel extends JPanel {
    private final EventTypeTuneController controller;
    private final DefaultListModel<EventType> eventTypeDefaultListModel = new DefaultListModel<>();
    private final JList<EventType> eventTypeJList = new JList<>(eventTypeDefaultListModel);

    public EventTypeTunePanel(EventTypeTuneController eventTypeTuneController) {
        super(new BorderLayout());
        this.controller = eventTypeTuneController;
        this.controller.setEventTypeDefaultListModel(eventTypeDefaultListModel);
        this.controller.setEventTypeJList(eventTypeJList);
        setPreferredSize(new Dimension(540, 350));
        add(getEvenTypeListPanel(), BorderLayout.WEST);
        add(getEventValuesTunePanel(), BorderLayout.EAST);
        eventTypeJList.setCellRenderer(new EventNameColorCellRenderer());
    }

    private JPanel getEvenTypeListPanel() {
        JPanel eventListPanel = new JPanel(new BorderLayout());
        eventListPanel.setPreferredSize(new Dimension(270, 350));

        JPanel eventTypeListLabelPanel = new JPanel(new BorderLayout());
        eventTypeListLabelPanel.setPreferredSize(new Dimension(270, 50));
        JLabel eventTypeListLabel = new JLabel("Event types of the trace:");
        eventTypeListLabel.setFont(new Font(eventTypeListLabel.getFont().getName(), Font.BOLD, 14));
        eventTypeListLabelPanel.add(eventTypeListLabel, BorderLayout.WEST);
        eventListPanel.add(eventTypeListLabelPanel, BorderLayout.NORTH);

        eventListPanel.add(getEvenTypeJScrollPane(), BorderLayout.SOUTH);
        return eventListPanel;
    }

    private JScrollPane getEvenTypeJScrollPane() {
        eventTypeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eventTypeJList.setLayoutOrientation(JList.VERTICAL);
        controller.setEventTypeJList(eventTypeJList);
        JScrollPane eventTypeScrollPane = new JScrollPane(eventTypeJList,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        eventTypeScrollPane.setPreferredSize(new Dimension(270, 300));
        eventTypeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        eventTypeJList.addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                controller.updateTextFieldEventTypeValues();
            }
        });
        return eventTypeScrollPane;
    }

    private JPanel getEventValuesTunePanel() {
        JPanel eventValuesTunePanel = new JPanel(new BorderLayout());
        eventValuesTunePanel.setPreferredSize(new Dimension(270, 350));
        JPanel firstDummyPanel = new JPanel(new BorderLayout());
        firstDummyPanel.setPreferredSize(new Dimension(270, 175));
        firstDummyPanel.add(getEventImportancePanel(), BorderLayout.SOUTH);

        JPanel secondDummyPanel = new JPanel(new BorderLayout());
        secondDummyPanel.setPreferredSize(new Dimension(270, 175));
        eventValuesTunePanel.add(firstDummyPanel, BorderLayout.NORTH);
        eventValuesTunePanel.add(secondDummyPanel, BorderLayout.SOUTH);
        return eventValuesTunePanel;
    }

    private JPanel getEventImportancePanel() {
        JPanel eventImportancePanel = new JPanel(new FlowLayout());
        eventImportancePanel.setPreferredSize(new Dimension(270, 40));
        JLabel importanceLabel = new JLabel("Event importance");
        eventImportancePanel.add(importanceLabel, BorderLayout.WEST);
        JTextField importanceTextField = new JTextField(3);
        eventImportancePanel.add(importanceTextField, BorderLayout.EAST);
        controller.setEventImportanceTextField(importanceTextField);
        return eventImportancePanel;
    }
}
