// The idea is that since we know that topological sort dosen't work for cyclic graphs therefore we run a topo sort for the grpah and check if the elements after the sort is 
// completed is equal to the number of elements in the graph then there's no cycle otherwise a cycle is detected...

// Time Complexity: O((V+E) : V=>Number of Vetices , E=>Number of Edges

class Solution {
    
    
    public boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int indeg[] = new int[V];
        
        for(int i = 0;i< adj.size();i++){
            for(int cur:adj.get(i)){
                indeg[cur]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int ele=0;
        
        for(int i =0;i<V;i++){
            if(indeg[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ele++;
            for(int x: adj.get(cur)){
                indeg[x]--;
                if(indeg[x]==0)
                    queue.add(x);
            }
        }
        // if(ele == V)
        //     return false;
        // return true;
        return ele!=V;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        return topoSort(V,adj);
    }
}
