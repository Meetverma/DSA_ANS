// Time Complexity: O(m+n)
// Space Complexity: O(m+n)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                ans.add(nums1[i++]);
            } else {
                ans.add(nums2[j++]);
            }
        }

        while (i < m) {
            ans.add(nums1[i++]);
        }

        while (j < n) {
            ans.add(nums2[j++]);
        }

        for (int s = 0; s < ans.size(); s++) {
            nums1[s] = ans.get(s);
        }
    }
}
