package model.internalmodel.net;

import protobuf.run.Color;

public class Token extends BaseElement {
    private String agentNetId;
    private Color color;

    public Token(String id) {
        super(id);
    }

    public String getAgentNetId() {
        return agentNetId;
    }

    public void setAgentNetId(String agentNetId) {
        this.agentNetId = agentNetId;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
