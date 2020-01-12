package info.codingcat.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DivideTwoIntegersTest 
{
    
    private DivideTwoIntegers d = new DivideTwoIntegers();


    @Test
    public void testDividePositiveMax(){
        int i = Integer.MAX_VALUE;
        int j = new Random().nextInt();
        assertEquals(String.format("%d divided by %d", i, j), i/j, d.divide(i, j));
    }

    @Test
    public void testDivideNegativeMax() {
        int i = Integer.MIN_VALUE + 1;
        int j = new Random().nextInt();
        assertEquals(String.format("%d divided by %d", i, j), i/j, d.divide(i, j));
    }

    @Test
    public void testDivideZero() {
        int i = 0;
        int j = new Random().nextInt();
        assertEquals(String.format("%d divided by %d", i, j), i/j, d.divide(i, j));
    }

    @Test
    public void testDivideNegativeBothNegative() {
        int i = -643452;
        int j = -4324;
        assertEquals(String.format("%d divided by %d", i, j), i/j, d.divide(i, j));
    }

    @Test
    public void testDivideNegativeBothPositive() {
        int i = 643452;
        int j = 4324;
        assertEquals(String.format("%d divided by %d", i, j), i/j, d.divide(i, j));
    }

    @Test
    public void testDivideNegativeDifferentSign1() {
        int i = -643452;
        int j = 4324;
        assertEquals(String.format("%d divided by %d", i, j), i/j, d.divide(i, j));
    }

    @Test
    public void testDivideNegativeDifferentSign2() {
        int i = 643452;
        int j = -4324;
        assertEquals(String.format("%d divided by %d", i, j), i/j, d.divide(i, j));
    }

    @Test
    @Ignore
    public void testDivideNegativeStressTest() {
        for(int i=Integer.MIN_VALUE; i<Integer.MAX_VALUE; i++){
            for(int j=Integer.MIN_VALUE; j<Integer.MAX_VALUE; j++) {
                if(j!=0){
                    assertEquals(String.format("%d divided by %d", i, j), i/j, d.divide(i, j));
                }
            }
        }
    }
}
