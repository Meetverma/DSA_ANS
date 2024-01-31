class Solution {
    public int[] dailyTemperatures(int[] temperature) {
        int n = temperature.length;
        Stack <Integer> stk= new Stack<>();
        int ans[] = new int[n];
        for(int i =0;i<n;i++){
            while(!stk.isEmpty() && temperature[i] > temperature[stk.peek()]){
                int idx = stk.pop();
                ans[idx] = i - idx;
            }
                stk.push(i);
        }
        return ans;
    }
}
