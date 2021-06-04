package frontend.controller.tunepage;

import frontend.controller.Controller;
import frontend.view.tunepage.TunePage;
import model.internalmodel.interval.ActiveNetTime;
import model.internalmodel.net.AgentNet;
import model.internalmodel.trace.Action;
import model.internalmodel.trace.EventType;

import javax.swing.*;
import java.util.Collection;
import java.util.List;

public class TunePageController {
    private final TunePage tunePage;
    private final Controller mainController;
    private final AgentNetValuesController agentNetValuesController;
    private final EventTypeTuneController eventTypeTuneController;

    public TunePageController(Controller mainController) {
        this.mainController = mainController;
        this.agentNetValuesController = new AgentNetValuesController(this);
        this.eventTypeTuneController = new EventTypeTuneController(this);
        this.tunePage = new TunePage(this);
    }

    public AgentNetValuesController getAgentNetValuesController() {
        return agentNetValuesController;
    }

    public EventTypeTuneController getEventTypeTuneController() {
        return eventTypeTuneController;
    }

    public void openPage() {
        tunePage.setVisible(true);
        agentNetValuesController.setAgentNetListSelectedIndexZero();
    }

    public void closePage() {
        mainController.openWelcomePage();
        tunePage.setVisible(false);
    }

    public void showMessageDialogOnTunePage(String text) {
        JOptionPane.showMessageDialog(tunePage, text);
    }

    public Collection<AgentNet> getAgentNets() {
        return mainController.getAgentNets();
    }

    public Collection<EventType> getSelectedAgentNetEventTypes() {
        AgentNet agentNet = agentNetValuesController.getSelectedAgentNet();
        return mainController.getSelectedAgentNetEventTypes(agentNet);
    }

    public long getEndTime() {
        return mainController.getEndTime();
    }

    public List<Action> getSelectedNetActions() {
        AgentNet selectedAgentNet = agentNetValuesController.getSelectedAgentNet();
        return mainController.getSelectedAgentNetActions(selectedAgentNet);
    }

    void updateActiveNetTime() {
        AgentNet selectedAgentNet = agentNetValuesController.getSelectedAgentNet();
        mainController.updateActiveNetTime(selectedAgentNet);
    }

    public ActiveNetTime getAgentNetTime() {
        AgentNet selectedAgentNet = agentNetValuesController.getSelectedAgentNet();
        return mainController.getAgentNetTime(selectedAgentNet);
    }

    public void repaintGraphPanel() {
        tunePage.repaintGraphPanel();
    }

    public void updateEventTypeDefaultListModel(AgentNet agentNet) {
        eventTypeTuneController.updateEventTypeList(
                mainController.getSelectedAgentNetEventTypes(agentNet));
    }

    public void saveAgentNetMethodValues() {
        agentNetValuesController.saveAgentNetMethodValues();
    }

    public void saveEventTypeValues() {
        eventTypeTuneController.saveEventTypeValues();
    }

    public void startVisualization() {
        mainController.startVisualization();
    }

    public EventType getSelectedEventType() {
        return eventTypeTuneController.getSelectedEventType();
    }
}
