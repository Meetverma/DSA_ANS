// Time Complexity: O(N*k)
// Space Complexity: O(N*K)

import java.util.* ;
import java.io.*; 
public class Solution {
    private static boolean helper(int idx,int target,int arr[],HashMap<String,Boolean> map){
        if(target == 0 || arr[idx]==target){
            return true;
        }
        if(target<0){
            return false;
        }
        if(idx == arr.length-1){
            return false;
        }
        if(map.containsKey(""+idx+","+target)){
            return map.get(""+idx+","+target);
        }
        boolean temp = false;
        temp |= helper(idx+1,target-arr[idx],arr,map);
        temp |= helper(idx+1,target,arr,map);
        
        map.put(""+idx+","+target,temp);
        return temp;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        HashMap<String,Boolean> map = new HashMap<>();

        return helper(0,k,arr,map);
    }
}
