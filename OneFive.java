
public class OneFive extends Thread {

    public static void main(String[] args) {
        Thread t1 = new OneFive();
        Thread t2 = new OneFive();
        Thread t3 = new OneFive();

        t1.start();
        System.out.println("t1 TID is Running: " + t1.getId());
        t2.start();
        System.out.println("t2 TID is Running: " + t2.getId());
        t3.start();
        System.out.println("t3 TID is Running: " + t3.getId());

        try {
            t1.join(); // t 쓰레드가 종료할 때까지 기다린다.
            t2.join(); // t 쓰레드가 종료할 때까지 기다린다.
            t3.join(); // t 쓰레드가 종료할 때까지 기다린다.

        } catch (Exception e) {
        }
        System.out.println("main end."); // main 메소드 종료
    }

    public void run() {
        long t = System.currentTimeMillis();
        long end = t + 15000;

        while (System.currentTimeMillis() < end) {
            todo();
        }

    }

    public void todo()

    {
        Scoreboard s = new Scoreboard();
        CardPlayer p2 = new Computer();
        CardPlayer p1 = new Computer();

        Dealer d = new Dealer(p1, p2);
        boolean flag = true;
        int roundCounter = 0;

        while (flag && roundCounter < 7) {
            flag = flag && d.nextTurn();
            roundCounter++;
        }

        if (flag) {
            // 시스템 레코드 시작
            s.FileOut(d.getScoreBoard());

            return;
        } else {
            // 시스템 레코드 안함
            return;
        }
    }
}
