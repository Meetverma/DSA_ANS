class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int r = grid.length;
        int c = grid[0].length;
        
        int[][] visited = new int[r][c];
        int[][] distance = new int[r][c];
        
    Queue<int[]> queue = new LinkedList<>();
    
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(grid[i][j]==1){
                queue.add(new int[]{i,j,0});
                visited[i][j] = 1;
            }
            else{
                visited[i][j] = 0;
            }
        }
    }
    int xDir[] = {-1,0,1,0};
    int yDir[] = {0,1,0,-1};
    
    while(!queue.isEmpty()){
        int cur[] = queue.poll(); // row , col
        int curR = cur[0];
        int curC = cur[1];
        int oneDist = cur[2];
        
        distance[curR][curC] = oneDist;
        
        for(int i=0;i<xDir.length;i++){
                int new_r = xDir[i] + curR;
                int new_c = yDir[i] + curC;
                if(new_r>=0 && new_r<r && new_c>=0 && new_c<c && visited[new_r][new_c] == 0){
                    // distance[new_r][new_c] = oneDist+1;
                    visited[new_r][new_c] =1;
                    queue.add(new int[]{new_r,new_c,1+oneDist});
                }
        }
    }
    
    return distance;
    
    }
}
