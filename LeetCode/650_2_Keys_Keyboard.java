// Time Complexity: O(N^2)
// Space Complexity: O(N)

class Solution {
    public int helper(int n, int numberOfA,int copied, HashMap<String,Integer> map){
        if(numberOfA == n){
            return 0;
        }
        if(numberOfA > n){
            return 99999;
        }
        if(map.containsKey(""+numberOfA+","+copied)){
            return map.get(""+numberOfA+","+copied);
        }

        int copyAndPaste = 2 + helper(n,numberOfA*2,numberOfA,map); 
        int paste = 1 + helper(n,numberOfA+copied,copied,map);
        
        int res =Math.min(copyAndPaste,paste);
        
        map.put(""+numberOfA+","+copied,res);

        return res;
    }

    public int minSteps(int n) {
        if(n==1)
            return 0;
        HashMap<String,Integer> map = new HashMap<>(); // numberOfA and copied
        return 2 + helper(n,2,1,map);
    }
}
