public class Dealer {

    int round = 5;
    CardPlayer u;
    CardPlayer c;
    Card u_Card;
    Card c_Card;
    int isUserWin; // 0 = Draw , 1 = User win , 2 = Computer Win
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
                System.err.println("파토");
                return false;
            }

            /* 포인트 분배 */
            if (isUserWin == 1) {

                // System.out.println("Round : " + ((round * -1) + 6));
                // System.out.println("유저선택 : " + u_Card.getValue() + " 컴퓨터 선택 : " +
                // c_Card.getValue());
                // System.out.println("유저가 승리했습니다.");
                u.scoreAdd(u_Card.getValue() + c_Card.getValue());

                // System.out.println("현재 스코어");
                // System.out.println("유저 : " + u.getScore() + " 컴퓨터 : " + c.getScore());
                round--;
            } else if (isUserWin == 2) {
                // System.out.println("Round : " + ((round * -1) + 6));
                // System.out.println("유저선택 : " + u_Card.getValue() + " 컴퓨터 선택 : " +
                // c_Card.getValue());
                // System.out.println("컴퓨터가 승리했습니다.");

                c.scoreAdd(u_Card.getValue() + c_Card.getValue());
                // System.out.println("현재 스코어");
                // System.out.println("유저 : " + u.getScore() + " 컴퓨터 : " + c.getScore());
                round--;
            } else if (isUserWin == 0) {
                // System.out.println("Round : " + ((round * -1) + 6));
                // System.out.println("유저선택 : " + u_Card.getValue() + " 컴퓨터 선택 : " +
                // c_Card.getValue());
                // System.out.println("비겼습니다");
                // System.out.println("현재 스코어");
                // System.out.println("유저 : " + u.getScore() + " 컴퓨터 : " + c.getScore());
                round--;
            } else {
                // System.err.println("문제생김");
            }
        } else {
            sc[12] = isUserFinalWin;
            switch (isUserFinalWin) {
                case 0:
                    // System.out.println("게임이 종료되었습니다 비겼습니다");
                    u.closeInput();

                    break;
                case 1:
                    // System.out.println("게임이 종료되었습니다 유저가 승리했습니다");
                    u.closeInput();

                    break;
                case 2:
                    // System.out.println("게임이 종료되었습니다 컴퓨터가 승리했습니다");
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
            System.err.println("파토");

        }
        return -99;

    }

    public int[] getScoreBoard() {

        return sc;

    }

}
