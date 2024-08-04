// Space complexity: O(V + E)
// Time complexity: O(N)

class Solution {
    public boolean helper(int[][] graph,int start,int visited[]) {
       
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start); //0 based indexing 
        visited[start] = 0;
        while(!queue.isEmpty()){
            int ele = queue.poll();
            for(int adj: graph[ele]){
                if(visited[adj] == -1){
                    visited[adj] = 1 - visited[ele];
                    queue.add(adj);
                }
                else if(visited[adj] == visited[ele]){
                    return false;
                }
            }
        }
    return true;
    }
    public boolean isBipartite(int graph[][]){
        int visited[] = new int[graph.length];
        Arrays.fill(visited,-1);
        
        for(int i=0;i<graph.length;i++){
            if(visited[i]==-1){
                if(!helper(graph,i, visited)){
                    return false;
                }
            }
        }
        return true;

    }
}
