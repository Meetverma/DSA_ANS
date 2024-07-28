//Time Complexity: O(M * N)
//Space Complexity: O(M * N)

class Solution {

    public void bfs(int image[][], int sr, int sc, int color, int initColor,boolean visited[][]) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr,sc});
        visited[sr][sc] = true;
        int[] rowDirection = { -1, 1, 0, 0 };
        int[] colDirection = { 0, 0, -1, 1 };

        while(!queue.isEmpty()){
            int current[] = queue.poll();
            image[current[0]][current[1]] = color;
            for(int i=0;i<4;i++){
                int row = current[0] + rowDirection[i];
                int col = current[1] + colDirection[i];
                if(row<image.length && row>=0 && col<image[0].length && col>=0 && !visited[row][col] && image[row][col]==initColor){
                    image[row][col] = color;
                    queue.add(new int[]{row,col});
                    visited[row][col] = true;
                }
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int initColor = image[sr][sc];
        boolean visited[][] = new boolean[image.length][image[0].length]; //false

        bfs(image, sr, sc, color, initColor,visited);

        return image;
    }
}
