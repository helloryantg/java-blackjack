package com.ryan;

import java.util.List;

public class Dealer {

    private String name;
    private int cash;
    private List<Card> dealerCards;

    public Dealer() {
        this.name = "dealer";
        this.cash = 10000;
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
    public void addDealerCard(Card card) {
        String value;
        String type;

        if ((card.getValue() > 10) || (card.getValue() == 1)) {
            value = card.getSecondaryName();
        } else {
            value = Integer.toString(card.getValue());
        }

        type = card.getType();

        System.out.println("Dealer received a " + value + " of " + type);
    }
}
