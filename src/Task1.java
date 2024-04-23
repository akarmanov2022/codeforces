import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        t = Math.abs(t);

        for (int i = 0; i < t; i++) {
            String[] line = reader.readLine().split("\\s");

            int n = Integer.parseInt(line[0]);
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);

            int min = Math.min(n * a, (n / 2) * b + (n % 2) * a);
            System.out.println(min);
        }
    }
}
