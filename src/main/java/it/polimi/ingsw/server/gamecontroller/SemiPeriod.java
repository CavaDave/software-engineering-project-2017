package it.polimi.ingsw.server.gamecontroller;

import it.polimi.ingsw.server.gamelogic.board.Board;
import it.polimi.ingsw.server.gamelogic.board.Dice;
import it.polimi.ingsw.server.gamelogic.board.Tower;
import it.polimi.ingsw.server.gamelogic.board.TowerSlot;
import it.polimi.ingsw.server.gamelogic.cards.development.DevelopmentCard;
import it.polimi.ingsw.server.gamelogic.enums.DiceColor;
import it.polimi.ingsw.server.gamelogic.player.Player;
import it.polimi.ingsw.shared.model.GeneralColor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * //
 */
public class SemiPeriod extends Observable implements Observer {
    private List<DevelopmentCard> developmentCards;
    private List<Player> players;
    private Board board;

    private List<Round> rounds;
    private boolean current;

    public SemiPeriod(List<DevelopmentCard> developmentCards, List<Player> players, Board board) {
        this.developmentCards = developmentCards;
        this.players = players;
        this.board = board;
        rounds = new ArrayList<>();
        current = false;
    }

    @Override
    public void update(Observable o, Object arg) {
        /*

         */
    }

    public void setupBoard() {
        List<Dice> newDices;
        newDices = extractDices();
        board.setDices(newDices);
        setBoardCards();
    }

    private List<Dice> extractDices() {
        List<DiceColor> colors = new ArrayList<DiceColor>(){{add(DiceColor.BLACK);
            add(DiceColor.ORANGE);
            add(DiceColor.WHITE);}};
        Random random = new Random();
        List<Dice> dices = new ArrayList<>();
        for (DiceColor diceColor : colors)
            dices.add( new Dice(diceColor, random.nextInt(5) + 1) );
        return dices;
    }

    private void setBoardCards() {
        List<DevelopmentCard> territories, buildings, characters, ventures;
        territories = developmentCards.stream()
                .filter(card -> GeneralColor.GREEN.equals(card.getCardInformation()
                        .getCardColor()))
                .collect(Collectors.toList());
        buildings = developmentCards.stream()
                .filter(card -> GeneralColor.YELLOW.equals(card.getCardInformation()
                        .getCardColor()))
                .collect(Collectors.toList());
        characters = developmentCards.stream()
                .filter(card -> GeneralColor.BLUE.equals(card.getCardInformation()
                        .getCardColor()))
                .collect(Collectors.toList());
        ventures = developmentCards.stream()
                .filter(card -> GeneralColor.PURPLE.equals(card.getCardInformation()
                        .getCardColor()))
                .collect(Collectors.toList());
        setTowerCards(territories, GeneralColor.GREEN);
        setTowerCards(buildings, GeneralColor.YELLOW);
        setTowerCards(characters, GeneralColor.BLUE);
        setTowerCards(ventures, GeneralColor.PURPLE);
    }

    private void setTowerCards(List<DevelopmentCard> cardsToAdd, GeneralColor color) {
        Tower towerToFill;
        int i=0;
        towerToFill = board.getTowers().stream()
                .filter(tower -> color.equals(tower.getColor()))
                .findFirst()
                .get();
        for (TowerSlot towerSlot : towerToFill.getTowerSlots()) {
            if(color.equals(GeneralColor.GREEN))
                towerSlot.setDevelopmentCard(cardsToAdd.get(i));
            else if(color.equals(GeneralColor.BLUE))
                towerSlot.setDevelopmentCard(cardsToAdd.get(i));
            else if(color.equals(GeneralColor.YELLOW))
                towerSlot.setDevelopmentCard(cardsToAdd.get(i));
            else if(color.equals(GeneralColor.PURPLE))
                towerSlot.setDevelopmentCard(cardsToAdd.get(i));
        }
    }

    public void setupRound() {

        /*
         */
    }

    public void initRound() {
        /*

         */
    }

    public void endSemiPeriod() {
        /*
         */
    }

    public void calculateTotalPlayer(){
        //Calcola turno giocatori
    }

    public List<DevelopmentCard> getDevelopmentCards() {
        return developmentCards;
    }

    public void setDevelopmentCards(List<DevelopmentCard> developmentCards) {
        this.developmentCards = developmentCards;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
