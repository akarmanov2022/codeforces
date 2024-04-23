import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Arseniy Karmanov
 */
public class Bar {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = reader.readLine().split("\\s");

        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        String[][] matrix = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s");
            System.arraycopy(line, 0, matrix[i], 0, line.length);
        }

        matrix = rotateMatrix(matrix);
        for (int i = 0; i < n; i++) {
            System.out.println(String.join(" ", matrix[i]));
        }
    }

    public static String[][] rotateMatrix(String[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        String[][] result = new String[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][rows - 1 - i] = matrix[j][i];
            }
        }
        return result;
    }
}
