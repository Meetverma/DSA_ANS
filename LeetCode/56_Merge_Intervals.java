// Time Complexity: O(M)
// Space Complexity: O(M*N)
class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int []> ans = new ArrayList<>();

        int cur[] = intervals[0];

        for(int i=1;i < intervals.length ;i++){
            if(cur[1] >= intervals[i][0]){
                cur[1] = Math.max(cur[1],intervals[i][1]);
            }
            else{
                ans.add(cur);
                cur = intervals[i];
            }
        }
        ans.add(cur);
        return ans.toArray(new int[ans.size()][]);
    }
}
