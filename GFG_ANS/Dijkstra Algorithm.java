
class Solution
{
    static class Pair{
        int node;
        int dist;
        Pair(int node ,int dist) {
            this.node = node ;
            this.dist = dist ;
        }
        public int getNode(){
            return this.node;
        }
        public int getDist(){
            return this.dist;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int dist[] = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[S] = 0;
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->(Integer.compare(a.node,b.node)));
        queue.add(new Pair(S,0));
        
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int cur = temp.getNode();
            int curDist = temp.getDist();
            
            for(int i=0;i<adj.get(cur).size();i++){
                int nextNode = adj.get(cur).get(i).get(0);
                int nextNodeDist = adj.get(cur).get(i).get(1);
                
                if(curDist + nextNodeDist < dist[nextNode]){
                    dist[nextNode] = curDist + nextNodeDist;
                    queue.add(new Pair(nextNode,dist[nextNode]));
                }
            }
        }
    return dist;
    }
}
