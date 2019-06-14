package com.ryan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static List<Card> deck;

    public static void main(String[] args) {

        initializeCards();
//        printCards();
        shuffleCards();
        printCards();


        System.out.println(drawCard().toString());

    }

    public static void initializeCards() {

        deck = new ArrayList<Card>();

        List<String> types = new ArrayList<String>();
        types.add("Diamonds");
        types.add("Hearts");
        types.add("Spades");
        types.add("Clubs");

        List<Integer> values = new ArrayList<Integer>();
        for (int i = 1; i <= 13; i++) {
            values.add(i);
        }

        int count = 0;
        int color = 1;

        for (int i = 1; i <= 13; i++) {
            for (int type = 0; type < types.size(); type++) {
                Card card = new Card(i, types.get(type), color == 1 ? "black" : "red");
                count++;
                color = (color == 1) ? 0 : 1;

                deck.add(card);

            }
        }
    }

    public static void printCards() {
        for (Card card : deck) {
            if (card.getSecondaryName() == null) {
                System.out.print(Integer.toString(card.getValue()) + " of ");
            } else {
                System.out.print(card.getSecondaryName() + " of ");
            }

            System.out.print(card.getType());
            System.out.println("\n");
        }
    }

    public static void shuffleCards() {
        Collections.shuffle(deck);
    }

    public static Card drawCard() {
        if (!deck.isEmpty()) {
            return deck.get(0);
        } else {
            return null;
        }
    }
}
