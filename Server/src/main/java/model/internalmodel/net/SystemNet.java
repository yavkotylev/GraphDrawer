package model.internalmodel.net;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemNet extends BaseNet {

    public SystemNet(String id) {
        super(id);
    }

    private final Map<String, AgentNet> agentNets = new HashMap<>();

    public AgentNet getAgentNetById(String agentNetId) {
        return agentNets.get(agentNetId);
    }

    public void addAgentNet(AgentNet agentNet) {
        agentNets.put(agentNet.getId(), agentNet);
    }

    public void addAllAgentNets(List<AgentNet> agentNetList) {
        agentNetList.forEach(agentNet -> agentNets.put(agentNet.getId(), agentNet));
    }

    public Collection<AgentNet> getAgentNets() {
        return agentNets.values();
    }
}
