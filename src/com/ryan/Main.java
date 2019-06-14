package com.ryan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    private static List<Card> deck;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my very first Blackjack game made using Java SDK 8! Enjoy! \n - helloryantg \n \n");

        System.out.println("First, what is your name?");
        String playerName = scanner.nextLine();

        delayCode(2000);

        System.out.println("Hello " + playerName + ", let's play! \n");

        initializeCards();
        shuffleCards();

        System.out.println("Begin?");
        // User actions start here

//        Card firstDraw = drawCard();
//        System.out.println(firstDraw.printValue());

//        Card secondDraw = drawCard();
//        System.out.println(secondDraw.printValue());

    }

    public static void initializeCards() {

        System.out.println("Initializing the deck of 52 cards... \n");

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

        delayCode(2000);
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

        System.out.println("The deck has been shuffled! \n");

        delayCode(2000);
    }

    public static Card drawCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        } else {
            return null;
        }
    }

    public static void delayCode(int milliseconds) {
        // This delays the printing of the player name
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e) {
            System.out.println("Somehow got interrupted!");
        }


    }
}
