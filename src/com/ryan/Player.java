package com.ryan;

import java.util.List;

public class Player {

    private String name;
    private int cash;
    private List<Card> playerCards;

    public Player(String name) {
        this.name = name;
        this.cash = 1000;
    }

    public Player(String name, int cash) {
        this.name = name;
        this.cash = cash;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCash() { return cash; }
    public int addCash(int cash) {
        this.cash += cash;
        return this.cash;
    }
    public int loseCash(int cash) {
        this.cash -= cash;
        return this.cash;
    }

    public List<Card> getPlayerCards() { return playerCards; }
    public void addPlayerCard(Card card) {

        String value;
        String type;

        if ((card.getValue() > 10) || (card.getValue() == 1)) {
            value = card.getSecondaryName();
        } else {
            value = Integer.toString(card.getValue());
        }
        type = card.getType();

        System.out.println("Player received a " + value + " of " + type);
    }
}
