package it.polimi.ingsw.server.gamelogic.basics;

import java.util.Objects;

/**
 * Class that defines the categories of points of the game
 */
public class Points {
    private int victory;
    private int military;
    private int faith;

    /**
     * Constructor that sets all the kind of points as default (0)
     */
    public Points() {
        victory = 0;
        military = 0;
        faith = 0;
    }

    /**
     * Constructor with all kind of points
     * @param victory victory points to set
     * @param military military points to set
     * @param faith faith points to set
     */
    public Points(int victory, int military, int faith) {
        this.victory = victory;
        this.military = military;
        this.faith = faith;
    }

    @Override
    public String toString() {
        return "Points{" +
                "victory=" + victory +
                ", military=" + military +
                ", faith=" + faith +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Points points = (Points) o;
        return getVictory() == points.getVictory() &&
                getMilitary() == points.getMilitary() &&
                getFaith() == points.getFaith();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVictory(), getMilitary(), getFaith());
    }

    /**
     * Add other Points to this instance
     * @param pointsToAdd added Points
     */
    public void add(Points pointsToAdd) {
        victory += pointsToAdd.getVictory();
        military += pointsToAdd.getMilitary();
        faith += pointsToAdd.getFaith();
    }

    /**
     * Subtract other Points to this instance
     * @param pointsToSubtract subtracted Points
     */
    public void subtract(Points pointsToSubtract) {
        victory -= pointsToSubtract.getVictory();
        military -= pointsToSubtract.getMilitary();
        faith -= pointsToSubtract.getFaith();
    }

    /**
     * Check if Points passed is major than this
     * @param pointsToConfront Points to confront
     * @return true if Points to confront is major or equal than this
     */
    public boolean isLessThan(Points pointsToConfront) {
        return victory <= pointsToConfront.getVictory() &&
                military <= pointsToConfront.getMilitary() &&
                faith <= pointsToConfront.getFaith();
    }

    /**
     * Check if all attributes are 0
     * @return true if all attributes are 0
     */
    public boolean isEmpty(){
        return victory == 0 &&
                military == 0 &&
                faith == 0;
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public int getMilitary() {
        return military;
    }

    public void setMilitary(int military) {
        this.military = military;
    }

    public int getFaith() {
        return faith;
    }

    public void setFaith(int faith) {
        this.faith = faith;
    }
}
