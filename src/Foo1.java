import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Arseniy Karmanov
 */
public class Foo1 {
    private final static AtomicInteger count1 = new AtomicInteger();
    private final static AtomicInteger count2 = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        int x = 100_000;
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatch = new CountDownLatch(x);

        long start = System.currentTimeMillis();
        for (int i = 0; i < x; i++) {
            executorService.submit(() -> {
                count1.getAndIncrement();
                count2.getAndIncrement();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();

        System.out.println("count1 = " + count1);
        System.out.println("count2 = " + count2);
        System.out.println("elapsed = " + (end - start));
        executorService.shutdown();
    }
}
