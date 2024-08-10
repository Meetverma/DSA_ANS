// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int helper(int i, int height[] , int n, int dp[]){
        if(i >= n-1)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        
        int x = helper(i+1,height,n,dp) + Math.abs(height[i]-height[i+1]) ;
        int y = Integer.MAX_VALUE;
        if(i+2 < n)
            y = helper(i+2,height,n,dp) + Math.abs(height[i]-height[i+2]) ; 
        
        return dp[i] = Math.min(x,y);
            
    }
    public static int frogJump(int n, int heights[]) {
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        return helper(0,heights,n,dp);
    }

}
