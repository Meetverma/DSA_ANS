// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> lst = new ArrayList<>();

        for(String str: arr){
            if(!map.containsKey(str)){
                map.put(str,1);
                lst.add(str);
            }
            else{
                map.put(str,map.get(str)+1);
                lst.remove(str);
            }
        }
    if(lst.size() >= k)
        return lst.get(k-1);

    return new String(""); 
    }
}
