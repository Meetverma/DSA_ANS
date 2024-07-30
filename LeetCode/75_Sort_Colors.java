// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public void sortColors(int[] nums) {
        int arr[] = new int[3];
        for(int ele: nums){
            arr[ele]++;
        }
int x = 0;
    for(int i=0;i<3;i++){
        int num_times = arr[i];
        for(int j =0;j<num_times;j++){
            nums[x++] = i;
        }
    }

    }
}
