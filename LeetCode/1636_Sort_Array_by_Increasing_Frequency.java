class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        //sorting on value or number of occurances of each element
        List<Map.Entry<Integer,Integer>> lst = new ArrayList<>(map.entrySet());
        lst.sort((a,b) -> {
            int cmp = a.getValue().compareTo(b.getValue());
            if(cmp == 0 ){
                return b.getKey().compareTo(a.getKey());
            }
            return cmp;
        });

        int ans[] = new int[nums.length];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : lst) {
            int key = entry.getKey();
            int times = entry.getValue();
            for (int i = 0; i < times; i++) {
                ans[idx++] = key;
            }
    }
    return ans;
    }
}
