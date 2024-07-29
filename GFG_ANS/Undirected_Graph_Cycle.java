//Time Complexity: O(V + E)->BFS
//Space Complexity: O(N) 

class Pair<U, V> {
    private U key;
    private V value;

    public Pair(U key, V value) {
        this.key = key;
        this.value = value;
    }

    public U getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    
    public boolean hasCycle(int V,ArrayList<ArrayList<Integer>> adj,boolean visited[],int node){
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(new Pair<>(node,-1));// node & where it came from...
        
        while(!queue.isEmpty()){
            Pair<Integer,Integer> p = queue.poll();
            
            int curNode = p.getKey();
            int itsParent = p.getValue();
            for(int currentAdj: adj.get(curNode)){
                if(visited[currentAdj]==false){
                    queue.add(new Pair(currentAdj,curNode));
                    visited[currentAdj] = true;
                }
                else if(itsParent != currentAdj){
                    return true;
                }
            }
        }
        return false;
        
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited,false);
        
        for(int i=0;i<V;i++){
            if(!visited[i] && hasCycle(V,adj,visited,i) ) return true;
        }
        return false;
    }
}
