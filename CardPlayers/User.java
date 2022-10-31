package CardPlayers;

import java.util.Scanner;

import Cards.Card;
import Cards.Five;
import Cards.Four;
import Cards.One;
import Cards.Three;
import Cards.Two;
import Cards.Zero;

public class User extends CardPlayer {
    int score = 0;
    Card one = new One();
    Card two = new Two();
    Card three = new Three();
    Card four = new Four();
    Card five = new Five();
    Card zero = new Zero();
    Card[] deck = { zero, one, two, three, four, five };
    Scanner nr;

    public Card setCard() {

        int select;
        boolean isRightCard = false;
        nr = new Scanner(System.in);
        System.out.println("Choose your next Card");
        while (true) {
            if (!nr.hasNextInt()) {
                nr.next();
                System.err.println("Please enter a number between 0 and 5");
            }

            else {
                select = nr.nextInt();
                break;
            }
        }

        System.out.println("User Input : " + select);
        while (!isRightCard) {

            if (select < 0 || select > 5) {
                System.out.println("Invalid input. Please select a different card");
                select = nr.nextInt();
            } else if (deck[select] == null) {
                System.out.println("This card has already been submitted. Please select a different card");
                select = nr.nextInt();
            } else {
                isRightCard = true;
            }
        }

        Card selected = deck[select];
        deck[select] = null;

        return selected;

    }

    public void scoreAdd(int a) {
        score = score + a;
    }

    public int getScore() {
        return score;
    }

    public void closeInput() {
        nr.close();
    }

}
