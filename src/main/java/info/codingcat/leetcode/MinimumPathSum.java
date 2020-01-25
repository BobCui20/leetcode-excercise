package info.codingcat.leetcode;

/**
 * MinimumPathSum
 */
public class MinimumPathSum {

    private int[][] dp;

    private int[][] grid;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];
        return dp(m, n);
    }

    private int dp(int m, int n) {
        if (m == 1 && n == 1) {
            return grid[0][0];
        }

        if (m == 1) {
            return grid[m - 1][n - 1] + dp(m, n - 1);
        }

        if (n == 1) {
            return grid[m - 1][n - 1] + dp(m - 1, n);
        }

        if (dp[m - 1][n - 1] == 0) {
            dp[m - 1][n - 1] = grid[m - 1][n - 1] + Math.min(dp(m - 1, n), dp(m, n - 1));
        }

        return dp[m - 1][n - 1];

    }

}