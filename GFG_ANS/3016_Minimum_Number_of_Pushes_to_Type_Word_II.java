// Time Complexity: O(N)
// Spcae Complexity: O(1)

class Solution {
    public int minimumPushes(String word) {
        Integer arr[] = new Integer[26];
        Arrays.fill(arr,0);
        
        for(int i=0;i<word.length();i++){
            arr[word.charAt(i)-'a']++;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int ans = 0,dist=0;
        for(int cnt: arr ){
            ans+= cnt * (1+ dist / 8);
            dist++;
        }
        return ans;
    }
}
