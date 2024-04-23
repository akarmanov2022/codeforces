import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Arseniy Karmanov
 */
public class Odoo2 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(reader.readLine());

    String odoo = "ODOO";

    for (int i = 0; i < t; i++) {
      String string = reader.readLine();
      int minDiff = Integer.MAX_VALUE;
      for (int j = 0; j < string.length() - 3; j++) {
        int difCnt = 0;
        for (int k = 0; k < odoo.length(); k++) {
          if (odoo.charAt(k) != string.charAt(j + k))
            difCnt++;
        }
        minDiff = Math.min(minDiff, difCnt);
      }
      System.out.println(minDiff + string.length() - 4);
    }
  }
}
