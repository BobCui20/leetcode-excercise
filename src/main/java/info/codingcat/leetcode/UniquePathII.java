package info.codingcat.leetcode;

/**
 * UniquePathII
 */
public class UniquePathII {

    private int[][] dp;

    private int[][] obstacleGrid;

    private int dp(int m, int n) {

        if (this.obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        if (m == 1 | n == 1) {
            return 1;
        }


        if (dp[m - 1][n - 1] == 0) {
            dp[m - 1][n - 1] = dp(m - 1, n) + dp(m, n - 1);
        }

        return dp[m - 1][n - 1];

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        int m = obstacleGrid.length;

        int n = obstacleGrid[0].length;

        dp = new int[m][n];

        return dp(m, n);
    }

}