import java.util.stream.Stream;

/**
 * Created by sail on 3/7/17.
 * Create an endless random number stream
 */
public class RandomNumbers {
    public Stream<Long> randomStream(int range) {
        return Stream.generate(Math::random).
                map(n -> n * range).
                map(Math::round);
    }
}
