// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] temp = arr.clone();

        Arrays.sort(temp);
        int j =1;
        for(int i=0;i<temp.length;i++){
            if(!map.containsKey(temp[i])){
                map.put(temp[i],j++);
            }
        }

        for(int i=0;i<arr.length;i++){
            int val = map.get(arr[i]);
            temp[i] = val;
        }
        return temp;
    }
}
