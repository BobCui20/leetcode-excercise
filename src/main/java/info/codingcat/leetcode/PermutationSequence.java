package info.codingcat.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * PermutationSequence
 */
public class PermutationSequence {


    public String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();
        List<Integer> selection = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            selection.add(i);
        }
        for (int i = n; i > 0; i--) {
            int currNumOfDigit = fac(i - 1);
            int digit = (k - 1)/currNumOfDigit + 1;

            k = k%currNumOfDigit;
            if(k == 0) {
                k = currNumOfDigit;
            }
            s.append(selection.get(digit - 1));
            selection.remove(digit - 1);
            

        }
        return s.toString();
    }

    public int fac(int n) {
        int r = 1;
        while(n != 0) {
            r *= n--;
        }
        return r;
    }
}