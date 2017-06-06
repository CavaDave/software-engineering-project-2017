package it.polimi.ingsw.gamelogic.actions.description;

import it.polimi.ingsw.gamelogic.enums.ActionType;
import it.polimi.ingsw.gamelogic.enums.BoardIdentifier;

/**
 * Class representing the basic information of an action
 */
public class BasicAction {
    private ActionType actionType;
    private BoardIdentifier boardIdentifier;
    private int actionValue;

    public BasicAction(ActionType actionType, BoardIdentifier boardIdentifier, int actionValue) {
        this.actionType = actionType;
        this.boardIdentifier = boardIdentifier;
        this.actionValue = actionValue;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public BoardIdentifier getBoardIdentifier() {
        return boardIdentifier;
    }

    public void setBoardIdentifier(BoardIdentifier boardIdentifier) {
        this.boardIdentifier = boardIdentifier;
    }

    public int getActionValue() {
        return actionValue;
    }

    public void setActionValue(int actionValue) {
        this.actionValue = actionValue;
    }

    public BasicAction() {
    }
}
