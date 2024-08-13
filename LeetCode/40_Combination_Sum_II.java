// Time Complexity: O(2^N)
// Space Complexity: O(N)

class Solution {
    List<List<Integer>> lst = new ArrayList<>();

    public void helper(int []candidates,int target,int idx,List<Integer> temp){
        if(target == 0){
            lst.add(new ArrayList<>(temp));
            return ;
        }
        if(idx >= candidates.length || target<0)
            return;
        
        temp.add(candidates[idx]);
        helper(candidates,target-candidates[idx],idx+1,temp);
        
        temp.remove(temp.size()-1); //remove the last added element from the list and backtrack
        while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) {
            idx++; //to get to the index where next index doesnt contain same element which we removed;
        }

        helper(candidates,target,idx+1,temp);//not pick
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> ans = new ArrayList<>();
        helper(candidates,target,0,ans);
        return lst;

    }

}
