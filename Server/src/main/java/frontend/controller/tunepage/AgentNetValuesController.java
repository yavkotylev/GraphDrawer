package frontend.controller.tunepage;

import model.internalmodel.net.AgentNet;

import javax.swing.*;

import java.util.Collection;

import static utils.InternalUtils.getIntegerFromString;

public class AgentNetValuesController {
    private final TunePageController tunePageController;
    private JList<AgentNet> agentNetJList;
    private JTextField thresholdTextField;
    private JTextField intervalDurationTextField;
    private JTextField distanceBetweenIntervalsTextField;

    public AgentNetValuesController(TunePageController tunePageController) {
        this.tunePageController = tunePageController;
    }

    public void setAgentNetJList(JList<AgentNet> agentNetJList) {
        this.agentNetJList = agentNetJList;
    }

    public void setThresholdTextField(JTextField thresholdTextField) {
        this.thresholdTextField = thresholdTextField;
    }

    public void setIntervalDurationTextField(JTextField intervalDurationTextField) {
        this.intervalDurationTextField = intervalDurationTextField;
    }

    public void setDistanceBetweenIntervalsTextField(JTextField distanceBetweenIntervalsTextField) {
        this.distanceBetweenIntervalsTextField = distanceBetweenIntervalsTextField;
    }

    public void updateAgentNetMethodValues() {
        AgentNet agentNet = agentNetJList.getSelectedValue();
        thresholdTextField.setText(String.valueOf(agentNet.getThreshold()));
        intervalDurationTextField.setText(String.valueOf(agentNet.getIntervalDuration()));
        distanceBetweenIntervalsTextField.setText(String.valueOf(agentNet.getDistanceBetweenIntervals()));
    }

    public void updateEventTypeListModel() {
        AgentNet agentNet = agentNetJList.getSelectedValue();
        tunePageController.updateEventTypeDefaultListModel(agentNet);
    }

    public Collection<AgentNet> getAgentNets() {
        return tunePageController.getAgentNets();
    }

    AgentNet getSelectedAgentNet() {
        return agentNetJList.getSelectedValue();
    }

    void setAgentNetListSelectedIndexZero() {
        agentNetJList.setSelectedIndex(0);
    }

    public void saveAgentNetMethodValues() {
        Integer threshold = getIntegerFromString(thresholdTextField.getText());
        if (threshold == null || threshold < 0) {
            tunePageController.showMessageDialogOnTunePage("Unexpected value \"" +
                    thresholdTextField.getText() + "\" at threshold");
            thresholdTextField.requestFocus();
            return;
        }
        Integer intervalDuration = getIntegerFromString(intervalDurationTextField.getText());
        if (intervalDuration == null || intervalDuration <= 0) {
            tunePageController.showMessageDialogOnTunePage("Unexpected value \"" +
                    intervalDurationTextField.getText() + "\" at interval duration");
            intervalDurationTextField.requestFocus();
            return;
        }
        Integer timeDistance = getIntegerFromString(distanceBetweenIntervalsTextField.getText());
        if (timeDistance == null || timeDistance <= 0) {
            tunePageController.showMessageDialogOnTunePage("Unexpected value \"" +
                    distanceBetweenIntervalsTextField.getText() +
                    "\" at time distance between intervals");
            distanceBetweenIntervalsTextField.requestFocus();
            return;
        }

        if (timeDistance > intervalDuration) {
            tunePageController.showMessageDialogOnTunePage("Distance between time intervals " +
                    "can't be bigger than interval duration!");
            distanceBetweenIntervalsTextField.requestFocus();
            return;
        }

        AgentNet agentNet = agentNetJList.getSelectedValue();
        if (agentNet != null) {
            agentNet.setThreshold(threshold);
            agentNet.setIntervalDuration(intervalDuration);
            agentNet.setDistanceBetweenIntervals(timeDistance);
            tunePageController.updateActiveNetTime();
        } else {
            tunePageController.showMessageDialogOnTunePage("agent net isn't selected");
        }

    }

    public void redrawGraphPanel() {
        tunePageController.repaintGraphPanel();
    }
}
