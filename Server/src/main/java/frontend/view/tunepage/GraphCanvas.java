package frontend.view.tunepage;

import frontend.controller.tunepage.TunePageController;
import model.internalmodel.interval.ActiveNetTime;
import model.internalmodel.net.AgentNet;
import model.internalmodel.trace.Action;
import model.internalmodel.trace.EventType;
import utils.InternalUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.List;

public class GraphCanvas extends JPanel {
    private final double eventHeight = 80d;
    private final Color activeIntervalColor = new Color(0.35f, 0.69f, 0.047f, 0.5f);
    private final Color intervalColor = new Color(0, 0.46f, 1, 0.6f);
    private final int eventDiameter = 8;
    private final int eventRadius = eventDiameter / 2;
    private final int selectedEventDiameter = 12;
    private final int selectedEventRadius = selectedEventDiameter / 2;


    private final TunePageController controller;
    private final int startLineX = 50;
    private final int lineY = 150;
    private final int endLineX = 1140;
    private final int lineLength = endLineX - startLineX;

    public GraphCanvas(TunePageController tunePageController) {
        this.controller = tunePageController;
        setPreferredSize(new Dimension(1190, 300));
        setBackground(Color.white);
        setDoubleBuffered(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        long endTime = controller.getEndTime();
        double pixelInSecond = ((double) lineLength / (double) endTime);
        drawIntervals(g2, controller.getAgentNetTime().getAgentNet(), pixelInSecond, endTime);
        drawCoordinateLine(g2, endTime);
        drawActiveIntervals(g2, pixelInSecond);
        drawEvents(g2, controller.getSelectedNetActions(), controller.getSelectedEventType(), pixelInSecond);
    }


    private void drawCoordinateLine(Graphics2D g2, long endTime) {
        g2.setColor(Color.black);
        g2.drawLine(startLineX, lineY, endLineX, lineY);
        g2.drawLine(startLineX, lineY - 10, startLineX, lineY + 10);
        g2.drawLine(endLineX, lineY - 10, endLineX, lineY + 10);
        g2.drawString("0", startLineX - 5, lineY + 30);
        g2.drawString(String.valueOf(endTime), endLineX - 5, lineY + 30);
    }

    private void drawActiveIntervals(Graphics2D g, double pixelInSecond) {
        ActiveNetTime activeNetTime = controller.getAgentNetTime();
        g.setColor(activeIntervalColor);
        activeNetTime.getActiveIntervals().forEach(interval -> {
            double x = interval.getStartTime() * pixelInSecond + startLineX;
            double pixelIntervalDuration =
                    (interval.getEndTime() - interval.getStartTime()) * pixelInSecond;
            g.fill(new Arc2D.Double(x, lineY - eventHeight / 2, pixelIntervalDuration,
                    eventHeight, 0, 180, Arc2D.OPEN));
        });
    }

    private void drawIntervals(Graphics2D g, AgentNet agentNet, double pixelInSecond, long endTime) {
        g.setColor(intervalColor);
        int pixelIntervalDuration = (int) (agentNet.getIntervalDuration() * pixelInSecond);
        for (int i = 0; i < endTime; i += agentNet.getDistanceBetweenIntervals()) {
            double x = i * pixelInSecond + startLineX;
            g.fill(new Arc2D.Double(x, lineY - eventHeight / 2, pixelIntervalDuration,
                    eventHeight, 180, 180, Arc2D.OPEN));
        }

        //hack
        g.setColor(Color.white);
        g.fillRect(endLineX, lineY, (int) eventHeight, (int) eventHeight);

    }

    private void drawEvents(Graphics2D g2, List<Action> actions, EventType selectedEventType, double pixelInSecond) {
        InternalUtils.safeStream(actions).forEach(action -> {
            if (action.getEventType() != selectedEventType) {
                g2.setColor(action.getEventType().getColor());
                g2.fillOval((int) (pixelInSecond * action.getTime()) + startLineX - eventRadius,
                        lineY - eventRadius, eventDiameter, eventDiameter);
            }
        });
        InternalUtils.safeStream(actions).forEach(action -> {
            EventType actionEventType = action.getEventType();
            if (selectedEventType == actionEventType) {
                g2.setColor(Color.black);
                g2.fillOval((int) (pixelInSecond * action.getTime()) + startLineX - selectedEventRadius,
                        lineY - selectedEventRadius, selectedEventDiameter, selectedEventDiameter);
                g2.setColor(actionEventType.getColor());
                g2.fillOval((int) (pixelInSecond * action.getTime()) + startLineX - eventRadius,
                        lineY - eventRadius, eventDiameter, eventDiameter);
            }
        });
    }

}
