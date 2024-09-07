class Solution {
    static class Pair{
        int r;
        int c;
        int dist;
        
        Pair(int r,int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
       }
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0){
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;        
        
        Queue<Pair> queue = new LinkedList<>();
        
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        
        dist[source[0]][source[1]] = 0;
        
        queue.add( new Pair(source[0],source[1],0 ) );
        
        int rDir[] = {1,0,-1,0}; // up,right,down,left
        int cDir[] = {0,1,0,-1};
        
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int r = temp.r;
            int c = temp.c;
            int distance = temp.dist;
            
            for(int i=0;i<4;i++){
                int nr = r+rDir[i];
                int nc = c+cDir[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && dist[nr][nc] > distance+1){
                        dist[nr][nc] = distance+1;
                        queue.add(new Pair(nr,nc,dist[nr][nc]));
                }
            }
        }
        if(dist[destination[0]][destination[1]] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[destination[0]][destination[1]];
    }
}
