// Time Complexity: O(V + E) V:vertex and E:edge
// Spcae Complexity: O(N*M)

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        int visited[][] = new int[r][c];
        int distance[][] = new int[r][c];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j] == 0){
                    visited[i][j] = 1;
                    queue.add(new int[]{i,j,0});
                }
            }
        }

    int xDir[] = {-1,0,1,0};
    int yDir[] = {0,1,0,-1};

    while(!queue.isEmpty()){
        int cur[] = queue.poll();
        int row = cur[0];
        int col = cur[1];
        int zeroDist = cur[2];

        distance[row][col] = zeroDist;

        for(int i=0;i<4;i++){
            int nr = row + xDir[i];
            int nc = col + yDir[i];

            if(nr>=0 && nr<r && nc>=0 && nc<c && visited[nr][nc]==0){
                queue.add(new int[]{nr,nc,zeroDist+1});
                visited[nr][nc] =1;
            }
        }

        }
    return distance;
    }
}
