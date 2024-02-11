// for explanation: Youtube:NeetCode.io

class Solution {
     Integer memo[][][];
    
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        memo = new Integer[rows+1][cols+1][cols+1];
        return ans(grid, 0, 0, cols-1);
    }
    
    public int ans(int[][] grid, int r, int c1, int c2) {
        
        if(c1 < 0 || c2 < 0 || c1 >= grid[0].length || c2 >= grid[0].length) return 0;
        
        if(r == grid.length) return 0;
        
        if(memo[r][c1][c2] != null)
            return memo[r][c1][c2];
        
        int result = 0;
        result += grid[r][c1];
        result += grid[r][c2];
        
        int max = 0;
        for(int i=c1-1;i<=c1+1;i++) {
            for(int j=c2-1;j<=c2+1;j++) {
                if(i < j) 
                    max = Math.max(max, ans(grid, r+1, i, j));
            }
        }
        
        result += max;
        return memo[r][c1][c2] = result;
    }
}

    
