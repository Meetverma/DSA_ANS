// Time Complexity: O(N^3)
// Space Complexity: O(N^2) : N=>Length of string

class Solution {
    public int helper(int l, int r, String s,int dp[][]) {
        if (l > r) 
            return 0;
        if (l == r) 
            return 1;
        if(dp[l][r]!=-1)
            return dp[l][r];
        int i = l + 1;
        
        while (i <= r && s.charAt(l) == s.charAt(i) ) { 
            i++;
        }
        if (i == r+1) 
            return 1;

        int a = 1 + helper(i, r, s,dp);

        int b = Integer.MAX_VALUE;

        for (int j = i; j <= r; j++) {
            if (s.charAt(j) == s.charAt(l)) {
                int temp = helper(i, j - 1, s,dp) + helper(j, r, s,dp);
                b = Math.min(b,temp);
            }
        }
        dp[l][r] = Math.min(a,b);
        return dp[l][r];
    }

    public int strangePrinter(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0, s.length() - 1, s,dp);
    }
}
