package com.ryan;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private String name;
    private int cash;
    private List<Card> dealerCards;

    public Dealer() {
        this.name = "dealer";
        this.cash = 10000;
        dealerCards = new ArrayList<Card>();
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

    public List<Card> getDealerCards() { return dealerCards; }
    public void addDealerCard(Card card) { dealerCards.add(card); }
    public void showDealerCards() {
        System.out.println("Dealer's Cards");

        int totalValue = 0;
        int secondaryValue = 0;

        for (int i = 0; i < dealerCards.size(); i++) {

            int cardValue = dealerCards.get(i).getValue();
            String value = Integer.toString(cardValue);

            if (cardValue > 10) {
                value = dealerCards.get(i).getSecondaryName();
            } else if (cardValue == 1) {
                value = dealerCards.get(i).getSecondaryName();
                totalValue += dealerCards.get(i).getSecondaryValue() - 1;
            }

            totalValue += dealerCards.get(i).getValue();

            if (totalValue > 21) {
                if (dealerCards.contains("Ace")) {
                    totalValue -= 10;
                }
            }

            System.out.println("\t" + (i + 1) +  ") " + value + " of " + dealerCards.get(i).getType());
            delayCode(200);
        }
        System.out.println("\tTotal : " + totalValue);
        if (secondaryValue != 0) {
            System.out.println("\t or " + secondaryValue);
        }

        System.out.println("\n");
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
