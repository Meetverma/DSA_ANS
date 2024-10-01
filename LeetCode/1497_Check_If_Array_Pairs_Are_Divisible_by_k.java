// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<arr.length;i++){
            int r = arr[i] % k;
            if(r<0){
                r=r+k;
            }
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            int r = m.getKey();
            int cnt = m.getValue();

            if(r==0){
                if(cnt%2!=0){
                    return false;
                }
            }else{
                int temp = k-r;
                if( !map.containsKey(temp) || map.get(temp) != cnt) {
                    return false;
                }
            }
        }
    return true;
    }
}
