package frontend.view.tunepage;

import model.internalmodel.trace.EventType;

import javax.swing.*;
import java.awt.*;

public class EventNameColorCellRenderer extends DefaultListCellRenderer {
    private final int imageDiameter = 7;

    @Override
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean selected,
            boolean expanded) {

        EventType clickedEventType = (EventType) value;

        JLabel label = (JLabel) super.getListCellRendererComponent(
                list, value, index, selected, expanded);
        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setIcon(new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(clickedEventType.getColor());
                g2d.fillOval(x, y, imageDiameter, imageDiameter);
            }

            @Override
            public int getIconWidth() {
                return imageDiameter;
            }

            @Override
            public int getIconHeight() {
                return imageDiameter;
            }
        });
        label.setText(clickedEventType.getName());
        return label;
    }

}
