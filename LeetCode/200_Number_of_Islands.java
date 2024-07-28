//TIme Complexity: O(N*M)
//Space Complexity: O(N*M)

class Solution {

    public void bfs(char[][] grid, int l, int b, boolean[][] visited) {
        int[] rowDirections = { -1, 1, 0, 0 };
        int[] colDirections = { 0, 0, -1, 1 };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { l, b });
        visited[l][b] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row = current[0] + rowDirections[i];
                int col = current[1] + colDirections[i];
                if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1'
                        && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new int[] { row, col });
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
}


