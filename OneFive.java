import CardPlayers.CardPlayer;
import CardPlayers.Computer;
import CardPlayers.User;

public class OneFive {

    public static void main(String[] args) {

        gameStart();
    }

    public static void gameStart()

    {
        Scoreboard s = new Scoreboard();
        CardPlayer p2 = new Computer(); // Player 2
        CardPlayer p1 = new Computer(); // Player 1

        Dealer d = new Dealer(p1, p2);
        boolean flag = true;
        int roundCounter = 0;

        while (flag && roundCounter < 7) {
            flag = flag && d.nextTurn();
            roundCounter++;
        }

        if (flag) {
            // system Record On
            s.FileOut(d.getScoreBoard());

            return;
        } else {
            // system Record Off
            return;
        }
    }
}
