package com.ryan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Card> deck;
    private static Player player;
    private static Dealer dealer;
    private static boolean gameOver = false;
    private static boolean tableStarted = false;

    public static void main(String[] args) {
        int playerMove;
        int tableMove;

        System.out.println("Welcome to my very first Blackjack game made using Java SDK 8! Enjoy! \n - helloryantg \n");

        System.out.println("First, what is your name?");
        String playerName = scanner.nextLine();

        delayCode(1000);

        player = new Player(playerName);
        dealer = new Dealer();
        System.out.println("Hello " + player.getName() + ", let's play! \n");
        delayCode(200);

        // User actions start here
        while (!gameOver) {
            System.out.println("What do you want to do?");
            System.out.println("\t'1' to begin");
            System.out.println("\t'0' to exit");

            while (!scanner.hasNext()) {
                System.out.println("Key must be valid");
                System.out.println("\nWhat do you want to do? [1] for help");
                scanner.next();
            }

            playerMove = scanner.nextInt();

            switch (playerMove) {
                case 0: // end the game;
                    gameOver = true;
                    delayCode(400);
                    System.out.println("Ending the game. Thanks for playing!");
                    break;
                case 1: // begin
                    System.out.println("Starting the game");

                    initializeCards();
                    shuffleCards();

                    Card firstDraw = drawCard();
                    player.addPlayerCard(firstDraw);
                    delayCode(200);

                    Card secondDraw = drawCard();
                    dealer.addDealerCard(secondDraw);
                    delayCode(200);

                    Card thirdDraw = drawCard();
                    player.addPlayerCard(thirdDraw);
                    delayCode(200);

                    Card fourthDraw = drawCard();
                    dealer.addDealerCard(fourthDraw);
                    delayCode(200);

                    player.showPlayerCards();
                    dealer.showDealerCards();

                    checkForwinner(player.getPlayerCards(), player);
                    checkForwinner(dealer.getDealerCards(), dealer);

                    tableStarted = true;
            }

            while (tableStarted) {

                System.out.println("What's your move?");
                System.out.println("\t'1' to hit");
                System.out.println("\t'2' to stand");
                System.out.println("\t'3' to double");

                tableMove = scanner.nextInt();

                switch (tableMove) {
                    case 0: // exit
                        tableStarted = false;
                        gameOver = true;
                        delayCode(200);
                        System.out.println("Leaving the table. Thanks for playing!");
                        break;
                    case 1: // HIT
                        Card drawnCard = drawCard();
                        player.addPlayerCard(drawnCard);
                        player.showPlayerCards();
                        checkForwinner(player.getPlayerCards(), player);
                        break;
                    case 2: // STAND
                }

            }
        }
        scanner.close();
    }

    public static void checkForwinner(List<Card> cards, Player player) {
        int totalValue = 0;

        for (int i = 0 ; i < cards.size(); i++) {
            totalValue += cards.get(i).getValue();
        }

        if (totalValue == 21) {
            System.out.println(player.getName() + " wins!!");
            gameOver = true;
        } else if (totalValue > 21) {
            System.out.println(player.getName() + " busted! lose");
            gameOver = true;
        }
    }

    public static void checkForwinner(List<Card> cards, Dealer dealer) {
        int totalValue = 0;

        for (int i = 0 ; i < cards.size(); i++) {
            totalValue += cards.get(i).getValue();
        }

        if (totalValue == 21) {
            System.out.println(dealer.getName() + " wins!!");
            gameOver = true;
        } else if (totalValue > 21) {
            System.out.println(dealer.getName() + " busted! lose");
            gameOver = true;
        }
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
            return deck.remove(deck.size() - 1);
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
