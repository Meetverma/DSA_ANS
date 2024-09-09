// Dijkastra's algorithm

class Solution {
    static class Pair{
        int r;
        int c;
        int dist;
        Pair(int r,int c,int dist){
            this.r = r;
            this.c = c;
            this.dist= dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int xDir[] ={-1,0,1,0}; // up,right,down,left
        int yDir[] ={0,1,0,-1};
        int dist[][] = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> queue= new PriorityQueue<>((a,b)-> a.dist-b.dist );
        dist[0][0] = 0;

        queue.add(new Pair(0,0,0));
        
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int r = temp.r;
            int c = temp.c;
            int curDist = temp.dist;

            for(int i=0;i<4;i++){
                int nr = r + xDir[i];
                int nc = c + yDir[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int maxDist = Math.max(Math.abs(heights[nr][nc]-heights[r][c]),curDist);
                    if(maxDist<dist[nr][nc]){
                        dist[nr][nc] = maxDist; 
                        queue.add(new Pair(nr,nc,maxDist));
                    }
                }
            }
        }
    return dist[m-1][n-1];
    }
}
