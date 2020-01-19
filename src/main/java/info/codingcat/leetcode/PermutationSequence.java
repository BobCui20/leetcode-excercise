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
            int currNumOfSelections = fac(i - 1);
            int digit = (k - 1) / currNumOfSelections + 1;

            k = k % currNumOfSelections;
            if (k == 0) {
                k = currNumOfSelections;
            }
            s.append(selection.get(digit - 1));
            selection.remove(digit - 1);

        }
        return s.toString();
    }

    public int fac(int n) {
        int r = 1;
        while (n != 0) {
            r *= n--;
        }
        return r;
    }
}