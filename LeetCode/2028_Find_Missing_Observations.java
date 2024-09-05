// Time Complexity: O(6^n)
// Space Complexity: O(n)

class Solution {
    private ArrayList<Integer> findCombo(int n,int targetSum,int curSum,ArrayList<Integer> curCombo){
        if(n==0){
            if(targetSum == curSum){
                return curCombo;
            }
            return null;
        }
        if( targetSum-curSum > 6 * n || targetSum < n ){
            return null;
        }
        for(int i=1;i<=6;i++){
            if(curSum + i <= targetSum){
                curCombo.add(i);
                ArrayList<Integer> lst = findCombo(n-1,targetSum,curSum+i, curCombo);
                if(lst!=null){
                    return lst;
                }
                curCombo.remove(curCombo.size()-1); //backtrack;

            }
        }
        return null;
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        int eleCnt = 0;
        for(int i=0;i<rolls.length;i++){
            eleCnt++;
            sum+=rolls[i];
        }
        eleCnt += n; //total number of elements

        int targetSum = (mean * eleCnt) - sum;
        if(targetSum > 6*n){
            return new int[0];
        }
        ArrayList<Integer> resList = findCombo(n,targetSum,0,new ArrayList<Integer>());
        if(resList == null){
            return new int[0];
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }
}
