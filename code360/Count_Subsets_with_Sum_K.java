import java.util.*;
import java.io.*;

public class Solution {

    private static int numberOfWays(int idx, int target, int n, int[] num, int[][] dp) {
        if (target < 0) {
            return 0;
        }
        if (idx == n) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        //take
        int ans = numberOfWays(idx + 1, target - num[idx], n, num, dp);
        //not take
        ans = (ans + numberOfWays(idx + 1, target, n, num, dp));


        dp[idx][target] = ans % 1000000007;
        return dp[idx][target];
    }

    public static int findWays(int num[], int tar) {

        int n = num.length;
        int dp[][] = new int[n][tar + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }
        return numberOfWays(0, tar, n, num, dp);
    }
}

