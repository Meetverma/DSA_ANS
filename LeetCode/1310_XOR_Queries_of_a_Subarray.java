// Time Complexity: O(N*Q)
// Space Complexity: O(N)

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int answer[] = new int[queries.length];
        Arrays.fill(answer,0);

        for(int i=0;i<queries.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            int temp=0;

            for(int j=left;j<=right;j++){
                temp = arr[j] ^ temp;
            }
        answer[i] = temp;
        }
    return answer;
    }
}
