// Time Complexity: O(N log(n))
class Solution {
    //hashmap solution 
    public String[] sortPeople(String[] names, int[] heights) {

        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());

        for(int i =0;i<heights.length;i++){
            map.put(heights[i],names[i]);
        }
        
        String ans [] = new String [names.length];

        List<Integer> keys = new ArrayList<>(map.keySet());



        for(int i=0;i<names.length;i++){
            Integer keyAtIndex = keys.get(i);
            String valueAtKey = map.get(keyAtIndex);
            ans[i] = new String(valueAtKey);
        }
    return ans;
    }

}
