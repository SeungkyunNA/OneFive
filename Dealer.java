import CardPlayers.CardPlayer;
import Cards.Card;

public class Dealer {

    int round = 5;
    CardPlayer u;
    CardPlayer c;
    Card u_Card;
    Card c_Card;
    int isUserWin; // 0 = Draw , 1 = Player 1 win , 2 = Player 2 Win
    int isUserFinalWin = -1;
    int[] sc = new int[13];

    public Dealer(CardPlayer p1, CardPlayer p2) {
        this.u = p1;
        this.c = p2;

    }

    public boolean nextTurn() {
        getCard();
        if (round > -1) {
            sc[(round * -2) + 10] = u_Card.getValue();
            sc[(round * -2) + 11] = c_Card.getValue();
        }
        if (isUserFinalWin == -1) {

            isUserWin = whoWin(u_Card, c_Card);
            if (isUserWin == -99) {
                System.err.println("Error");
                return false;
            }

            /* Point zuteilen */
            if (isUserWin == 1) {

                System.out.println("Round : " + ((round * -1) + 6));
                System.out.println("Player 1 Choose : " + u_Card.getValue() + " Player 2 Choose : " +
                        c_Card.getValue());
                System.out.println("Player 1 Win");
                u.scoreAdd(u_Card.getValue() + c_Card.getValue());

                System.out.println("Score");
                System.out.println("Player 1 : " + u.getScore() + " Player 2 : " + c.getScore());
                round--;
            } else if (isUserWin == 2) {
                System.out.println("Round : " + ((round * -1) + 6));
                System.out.println("Player 1 Choose : " + u_Card.getValue() + " Player 2 Choose : " +
                        c_Card.getValue());
                System.out.println("Player 2 Win");

                c.scoreAdd(u_Card.getValue() + c_Card.getValue());
                System.out.println("Score");
                System.out.println("Player 1 : " + u.getScore() + " Player 2 : " + c.getScore());
                round--;
            } else if (isUserWin == 0) {
                System.out.println("Round : " + ((round * -1) + 6));
                System.out.println("Player 1 Choose : " + u_Card.getValue() + " Player 2 Choose : " +
                        c_Card.getValue());
                System.out.println("Draw");
                System.out.println("Score");
                System.out.println("Player 1 : " + u.getScore() + " Player 2 : " + c.getScore());
                round--;
            } else {
                System.err.println("Error");
            }
        } else {
            sc[12] = isUserFinalWin;
            switch (isUserFinalWin) {
                case 0:
                    System.out.println("Draw!!!!!!");
                    u.closeInput();

                    break;
                case 1:
                    System.out.println("Player 1 Win!!!!!!");
                    u.closeInput();

                    break;
                case 2:
                    System.out.println("Player 2 Win!!!!!");
                    u.closeInput();

                    break;
            }
        }

        return true;
    }

    public void getCard() {
        if (round >= 0) {
            u_Card = u.setCard();
            c_Card = c.setCard();
        } else {
            if (u.getScore() > c.getScore()) {
                isUserFinalWin = 1;
            } else if (u.getScore() < c.getScore()) {
                isUserFinalWin = 2;
            } else {
                isUserFinalWin = 0;
            }

        }
    }

    private int whoWin(Card u, Card c) {
        if (u.getValue() == 5) {
            switch (c.getValue()) {
                case 5:
                    return 0;
                case 4:
                    return 1;
                case 3:
                    return 1;
                case 2:
                    return 2;
                case 1:
                    return 1;
                case 0:
                    return 1;
            }
        } else if (u.getValue() == 4) {
            switch (c.getValue()) {
                case 5:
                    return 2;
                case 4:
                    return 0;
                case 3:
                    return 1;
                case 2:
                    return 1;
                case 1:
                    return 1;
                case 0:
                    return 1;
            }
        }

        else if (u.getValue() == 3) {
            switch (c.getValue()) {
                case 5:
                    return 2;
                case 4:
                    return 2;
                case 3:
                    return 0;
                case 2:
                    return 1;
                case 1:
                    return 1;
                case 0:
                    return 1;
            }
        }

        else if (u.getValue() == 2) {
            switch (c.getValue()) {
                case 5:
                    return 1;
                case 4:
                    return 2;
                case 3:
                    return 2;
                case 2:
                    return 0;
                case 1:
                    return 1;
                case 0:
                    return 1;
            }
        }

        else if (u.getValue() == 1) {
            switch (c.getValue()) {
                case 5:
                    return 2;
                case 4:
                    return 2;
                case 3:
                    return 2;
                case 2:
                    return 2;
                case 1:
                    return 0;
                case 0:
                    return 1;
            }
        }

        else if (u.getValue() == 0) {
            switch (c.getValue()) {
                case 5:
                    return 2;
                case 4:
                    return 2;
                case 3:
                    return 2;
                case 2:
                    return 1;
                case 1:
                    return 2;
                case 0:
                    return 0;
            }
        } else {
            System.err.println("abgebrochen");

        }
        return -99;

    }

    public int[] getScoreBoard() {

        return sc;

    }

}
