class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        // north,east, south,west
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0; //facing north
        int r = 0, c = 0;
        int maxDistSq = 0;

        for (int command : commands) {
            if (command == -1) {
                //right
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                //left
                dir = (dir + 3) % 4;
            } else {
                for (int step = 0; step < command; step++) {
                    int newR = r + directions[dir][0];
                    int newC = c + directions[dir][1];
                    if (!obstacleSet.contains(newR + "," + newC)) {
                        r = newR;
                        c = newC;
                        maxDistSq = Math.max(maxDistSq, r * r + c * c);
                    } else {
                        break; 
                    }
                }
            }
        }
        return maxDistSq;
    }
}
