// Time Compelxity: O(N*M);
// Space Complexity: O(N*M);

class Solution {
    public int helper(int i, int j,int [][]dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];

        int up = helper(i - 1, j,dp);
        int left = helper(i, j - 1,dp);
        dp[i][j] = up+left;
        return up + left;
    }

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(m - 1, n - 1,dp);
    }
}
