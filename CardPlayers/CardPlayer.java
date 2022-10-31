package CardPlayers;
import Cards.Card;

public abstract class CardPlayer {
    int score;
    Card[] deck;

    public abstract Card setCard();

    public abstract void scoreAdd(int a);

    public abstract void closeInput();

    public abstract int getScore();

}
