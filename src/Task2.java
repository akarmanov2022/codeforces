import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(reader.readLine());

    int max = 25_0000;

    for (int i = 0; i < t; i++) {
      String[] strings = reader.readLine().split("\\s");
      String[] aaa = reader.readLine().split("\\s");

      int n = Integer.parseInt(strings[0]);
      int c = Integer.parseInt(strings[1]);
      int d = Integer.parseInt(strings[2]);

      if (aaa.length > n * n) {
        System.out.println("NO");
        continue;
      }

      int a11 = Integer.parseInt(strings[0]);
      int aij = a11;
      for (int j = 1; j < aaa.length; j++) {
        int ai = Integer.parseInt(aaa[j]);

        if ((j + 1) % n == 0)
          continue;

        if (ai != aij + d) {
          System.out.println("NO");
          break;
        } else {
          aij = ai;
        }
      }
    }
  }
}
