package model.internalmodel.trace;


public class TokenMove {
    private final String tokenId;
    private final String placeId;

    public TokenMove(String tokenId, String placeId) {
        this.tokenId = tokenId;
        this.placeId = placeId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public String getPlaceId() {
        return placeId;
    }
}