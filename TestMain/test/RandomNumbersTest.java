import org.junit.Test;

import java.util.stream.Stream;

/**
 * Created by sail on 3/7/17.
 * The method Math#random is a Supplier<double> and
 * can be used to generate an endless Stream or random numbers:
 */
public class RandomNumbersTest {
    public Stream<Long> randomStream(int range) {
        return Stream.generate(Math::random).
                map(n -> n * range).
                map(Math::round);
    }
    @Test
    public void streamNumbers() {
        randomStream(10).
                limit(10).
                forEach(System.out::println);
    }
}