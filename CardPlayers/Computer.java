package CardPlayers;

import java.util.Random;

import Cards.Card;
import Cards.Five;
import Cards.Four;
import Cards.One;
import Cards.Three;
import Cards.Two;
import Cards.Zero;

public class Computer extends CardPlayer {
    int score = 0;

    Card one = new One();
    Card two = new Two();
    Card three = new Three();
    Card four = new Four();
    Card five = new Five();
    Card zero = new Zero();
    Card[] deck = { zero, one, two, three, four, five };

    public Card setCard() {

        Random r = new Random();
        Card s = null;
        int i = r.nextInt(6);

        while (s == null) {
            if (deck[i] == null) {
                i = r.nextInt(6);
            } else {
                s = deck[i];
                deck[i] = null;
            }
        }

        return s;
    }

    public void scoreAdd(int a) {
        this.score = this.score + a;
    }

    public int getScore() {
        return score;
    }

    public void closeInput() {
    }

}
