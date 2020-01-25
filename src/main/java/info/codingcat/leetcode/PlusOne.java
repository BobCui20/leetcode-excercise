package info.codingcat.leetcode;

import java.util.Arrays;

/**
 * PlusOne
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        System.out.println(Arrays.toString(p.plusOne(new int[]{9})));
    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 <= 9) {
                digits[i] += 1;
                break;
            } else {
                digits[i] = (digits[i] + 1) % 10;

                if (i == 0) {
                    int[] extended = new int[digits.length + 1];
                    extended[0] = 1;
                    return extended;
                }
            }
        }
        return digits;
    }

}