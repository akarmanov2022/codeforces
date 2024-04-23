import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.stream.Collector;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;

public class MyCollectors {
    public static <T, R> Collector<T, ?, Optional<R>> minMax(Comparator<? super T> comparator,
                                                             BiFunction<? super T, ? super T, ? extends R> finisher) {
        class MinMaxAcc {
            T min;
            T max;
            boolean present;

            void add(T t) {
                if (present) {
                    if (comparator.compare(t, min) < 0) min = t;
                    if (comparator.compare(t, max) > 0) max = t;
                } else {
                    min = max = t;
                    present = true;
                }
            }

            MinMaxAcc combine(MinMaxAcc other) {
                if (!other.present) return this;
                if (!present) return other;
                if (comparator.compare(other.min, min) < 0) min = other.min;
                if (comparator.compare(other.max, max) > 0) max = other.max;
                return this;
            }
        }

        return Collector.of(
                MinMaxAcc::new,
                MinMaxAcc::add,
                MinMaxAcc::combine,
                minMaxAcc -> minMaxAcc.present ?
                        Optional.of(finisher.apply(minMaxAcc.min, minMaxAcc.max)) :
                        Optional.empty());
    }

    public static void main(String[] args) {
        ThreadLocalRandom.current().ints(20, 1, 100)
                .boxed()
                .reduce((a, b) -> a)
                .ifPresent(System.out::println);
    }
}
