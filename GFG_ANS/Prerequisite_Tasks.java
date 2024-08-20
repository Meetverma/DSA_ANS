// Time Complexity: O(N^2)
// Space Complexity: O(N^2)

class Solution {
    public boolean topo(int N,int P,int [][]arr,ArrayList<ArrayList<Integer>> lst){
        int indeg[] = new int[N];
        Arrays.fill(indeg,0);
        
        for(int i=0;i<N;i++){
            for(int x: lst.get(i)){
                indeg[x]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for(int i =0; i<N;i++){
            if(indeg[i] == 0)
                queue.add(i);
        }
        
        int ele=0;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ele++;

            for(int x: lst.get(cur)){
                indeg[x]--;
                if(indeg[x]==0){
                    queue.add(x);
                }
            }
        }
        return ele==N;
    }
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        
        for(int i =0;i<N;i++){
            lst.add(new ArrayList<>());
        }
        for(int i =0;i<P;i++){
            lst.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        return topo(N,P,prerequisites,lst);
    }
    
    }
