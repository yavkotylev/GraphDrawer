package model;

import com.google.common.collect.BiMap;
import guru.nidi.graphviz.attribute.*;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Link;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;
import model.internalmodel.net.BaseNet;
import utils.Temp;

import java.util.HashMap;
import java.util.Map;

import static guru.nidi.graphviz.model.Factory.mutGraph;
import static guru.nidi.graphviz.model.Factory.mutNode;

public class GraphBuilder {

    public MutableGraph buildGraph(BaseNet net, BiMap<String, String> idDictionary) {
        Map<String, MutableNode> placeNodes = new HashMap<>();
        net.getPlaces().keySet().forEach(placeId -> {
            MutableNode placeNode = mutNode(idDictionary.get(placeId));
            placeNode.add(Shape.CIRCLE);
            placeNodes.put(placeId, placeNode);
        });

        Map<String, MutableNode> transitionNodes = new HashMap<>();
        net.getTransitions().keySet().forEach(transitionId -> {
            MutableNode transitionNode = mutNode(idDictionary.get(transitionId));
            transitionNode.add(Shape.RECTANGLE);
            transitionNodes.put(transitionId, transitionNode);
        });

        net.getArcs().forEach((arcId, arc) -> {
            MutableNode placeNodeFrom = placeNodes.get(arc.getSourceId());
            MutableNode from = placeNodeFrom == null ? transitionNodes.get(arc.getSourceId()) : placeNodeFrom;

            MutableNode placeNodeTo = placeNodes.get(arc.getTargetId());
            MutableNode to = placeNodeTo == null ? transitionNodes.get(arc.getTargetId()) : placeNodeTo;
            if (to == null){
                System.out.println("kek");
            }
            from.addLink(Link.to(to)
                    .add(Label.of(idDictionary.get(arc.getId()))));
        });

        MutableGraph mutableGraph = mutGraph("example3").setDirected(true)
                .add(placeNodes.get(net.getStartPlaceId()))
                .graphAttrs().add(Rank.dir(Rank.RankDir.LEFT_TO_RIGHT))
                .graphAttrs().add(GraphAttr.splines(GraphAttr.SplineMode.POLYLINE));

        /*Temp.savePng(Graphviz.fromGraph(mutableGraph)
                .render(Format.PNG)
                .toImage(), net.getId());*/

        return mutableGraph;
    }
}
