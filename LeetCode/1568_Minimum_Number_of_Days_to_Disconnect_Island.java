class Solution {

    public void bfs(int grid[][], int i, int j, int visited[][]) {
        int r = grid.length;
        int c = grid[0].length;

        int[] rDir = {1, 0, -1, 0}; //down, right, up, left
        int[] cDir = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = 1;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] idx = queue.poll();
            for (int ptr = 0; ptr < 4; ptr++) {
                int x = idx[0] + rDir[ptr];
                int y = idx[1] + cDir[ptr];

                if (x >= 0 && x < r && y >= 0 && y < c && grid[x][y] == 1 && visited[x][y] == -1) {
                    visited[x][y] = 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }

    public int minDays(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] visited = new int[r][c];


        for (int i = 0; i < r; i++) {
            Arrays.fill(visited[i], -1);
        }

        int islands = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && visited[i][j] == -1) {
                    bfs(grid, i, j, visited);
                    islands++;
                }
            }
        }

        if (islands != 1) {
            return 0;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;  

                    for (int x = 0; x < r; x++) {
                        Arrays.fill(visited[x], -1);
                    }

                    islands = 0;
                    for (int x = 0; x < r; x++) {
                        for (int y = 0; y < c; y++) {
                            if (grid[x][y] == 1 && visited[x][y] == -1) {
                                bfs(grid, x, y, visited);
                                islands++;
                            }
                        }
                    }

                    grid[i][j] = 1;  

                    if (islands != 1) {
                        return 1;  
                    }
                }
            }
        }

        return 2;// base case
    }
}
