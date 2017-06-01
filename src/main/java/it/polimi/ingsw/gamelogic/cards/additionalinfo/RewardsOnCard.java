package it.polimi.ingsw.gamelogic.cards.additionalinfo;

import it.polimi.ingsw.gamelogic.cards.CardVisitor;
import it.polimi.ingsw.gamelogic.modifiers.rewards.modifiers.RewardsModifier;

/**
 * TODO: JavaDoc
 */
public class RewardsOnCard extends AdditionalCardInfo {
    private RewardsModifier rewardsModifier;

    public RewardsOnCard(String name, RewardsModifier rewardsModifier) {
        super(name);
        this.rewardsModifier = rewardsModifier;
    }

    @Override
    public void acceptCardVisitor(CardVisitor cardVisitor) {
        cardVisitor.visitAdditionalCardInfo(this);
    }

    public RewardsModifier getRewardsModifier() {
        return rewardsModifier;
    }

    public void setRewardsModifier(RewardsModifier rewardsModifier) {
        this.rewardsModifier = rewardsModifier;
    }
}