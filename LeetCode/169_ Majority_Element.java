//Time Comlexity: O(n log(n) );

class Solution {

    private void sort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int pivot = arr[(low + high) / 2];


        int i = low, j = high;
        while (i <= j) {
            while(arr[i] < pivot)
                i++;
            while(arr[j] > pivot)
                j--;
            if(i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            sort(arr, low, j);
        if (high > i)
            sort(arr, i, high);
    }
    public void quickSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        sort(arr, 0, arr.length - 1);
    }


    public int majorityElement(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        quickSort(nums);
        return nums[nums.length/2];

        
    }
}
