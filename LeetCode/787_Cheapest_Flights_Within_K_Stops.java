// Dijkastras'
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // construct adj list
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i =0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i =0;i<flights.length;i++){ 
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            adjList.get(u).add(new int[]{v,wt});
        }

        Queue<int[]> queue = new LinkedList<>(); // stops,node,dist
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src] = 0;
        queue.add(new int[]{0,src,0});

        while(!queue.isEmpty()){
            int temp[] = queue.poll();

            int curStops = temp[0];
            int curNode = temp[1];
            int curDist = temp[2];

            if(curStops>k){
                continue;
            }
            for(int[] neighbor : adjList.get(curNode)){
                int nextNode = neighbor[0];
                int nextNodeDist = neighbor[1];

                if( (nextNodeDist+curDist) < dist[nextNode]){
                    dist[nextNode] = nextNodeDist+curDist;
                    queue.add(new int[]{ curStops+1, nextNode, dist[nextNode]});
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
    return dist[dst];
    }
}
