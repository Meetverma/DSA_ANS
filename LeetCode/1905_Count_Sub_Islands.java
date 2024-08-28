// Time Complexity: O(M*N)
// Space Complexity: O(M*N)

class Solution {
    private boolean helper(int grid[][],int r,int c,int visited[][],int grid1[][] ){
        int ROW = grid.length;
        int COL = grid[0].length;
        boolean ans = true;

        Queue<int[]> queue = new LinkedList<>();
        
        visited[r][c]=1;

        queue.add(new int[]{r,c});
        int xDir[] ={1,0,-1,0};
        int yDir[] = {0,1,0,-1};

        while(!queue.isEmpty()){
            int temp[] = queue.poll();
            int row = temp[0];
            int col = temp[1];

            for(int i=0;i<4;i++){
                int nr = row + xDir[i];
                int nc = col + yDir[i];
                if(nr<ROW && nr>=0 && nc<COL && nc>=0 && grid[nr][nc]==1 && visited[nr][nc]!=1){
                    visited[nr][nc] = 1;
                    if(grid1[nr][nc]!=1){
                        ans = false;
                    }
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        return ans;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ROW = grid1.length;
        int COL = grid1[0].length;
        int cnt = 0;
        int visited[][] = new int[ROW][COL];

        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                if(grid1[i][j]==1 && grid2[i][j]==1 && visited[i][j]==0 ){
                    if(helper(grid2,i,j,visited,grid1)){
                        cnt++;
                    }
                }
            }
        }
    return cnt;
    }
}
