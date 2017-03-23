import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sail on 3/12/17.
 * Project: Algorithm.
 */
class ArrayToList {
    private List convert(int[] array) {
        //TODO
        // raw List
        // return Arrays.asList(array)

        // default: ArrayList
        // return Stream.of(array).collect(Collectors.toList());

        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }
}
