import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Arseniy Karmanov
 */
public class Odoo {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    String odoo = "ODOO";


    for (int i = 0; i < t; i++) {
      int count = 0;
      int lr = 0;
      int rl = 0;

      String line = reader.readLine();
      if (line.equalsIgnoreCase(odoo)) {
        System.out.println(count);
        continue;
      }

      String copyLine1 = line;
      String copyLine2 = line;

      String left = line.substring(0, odoo.length());
      String right = line.substring(line.length() - odoo.length());
      if (left.equalsIgnoreCase(odoo)) {
        left = line.substring(odoo.length());
        count += left.length();
      } else if (right.equalsIgnoreCase(odoo)) {
        right = line.substring(0, line.length() - odoo.length() - 1);
        count += right.length();
      } else if (line.length() != odoo.length()) {
        for (int j = 0; j < copyLine1.length(); j++) {
          String substring = copyLine1.substring(0, odoo.length());
          if (substring.equalsIgnoreCase(odoo) || copyLine1.length() == odoo.length()) {
            substring = copyLine1.substring(copyLine1.length() - j);
            copyLine1 = copyLine1.substring(0, copyLine1.length() - 1);
            lr += substring.length();
            break;
          } else {
            copyLine1 = copyLine1.substring(1);
            lr++;
          }
        }
        for (int j = line.length() - 1; j >= odoo.length(); j--) {
          String substring = copyLine2.substring(copyLine2.length() - odoo.length());
          if (substring.equalsIgnoreCase(odoo)) {
            substring = copyLine2.substring(0, copyLine2.length() - j);
            copyLine2 = copyLine2.substring(1);
            rl += substring.length();
            break;
          } else {
            copyLine2 = copyLine2.substring(0, j);
            rl++;
          }
        }
      }
      for (int j = 0; j < copyLine1.length(); j++) {
        if (copyLine1.charAt(j) != odoo.charAt(j)) {
          lr++;
        }
      }
      for (int j = 0; j < copyLine2.length(); j++) {
        if (copyLine2.charAt(j) != odoo.charAt(j)) {
          rl++;
        }
      }
      count += Math.min(rl, lr);
      System.out.println(count);
    }
  }
}
