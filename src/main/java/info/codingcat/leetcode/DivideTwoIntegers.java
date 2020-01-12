package info.codingcat.leetcode;

/**
 * Hello world!
 *
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        int result = 0x00000000;
        boolean negative = false;

        // 1: different sign
        if ((dividend ^ divisor) >>> 31 == 1) {
            negative = true;
        }

        dividend = abs(dividend);
        divisor = abs(divisor);

        int residual = 0x00000000;
        for (int i = 31; i >= 0; i--) {
            result <<= 1;
            // take one bit
            residual <<= 1;
            residual |= ((dividend >>> i) & 0x00000001);
            if (compare(divisor, residual)) {
                // Set LSB to 0
                result |= 0x00000000;
            } else {
                residual = subtract(residual, divisor);
                result |= 0x00000001;
            }

        }

        if(!negative && result == 0x80000000) {
            return Integer.MAX_VALUE;
        }

        if (negative) {
            result = ~result + 1;
        }

        return result;

    }

    public int abs(int n) {
        return (n ^ (n >> 31)) + (n >>> 31);
    }

    public boolean compare(int a, int b) {
        for (int i = 31; i >= 0; i--) {
            if (((a >>> i) & 0x00000001) == ((b >>> i) & 0x00000001)) {
                continue;
            } else if (((a >>> i) & 0x00000001) > ((b >>> i) & 0x00000001)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public int subtract(int x, int y) {

        while (y != 0) {

            int borrow = (~x) & y;
            x = x ^ y;
            y = borrow << 1;
        }
        return x;
    }

}
