// Time Complexity:O(M*N)
// Space Complexity:O(M*N)

class Solution {
    public int helper(int i, int j, int grid[][], int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (grid[i][j] == 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = helper(i - 1, j, grid, dp);
        int left = helper(i, j - 1, grid, dp);
        dp[i][j] = up + left;

        return up + left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(m - 1, n - 1, obstacleGrid, dp);
    }
}
