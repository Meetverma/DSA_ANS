// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> lst = new ArrayList<>();

        int last = 0;
        int mod = 1000000007;

        for(int i=0;i<n;i++){
            last =(last + nums[i]) % mod;
            lst.add(last);
            for(int j=i+1;j<n;j++){
                last = (last + nums[j]) % mod;
                lst.add(last);
            }
            last=0;
        }
        int sum = 0;
        Collections.sort(lst);
        for(int i=left-1;i<right;i++)
            sum= (sum + lst.get(i)) % mod ;
        return sum;
    }
}
