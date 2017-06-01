package it.polimi.ingsw.gamelogic.board;

import it.polimi.ingsw.gamelogic.enums.PawnColor;
import it.polimi.ingsw.gamelogic.player.PlayerDetails;

/**
 * TODO: JavaDoc
 */
public class PlayerPawn {
    private PlayerDetails playerDetails;
    private PawnColor pawnColor;

    public PlayerPawn() {
        playerDetails = new PlayerDetails();
        pawnColor = PawnColor.UNCOLORED;
    }

    public PlayerPawn(PlayerDetails playerDetails, PawnColor pawnColor) {
        this.playerDetails = playerDetails;
        this.pawnColor = pawnColor;
    }

    public boolean isEmpty() {
        /*
        TODO
         */
        return true;
    }

    public PlayerDetails getPlayerDetails() {
        return playerDetails;
    }

    public void setPlayerDetails(PlayerDetails playerDetails) {
        this.playerDetails = playerDetails;
    }

    public PawnColor getPawnColor() {
        return pawnColor;
    }

    public void setPawnColor(PawnColor pawnColor) {
        this.pawnColor = pawnColor;
    }
}