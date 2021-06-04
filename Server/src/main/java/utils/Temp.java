package utils;

import protobuf.usernet.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Temp {

    public static void savePng(BufferedImage bufferedImage, String fileName) {
        try {
            File outPutFile = new File("/Users/yaroslav/RootDirectory/HSE/MasterOfArts/MasterThesis/Server/src/main/"
                    + fileName + ".png");
            ImageIO.write(bufferedImage, "png", outPutFile);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void saveJson() {

    }

    public static UserNet testNet() {
        UserNet.Builder builder = UserNet.newBuilder();
        builder.setId("systemNet")
                .addPlaces(placeBuilder("p1", "olympiad"))
                .addPlaces(placeBuilder("p2", "USM"))
                .addTransitions(transitionBuilder("t1", "documents"))
                .addArcs(arcBuilder("arc1", "arc1", "p1", "t1"))
                .addArcs(arcBuilder("arc2", "arc2", "p2", "t1"))
                .addArcs(arcBuilder("arc3", "arc3", "t1", "p2"))
                .addPlaces(placeBuilder("p3", "start courses"))
                .addArcs(arcBuilder("arc4", "arc4", "t1", "p3"))
                .addTransitions(transitionBuilder("t2", "choose course"))
                .addArcs(arcBuilder("arc5", "arc5", "p3", "t2"))
                .addPlaces(placeBuilder("pc1_1", "math"))
                .addPlaces(placeBuilder("pc2_1", "biology"))
                .addPlaces(placeBuilder("pc3_1", "history"))
                .addPlaces(placeBuilder("pc4_1", "chemistry"))
                .addPlaces(placeBuilder("pc5_1", "physics"))
                .addArcs(arcBuilder("arcPC1_1", "arcPC1_1", "t2", "pc1_1"))
                .addArcs(arcBuilder("arcPC2_1", "arcPC2_1", "t2", "pc2_1"))
                .addArcs(arcBuilder("arcPC3_1", "arcPC3_1", "t2", "pc3_1"))
                .addArcs(arcBuilder("arcPC4_1", "arcPC4_1", "t2", "pc4_1"))
                .addArcs(arcBuilder("arcPC5_1", "arcPC5_1", "t2", "pc5_1"))
                //course1
                .addTransitions(transitionBuilder("tpc1_1", "start course"))
                .addArcs(arcBuilder("arcPC1_2", "arcPC1_2", "pc1_1", "tpc1_1"))
                .addPlaces(placeBuilder("pc1_2", "academic programme"))
                .addArcs(arcBuilder("arcPC1_3", "arcPC1_3", "tpc1_1", "pc1_2"))
                .addTransitions(transitionBuilder("tpc1_2", "start own project"))
                .addArcs(arcBuilder("arcPC1_4", "arcPC1_4", "pc1_2", "tpc1_2"))
                .addPlaces(placeBuilder("pc1_3", "own project"))
                .addArcs(arcBuilder("arcPC1_5", "arcPC1_5", "tpc1_2", "pc1_3"))
                .addTransitions(transitionBuilder("tpc1_3", "start exams"))
                .addArcs(arcBuilder("arcPC1_6", "arcPC1_6", "pc1_3", "tpc1_3"))
                .addPlaces(placeBuilder("pc1_4", "exam week"))
                .addArcs(arcBuilder("arcPC1_7", "arcPC1_7", "tpc1_3", "pc1_4"))
                .addTokens(getToken("tn1", "student_1"))
                .setStartPlaceId("p1")
                .addAgentNets(AgentNet.newBuilder()
                        .setName("student_1")
                        .setId("student_1")
                        .addPlaces(placeBuilder("st1_p1", "start project"))
                        .addTransitions(transitionBuilder("st1_t1", "start project"))
                        .addArcs(arcBuilder("st1_arc1", "st1_arc1", "st1_p1", "st1_t1"))
                        .addPlaces(placeBuilder("st1_p2", "start project"))
                        .addArcs(arcBuilder("st1_arc2", "st1_arc2", "st1_t1", "st1_p2"))
                        .setStartPlaceId("st1_p1")
                        .addTokens(Token.newBuilder()
                                .setId("st1_tn1")
                                .setName("st1_tn1"))
                        .addInitialMarking(InitialMarking.newBuilder()
                                .setPlaceId("st1_p1")
                                .setTokenId("st1_tn1"))
                );
        addInitialMarking(builder);

        return builder.build();
    }

    static Place placeBuilder(String id, String name) {
        return Place.newBuilder()
                .setId(id)
                .setName(name == null ? "" : name)
                .build();
    }

    static Transition transitionBuilder(String id, String name) {
        return Transition.newBuilder()
                .setId(id)
                .setName(name == null ? "" : name)
                .build();
    }

    static Arc arcBuilder(String id, String name, String fromId, String toId) {
        return Arc.newBuilder()
                .setId(id)
                .setName(name)
                .setSourceId(fromId)
                .setTargetId(toId)
                .build();
    }

    private static void addInitialMarking(UserNet.Builder builder) {
        builder.addInitialMarking(getInitialMarking("p1", "tn1"));
    }

    private static InitialMarking.Builder getInitialMarking(String placeId, String tokenId) {
        return InitialMarking.newBuilder()
                .setPlaceId(placeId)
                .setTokenId(tokenId);
    }

    private static Token.Builder getToken(String tokenId, String agentNet) {
        return Token.newBuilder()
                .setId(tokenId)
                .setName("tokenName " + tokenId)
                .setAgentNet(agentNet);
    }
}
