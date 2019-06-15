package com.ryan;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int cash;
    private List<Card> playerCards;
    private int cardTotal;

    public Player(String name) {
        this.name = name;
        this.cash = 1000;
        playerCards = new ArrayList<Card>();
        this.cardTotal = 0;
    }

    public Player(String name, int cash) {
        this.name = name;
        this.cash = cash;
        this.cardTotal = 0;
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

    public int getCardTotal() { return cardTotal; }
    public void setCardTotal(int cardTotal) { this.cardTotal = cardTotal; }

    public List<Card> getPlayerCards() { return playerCards; }
    public void addPlayerCard(Card card) { playerCards.add(card); }
    public void showPlayerCards() {
        System.out.println("Player's Cards");

        int secondaryValue = 0;

        for (int i = 0; i < playerCards.size(); i++) {

            int cardValue = playerCards.get(i).getValue();
            String value = Integer.toString(cardValue);

            cardTotal += playerCards.get(i).getValue();

            if (cardValue > 10) {
                value = playerCards.get(i).getSecondaryName();
            } else if (cardValue == 1) {
                value = playerCards.get(i).getSecondaryName();
            }

            System.out.println("\t" + (i + 1) +  ") " + value + " of " + playerCards.get(i).getType());
            delayCode(200);
        }

        System.out.println("\tTotal : " + cardTotal);
        System.out.println("\n");
        cardTotal = 0;
    }

    public void delayCode(int milliseconds) {
        // This delays the printing of the player name
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e) {
            System.out.println("Somehow got interrupted!");
        }
    }
}
