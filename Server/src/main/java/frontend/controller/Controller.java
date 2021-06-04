package frontend.controller;

import frontend.controller.tunepage.TunePageController;
import frontend.model.ModelKeeper;
import frontend.view.welcomepage.WelcomePage;
import model.internalmodel.RunBuilder;
import model.internalmodel.interval.ActiveNetTime;
import model.internalmodel.net.AgentNet;
import model.internalmodel.trace.Action;
import model.internalmodel.trace.EventType;
import protobuf.usertrace.UserTrace;
import protobuf.usernet.UserNet;
import sender.RunSender;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Collection;
import java.util.List;

public class Controller {
    private final RunSender runSender = new RunSender();
    private final ModelKeeper modelKeeper = new ModelKeeper();
    private final WelcomePage welcomePage = new WelcomePage(this);

    public void updateTrace(UserTrace trace) {
        modelKeeper.setLoadedTrace(trace);
    }

    public void updateUserNet(UserNet userNet) {
        modelKeeper.setLoadedUserNet(userNet);
    }

    public void startApp() {
        welcomePage.setVisible(true);
    }

    public void startTunePage() {
        if (modelKeeper.hasTraceAndNet()) {
            modelKeeper.setTrace();
            modelKeeper.setSystemNet();
            modelKeeper.setActiveNetTimeMap();
            welcomePage.setVisible(false);
            new TunePageController(this).openPage();
        } else if (!modelKeeper.hasTrace()) {
            JOptionPane.showMessageDialog(welcomePage, "Please load trace!");
        } else if (!modelKeeper.hasNet()) {
            JOptionPane.showMessageDialog(welcomePage, "Please load net!");
        }

    }

    public void openWelcomePage() {
        modelKeeper.clearUserNet();
        modelKeeper.clearUserTrace();
        modelKeeper.clearSystemNet();
        modelKeeper.clearTrace();
        modelKeeper.clearActiveNetTimeMap();
        welcomePage.setVisible(true);
    }

    public void showMessageDialogOnWelcomePage(String text) {
        JOptionPane.showMessageDialog(welcomePage, text);
    }

    public int openFileChooserDialogWelcomePage(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(welcomePage);
    }

    public Collection<AgentNet> getAgentNets() {
        return modelKeeper.getAgentNets();
    }

    public Collection<EventType> getSelectedAgentNetEventTypes(AgentNet agentNet) {
        return modelKeeper.getAgentEventTypes(agentNet);
    }

    public long getEndTime() {
        return modelKeeper.getTrace().getEndTime();
    }

    public List<Action> getSelectedAgentNetActions(AgentNet agentNet) {
        return modelKeeper.getAgentNetActions(agentNet);
    }

    public ActiveNetTime getAgentNetTime(AgentNet agentNet) {
        return modelKeeper.getAgentNetTime(agentNet);
    }

    public void updateActiveNetTime(AgentNet agentNet) {
        modelKeeper.updateActiveTime(agentNet);
    }

    public void startVisualization() {
        RunBuilder runBuilder = new RunBuilder(modelKeeper.getSystemNet(),
                modelKeeper.getTrace(),
                modelKeeper.getActiveNetTimeMap());
        runSender.sendRun(runBuilder.buildRun());
        try {
            Desktop.getDesktop()
                    .open(new File("processDrawer.app"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
