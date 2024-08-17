// Time Complexity: O(m*n^2)
// Space Complexity: O(M*N)

class Solution {
    public long helper(int r, int[][] points,int col , long[][] dp) {
        if (r >= points.length) {
            return 0;
        }
        if( col!=-1 && dp[r][col]!=-1 ){
            return dp[r][col];
        }

        long maxi = Long.MIN_VALUE;
        for (int c = 0; c < points[0].length; c++) {
            long currentPoints = points[r][c];
            if (col != -1) {
                currentPoints -= Math.abs(c - col);
            }
            maxi = Math.max(maxi, currentPoints + helper(r + 1, points, c, dp));
        }
        if(col!=-1)
            dp[r][col] = maxi;

        return maxi;
    }

    public long maxPoints(int[][] points) {
        int r = points.length;
        int c = points[0].length;

        long dp[][] = new long[r][c];
        for(int i=0;i<r;i++)
            Arrays.fill(dp[i],-1);

        return helper(0,points,-1,dp);

    }
}
