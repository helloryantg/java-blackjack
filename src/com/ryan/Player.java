package com.ryan;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int cash;
    private List<Card> playerCards;

    public Player(String name) {
        this.name = name;
        this.cash = 1000;
        playerCards = new ArrayList<Card>();
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
    public void addPlayerCard(Card card) { playerCards.add(card); }
    public void showPlayerCards() {
        System.out.println("Player's Cards");

        int totalValue = 0;
        int secondaryValue = 0;

        for (int i = 0; i < playerCards.size(); i++) {

            int cardValue = playerCards.get(i).getValue();
            String value = Integer.toString(cardValue);

            if (cardValue > 10) {
                value = playerCards.get(i).getSecondaryName();
            } else if (cardValue == 1) {
                value = playerCards.get(i).getSecondaryName();
                totalValue += playerCards.get(i).getSecondaryValue() - 1;
            }

            totalValue += playerCards.get(i).getValue();

            System.out.println((i + 1) +  ") " + value + " of " + playerCards.get(i).getType());
        }
        System.out.println("Total : " + totalValue);
        if (secondaryValue != 0) {
            System.out.println("\t or " + secondaryValue);
        }

        System.out.println("\n");
    }
}
