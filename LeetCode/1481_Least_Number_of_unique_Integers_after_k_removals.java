import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int a = map.getOrDefault(arr[i],0);
            map.put(arr[i],a+1);
        }

    List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> a.getValue().compareTo(b.getValue()));

        for (Entry<Integer, Integer> entry : list) {
            int count = entry.getValue();
            if (k >= count) {
                k -= count;
            } else {
                return list.size() - list.indexOf(entry);
            }
        }
        return 0;
    }
}
