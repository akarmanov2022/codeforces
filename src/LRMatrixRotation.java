import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arseniy Karmanov
 */
public class LRMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split("\\s");

        int n = Integer.parseInt(strings[0]);
        boolean rotation = "L".equals(strings[1]);

        if (n == 1) {
            System.out.println(0);
            return;
        }

        String[][] matrix = new String[n][n];


        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("\\s");
            System.arraycopy(line, 0, matrix[i], 0, line.length);
        }

        Map<Integer, List<String>> operations = operationsForRotation(matrix, rotation);


        operations.forEach((integer, strings1) -> {
            System.out.println(integer);
            System.out.println(String.join("\n", strings1));
        });

    }

    private static Map<Integer, List<String>> operationsForRotation(String[][] matrix, boolean rotation) {
        Map<Integer, List<String>> operations = new HashMap<>();
        List<String> strings = new ArrayList<>();
        int counter = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                counter++;
                String s = "%d %d %d %d".formatted(i, j, j, rows - 1 - i);
                strings.add(s);
            }
        }
        operations.put(counter, strings);
        return operations;
    }
}
