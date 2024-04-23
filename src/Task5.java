import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Arseniy Karmanov
 */
public class Task5 {
    private static final Character C = 'C';
    private static final Character W = 'W';
    private static final Character DOT = '.';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = 3;

        char[][] forest = new char[n][m];
        for (int i = 0; i < n; i++) {
            forest[i] = br.readLine().toCharArray();
        }
        Hedgehog hedgehog = new Hedgehog(new Point(-1, 1));
        HedgehogInTheForest hedgehogInTheForest = new HedgehogInTheForest(hedgehog, forest);
        int count = hedgehogInTheForest.startWalk();
        System.out.println(count);
    }

    private static class Hedgehog {
        private Point current;

        private Hedgehog(Point current) {
            this.current = current;
        }

        public Point leftAndDown() {
            int x = current.x + 1;
            int y = current.y - 1;
            return new Point(x > 2 ? 0 : x, y);
        }

        public Point rightAndDown() {
            return new Point(current.x + 1, current.y + 1);
        }

        public Point down() {
            return new Point(current.x + 1, current.y);
        }

    }

    private record Point(int x, int y) {
    }

    private record HedgehogInTheForest(Hedgehog hedgehog, char[][] forest) {

        public int startWalk() {
            int count = 0;
            for (int i = 0; i < forest.length; ) {
                Point leftAndDown = hedgehog.leftAndDown();
                Point rightAndDown = hedgehog.rightAndDown();
                Point down = hedgehog.down();

                char leftAndDownChar = forest[leftAndDown.x][leftAndDown.y];
                char rightAndDownChar = forest[rightAndDown.x][rightAndDown.y];
                char downChar = forest[down.x][down.y];

                if (leftAndDownChar == W && rightAndDownChar == W && downChar == W) {
                    break;
                }

                if (leftAndDownChar == C || rightAndDownChar == C || downChar == C) {
                    count++;
                    if (downChar == C) {
                        hedgehog.current = down;
                    } else if (rightAndDownChar == C) {
                        hedgehog.current = rightAndDown;
                    } else {
                        hedgehog.current = leftAndDown;
                    }
                    continue;
                }

                if (leftAndDownChar == DOT || rightAndDownChar == DOT || downChar == DOT) {
                    if (downChar == DOT) {
                        hedgehog.current = down;
                    } else if (rightAndDownChar == DOT) {
                        hedgehog.current = rightAndDown;
                    } else {
                        hedgehog.current = leftAndDown;
                    }
                }
            }
            return count;
        }
    }
}
