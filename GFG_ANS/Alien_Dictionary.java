class Solution
{
    public ArrayList<Integer> topo(int k, ArrayList<ArrayList<Integer>> lst){
        int inDegree[] = new int[k];
        Arrays.fill(inDegree,0);
        for(int i = 0; i < k; i++){
            for(int node: lst.get(i)){
                inDegree[node]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < k; i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for(int adj: lst.get(node)){
                inDegree[adj]--;
                if(inDegree[adj] == 0)
                    queue.add(adj);
            }
        }
        
        
        for(int i = 0; i < k; i++){
            if(!ans.contains(i)){
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    public String findOrder(String[] dict, int N, int K)
    {
        
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        
        for(int i = 0; i < K; i++){
            lst.add(new ArrayList<>());
        }
        
        
        for(int j = 0; j < N-1; j++){
            String s1 = dict[j];
            String s2 = dict[j+1];
            
            for(int i = 0; i < Math.min(s1.length(), s2.length()); i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    lst.get(s1.charAt(i)-'a').add(s2.charAt(i)-'a');
                    break;
                }
            }
        }
        
        
        ArrayList<Integer> ans = topo(K, lst);
        String res = "";
        
        
        for(int str: ans){
            char c = (char)('a' + str);
            res += c;
        }
        
        return res;
    }
}
