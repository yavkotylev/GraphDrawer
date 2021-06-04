package frontend.controller.tunepage;

import model.internalmodel.trace.EventType;
import utils.InternalUtils;

import javax.swing.*;
import java.util.Collection;

public class EventTypeTuneController {
    private final TunePageController tunePageController;
    private JList<EventType> eventTypeJList;
    private DefaultListModel<EventType> eventTypeDefaultListModel;
    private JTextField eventImportanceTextField;

    public EventTypeTuneController(TunePageController tunePageController) {
        this.tunePageController = tunePageController;
    }

    public void setEventTypeJList(JList<EventType> eventTypeJList) {
        this.eventTypeJList = eventTypeJList;
    }

    public void setEventTypeDefaultListModel(DefaultListModel<EventType> eventTypeDefaultListModel) {
        this.eventTypeDefaultListModel = eventTypeDefaultListModel;
    }

    public void setEventImportanceTextField(JTextField eventImportanceTextField) {
        this.eventImportanceTextField = eventImportanceTextField;
    }

    public void updateTextFieldEventTypeValues() {
        EventType eventType = eventTypeJList.getSelectedValue();
        if (eventType != null) {
            eventImportanceTextField.setText(
                    String.valueOf(eventType.getImportance()));
            tunePageController.repaintGraphPanel();
        }
    }

    public void saveEventTypeValues() {
        Integer importanceValue = InternalUtils.getIntegerFromString(eventImportanceTextField.getText());
        if (importanceValue == null) {
            tunePageController.showMessageDialogOnTunePage("Unexpected value \"" +
                    eventImportanceTextField.getText() + "\" for event importance");
            eventImportanceTextField.requestFocus();
            return;
        }
        EventType eventType = eventTypeJList.getSelectedValue();
        if (eventType != null) {
            eventType.setImportance(importanceValue);
            tunePageController.updateActiveNetTime();
        } else {
            tunePageController.showMessageDialogOnTunePage("Event type isn't selected");
        }
    }

    void updateEventTypeList(Collection<EventType> eventTypes) {
        eventTypeDefaultListModel.removeAllElements();
        if (eventTypes != null && !eventTypes.isEmpty()) {
            eventTypes.forEach(eventTypeDefaultListModel::addElement);
            eventTypeJList.setSelectedIndex(0);
        }
        eventTypeJList.updateUI();
    }

    EventType getSelectedEventType() {
        return eventTypeJList.getSelectedValue();
    }
}
