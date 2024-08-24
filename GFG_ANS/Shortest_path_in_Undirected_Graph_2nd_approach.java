class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            lst.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            lst.get(edges[i][0]).add(edges[i][1]);
            lst.get(edges[i][1]).add(edges[i][0]); //undirected graph !!
        }
        
        boolean visited[] = new boolean[n];
        visited[src] = true;
        int []dist = new int[n];
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        
        Queue<int []> queue = new LinkedList<>(); // node, dist
        queue.add(new int[] {src,0});
        dist[src] = 0;
        
        while(!queue.isEmpty()){
            int temp[] = queue.poll();
            int node = temp[0];
            int distance = temp[1];
            
            for(int nb: lst.get(node)){
                if(!visited[nb]){
                    visited[nb] = true;
                    dist[nb] = distance + 1;
                    queue.add(new int[]{nb,distance+1});
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        
 return dist;
 }
}
