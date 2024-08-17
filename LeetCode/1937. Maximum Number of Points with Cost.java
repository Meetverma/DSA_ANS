// Time Complexity: O(M*N^2)
// Space Complexity: O(N)

class Solution {
    public long maxPoints(int[][] points) {
        int r = points.length;
        int c = points[0].length;

        long[] dp = new long[c];
        for (int i = 0; i < c; i++) {
            dp[i] = points[0][i];
        }

        for (int i = 1; i < r; i++) {
            long[] leftMax = new long[c];
            long[] rightMax = new long[c];
            long[] newDp = new long[c];

            leftMax[0] = dp[0];
            for (int j = 1; j < c; j++) {
                leftMax[j] = Math.max(leftMax[j - 1], dp[j] + j);
            }

            rightMax[c - 1] = dp[c - 1] - (c - 1);
            for (int j = c - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1], dp[j] - j);
            }

            for (int j = 0; j < c; j++) {
                newDp[j] = points[i][j] + Math.max(leftMax[j] - j, rightMax[j] + j);
            }
            dp = newDp;
        }

        long maxPoints = Long.MIN_VALUE;
        for (long value : dp) {
            maxPoints = Math.max(maxPoints, value);
        }

        return maxPoints;
    }
}
