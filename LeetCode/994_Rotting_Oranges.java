// Time Complexity: O( n*m )
// Space Complexity: O( n*m )

class Solution {
    public int orangesRotting(int[][] grid) {
        // if (grid.length == 1 && grid[0].length == 1)
        //     return 0;

        int n = grid.length;
        int m = grid[0].length;

        int visited[][] = new int[n][m]; // i,j,time
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    // Rotten oranges
                    visited[i][j] = 2;
                    queue.add(new int[] { i, j, 0 });
                } else if (grid[i][j] == 1) {
                    // Fresh oranges
                    fresh++;
                    visited[i][j] = 1;
                } else if (grid[i][j] == 0) {
                    visited[i][j] = 0; // Empty cell
                }
            }
        }

        int xRow[] = { -1, 0, 1, 0 }; // Up, right, down, left
        int yCol[] = { 0, 1, 0, -1 };
        int max_time = 0;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int current_tomato[] = queue.poll();
            int row = current_tomato[0]; // Row
            int col = current_tomato[1]; // Col
            int time = current_tomato[2];

            max_time = Integer.max(time, max_time);

            for (int i = 0; i < 4; i++) {
                int new_r = row + xRow[i];
                int new_c = col + yCol[i];
                if (new_r >= 0 && new_r < n && new_c >= 0 && new_c < m && grid[new_r][new_c] == 1 && visited[new_r][new_c]==1) {
                    queue.add(new int[] { new_r, new_c, time + 1 });
                    visited[new_r][new_c] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != fresh)
            return -1;
        else
            return max_time;
    }
}
