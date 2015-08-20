package vp;

import org.junit.Test;

import java.util.stream.LongStream;

/**
 * Created by imosca on 18/08/2015.
 */
public class LazyTest {

    @Test
    public void testLazy(){
        LongStream longStream = LongStream.rangeClosed(1, 20000000);
        longStream.filter(x->x%2==0).limit(5).forEach(System.out::println);
    }

}
