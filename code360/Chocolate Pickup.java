import java.util.* ;
import java.io.*; 
public class Solution {
	private static int helper(int [][]grid,int i ,int j1,int j2,int dp[][][]){
		int n = grid.length;
		int m = grid[0].length;
		if(j1<0 || j1>=m || j2<0 || j2>=m){
			return -99999;
		}
		if(i == n-1){
			if(j1==j2){
				return grid[i][j1];
			}
			return grid[i][j1] + grid[i][j2];
		}
		
		if(dp[i][j1][j2]!= -1 ){
			return dp[i][j1][j2];
		}
		int yDir[]={-1,0,1};
		int maxi=0;
		for(int x: yDir){ int new_j1 = j1+x;
			for(int y: yDir){
				int new_j2 = j2+y;
				if( j1 == j2 ){
					maxi= Math.max( maxi,grid[i][j1] +helper(grid,i+1,new_j1,new_j2,dp));
				}
				else{
					maxi = Math.max(maxi,grid[i][j1]+grid[i][j2] +helper(grid,i+1,new_j1,new_j2,dp));
				}
			}
		}
		dp[i][j1][j2] = maxi;
	return maxi;

	}
	public static int maximumChocolates(int r, int c, int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int dp[][][] = new int[n][m][m];
		for (int[][] arr2d : dp) {
    		for (int[] arr : arr2d) {
        			Arrays.fill(arr, -1);
    			}
		}
		
		return helper(grid,0,0,m-1,dp);
	}
}
