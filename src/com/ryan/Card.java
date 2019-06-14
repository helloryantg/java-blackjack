package com.ryan;

public class Card {

    private int value;
    private int secondaryValue;
    private String type;
    private String color;
    private boolean isFaceCard;
    private String secondaryName;

    public Card(int value, String type, String color) {
        this.value = value;
        this.type = type;
        this.color = color;

        if (value > 10) {
            this.isFaceCard = true;
        } else {
            this.isFaceCard = false;
        }

        if (value == 1) {
            this.secondaryValue = 11;
            this.secondaryName = "Ace";
        }

        if (value == 11) {
            this.secondaryName = "Jack";
        }
        if (value == 12) {
            this.secondaryName = "Queen";
        }
        if (value == 13) {
            this.secondaryName = "King";
        }
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public boolean isFaceCard() {
        return isFaceCard;
    }

    public int getSecondaryValue() {
        return secondaryValue;
    }

    public String getSecondaryName() {

        return secondaryName;
    }

    public String printValue() {
        return Integer.toString(getValue()) + " of " + getType();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Card{");
        sb.append("value=").append(value);
        sb.append(", secondaryValue=").append(secondaryValue);
        sb.append(", type='").append(type).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", isFaceCard=").append(isFaceCard);
        sb.append(", secondaryName='").append(secondaryName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
