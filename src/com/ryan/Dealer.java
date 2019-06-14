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

        for (int i = 0; i < dealerCards.size(); i++) {

            int cardValue = dealerCards.get(i).getValue();
            String value = Integer.toString(cardValue);

            if (cardValue > 10 || cardValue == 1) {
                value = dealerCards.get(i).getSecondaryName();
            }

            totalValue += dealerCards.get(i).getValue();

            System.out.println((i + 1) + ") " + value + " of " + dealerCards.get(i).getType());
            System.out.println("Total : " + totalValue);
        }
        System.out.println("\n");
    }
}
