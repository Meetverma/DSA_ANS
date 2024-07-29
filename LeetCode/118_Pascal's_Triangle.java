// Time Complexity: O(n^2);
//Spcae Complexity: O(N)

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);

        for(int i=1;i<numRows;i++){
            List<Integer> curList = new ArrayList<>();
            List<Integer> prevList = ans.get(i-1);
            curList.add(1);
            for(int j=1;j<i;j++){
                curList.add(prevList.get(j)+prevList.get(j-1));
            }
            curList.add(1);
            ans.add(curList);
        }
        return ans;
    }
}
