package vp;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by imosca on 17/08/2015.
 */
public class ParallelTest {

    private static void sequential(String[] array) {
        Arrays.stream(array).map(String::toLowerCase).collect(Collectors.toList());
    }
    private static void parallel(String[] array) {
        Arrays.stream(array).parallel().map(String::toLowerCase).collect(Collectors.toList());
    }

    @Test
    public void parallelTest(){
        String[] array = new String[1000000];
        Arrays.fill(array, "HADOUKEN!");
        /* En runtime la JVM optimiza parte del código.
        Para eso está etapa de Calentamiiento Previo que corre aquellas partes del código que van a ser más usadas
        */
        System.out.println("JIT Warmup Time...");
        for (int i = 0; i < 100; ++i) {
            sequential(array);
            parallel(array);
        }
        System.out.println("Benchmark...");
        for (int i = 0; i < 5; ++i) {
            System.out.printf("Run %d:  sequential %s  -  parallel %s\n",
                    i,
                    test(() -> sequential(array)),
                    test(() -> parallel(array)));
        }
    }

    private static String test(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long elapsed = System.currentTimeMillis() - start;
        return String.format("%4.2fs", elapsed / 1000.0);
    }

}
