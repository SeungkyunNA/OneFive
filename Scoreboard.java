import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Scoreboard {

    int[] Scoreboard = new int[11];
    int i = 0;

    public boolean record(int a) {

        if (i < 11) {
            Scoreboard[i] = a;
            i++;

            if (i == 10) {
                FileOut(Scoreboard);
            }
            return true;
        } else {
            return false;
        }
    }

    public void FileOut(int[] rc) {
        String text = dbtoString(rc);
        // System.out.println(text);

        File db = new File("/Users/na/Desktop/OneFive/OneFive/db.txt");
        PrintWriter out = null;
        try {
            FileWriter writer = new FileWriter(db, true);
            // 필터
            out = new PrintWriter(writer);
            out.print(text);
            // out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    String dbtoString(int[] a) {
        String index12;
        if (a[12] == 1) {
            index12 = "u";
        } else if (a[12] == 2) {
            index12 = "c";
        } else {
            index12 = "d";
        }
        String index0 = a[0] + "";
        String index1 = a[1] + "";
        String index2 = a[2] + "";
        String index3 = a[3] + "";
        String index4 = a[4] + "";
        String index5 = a[5] + "";
        String index6 = a[6] + "";
        String index7 = a[7] + "";
        String index8 = a[8] + "";
        String index9 = a[9] + "";
        String index10 = a[10] + "";
        String index11 = a[11] + "";

        return index12 + " " + index0 + " " + index1 + " " + index2 + " " + index3 + " " + index4 + " " + index5 + " "
                + index6 + " " + index7 + " " + index8 + " " + index9 + " "
                + index10 + " " + index11 + "\n";

    }

}
