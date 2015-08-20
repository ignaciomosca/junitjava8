package vp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by imosca on 18/08/2015.
 */
public class MapVsFlatMapTest {

    @Test
    public void mapVsFlatMapTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        List<List<Integer>> mapped =
                numbers.stream()
                        .map(number -> Arrays.asList(number -1, number, number +1))
                        .collect(Collectors.toList());
        System.out.println(mapped); //:> [[0, 1, 2], [1, 2, 3], [2, 3, 4], [3, 4, 5]] //"I DID NOT ASK FOR THIS" - GORZY

        List<Integer> flattened =
                numbers.stream()
                        .flatMap(number -> Arrays.asList(number -1, number, number +1).stream()) //ACHATAMIENTO COSMICO!
                        .collect(Collectors.toList());
        System.out.println(flattened);  //:> [0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4, 5]
    }
}
