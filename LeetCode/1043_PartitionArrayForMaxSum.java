//method : DP using memoization
// TIme complexity: O(n*k) ;


class Solution {
    public int solve(int idx,int arr[],int k,HashMap <Integer,Integer> map){
        if(idx == arr.length) return 0;
        if(map.containsKey(idx))
            return map.get(idx);
        int cur_max=Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        int sub_len = 0;
        
        for(int j=idx;j<Math.min( idx+k,arr.length );j++){
            sub_len++;
            cur_max = Math.max(cur_max,arr[j]);
            sum = (sub_len*cur_max)+solve(j+1,arr,k,map);
            ans = Math.max(ans,sum);
        }
        map.put(idx,ans);
        return ans;
        }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        return solve(0,arr,k,map);
    }
}
