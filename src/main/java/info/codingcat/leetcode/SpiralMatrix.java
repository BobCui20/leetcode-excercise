package info.codingcat.leetcode;

import java.util.Arrays;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        String str = Arrays.deepToString(s.generateMatrix(0));
        System.out.println(str);
    }

    public int[][] generateMatrix(int n) {

        int c = 1;
        int[][] r = new int[n][n];

        int i = 0, j = 0;
        int layer = 0;
        while(c <= n*n) {

            r[i][j] = c;

            if( i == layer && j < n - 1 - layer) {
                j ++ ;
            } else if ( j == n - 1 - layer && i < n - 1 - layer) {
                i ++ ;
            } else if ( i == n - 1 - layer && j > layer) {
                j -- ;
            } else if ( j == layer && i > layer) {
                if (j == layer && i == layer + 1) {
                    layer ++ ;
                    j ++ ;
                } else {
                    i -- ;
                }
            }

            c ++;
        }

        return r;
    }

}