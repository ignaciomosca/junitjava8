package vp;

import functionalInterfaces.TriFunction;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * Created by imosca on 18/08/2015.
 */
public class FunctionalTestALaBartolaHeavyMetalHarryPotter {

    @Test
    public void testSumaFunctional(){
        int suma = new FunctionBinariaInt(){
            @Override
            public int operacionBinariaInts(int a, int b) {
                return a+b;
            }
        }.operacionBinariaInts(3, 4);
        Assert.assertEquals(7,suma);
    }

    @Test
    public void testMultiplicacionFunctional(){
        int mult = new FunctionBinariaInt(){
            @Override
            public int operacionBinariaInts(int a, int b) {
                return a*b;
            }
        }.operacionBinariaInts(3, 4);
        Assert.assertEquals(12,mult);
    }


    @Test
    public void testMultiplicacionFunctionalConBiFunction(){
        BiFunction<Integer,Integer,Integer> mult = (a,b) -> a*b;
        Assert.assertEquals(new Integer("12"),mult.apply(3,4));
    }


    @Test
    public void testMultiplicacionFunctionalConTriFunction(){
        TriFunction<Integer,Integer,Integer,Integer> mult = (a,b,c) -> a*b*c;
        Assert.assertEquals(new Integer("27"),mult.apply(3,3,3));
    }

    @Test
    public void testCurrying(){
        IntFunction<IntUnaryOperator> curriedAdd = a -> b -> a + b;
        Assert.assertEquals(6,curriedAdd.apply(3).applyAsInt(3));
    }
}
