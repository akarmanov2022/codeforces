import java.io.IOException;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.of;

public class Foo {
    public static void main(String[] args) throws IOException {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 7, 4, 1};
    
        long start = System.currentTimeMillis();
        int[] integers = IntStream.concat(of(nums1), of(nums2))
                .sorted()
                .toArray();

        int length = integers.length;
        if (length % 2 == 0) {
            int x = integers[length / 2 - 1];
            int y = integers[length / 2];
            System.out.println((x + y) / 2d);
        } else {
            int x = integers[length / 2];
            System.out.println(x * 1d);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time ms: " + (end - start));
    }
}
