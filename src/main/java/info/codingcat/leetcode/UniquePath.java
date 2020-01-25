package info.codingcat.leetcode;

/**
 * UniquePath
 */
public class UniquePath {

    public static void main(String[] args) {
        UniquePath p = new UniquePath();
        System.out.println(p.uniquePaths(1, 1));
    }

    private int[][] dp;

    public int uniquePaths(int m, int n) {

        dp = new int[m][n];

        return dp(m, n);

    }

    private int dp(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        if (dp[m - 1][n - 1] == 0) {
            dp[m - 1][n - 1] = dp(m - 1, n) + dp(m, n - 1);
        }

        return dp[m - 1][n - 1];

    }

}