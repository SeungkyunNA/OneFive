
import java.util.Scanner;

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
                System.err.println("숫자를 입력해주세요");
            }

            else {
                select = nr.nextInt();
                break;
            }
        }

        System.out.println("사용자 입력 : " + select);
        while (!isRightCard) {

            if (select < 0 || select > 5) {
                System.out.println("잘못된 입력입니다. 다른카드를 선택해주세요");
                select = nr.nextInt();
            } else if (deck[select] == null) {
                System.out.println("이미 제출한 카드입니다. 다른카드를 선택해주세요");
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
