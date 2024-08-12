// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	public static int helper(int idx, ArrayList<Integer> arr,int dp[]){
		if(idx == 0){
			return arr.get(0);
		}
		if(idx<0)
			return 0;
		if(dp[idx]!=-1)
			return dp[idx];
			
		int pick = arr.get(idx) + helper(idx-2,arr,dp);
		int npick = helper(idx-1,arr,dp);

		int maxi = Math.max(pick,npick);
		dp[idx] = maxi;
		return maxi;
 	}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int dp[] = new int[nums.size()];
		Arrays.fill(dp,-1);
		return helper(nums.size()-1,nums,dp);
	}
}
