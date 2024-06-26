// Time Complexity: O(N) using recursion (D&C)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public void inorder(TreeNode node,ArrayList<Integer> arr){
        if(node == null)
            return;
        inorder(node.left,arr);
        arr.add(node.val);
        inorder(node.right,arr);
    }

    public TreeNode balance(ArrayList<Integer> arr,int left,int right){
        if(left>right)
            return null;
        int mid = (left + right ) / 2 ;
        TreeNode temp = new TreeNode(arr.get(mid));

        temp.left = balance(arr,left,mid-1 );
        temp.right = balance(arr,mid+1,right);
        return temp;
    }
    public TreeNode balanceBST(TreeNode root) {
        if(root==null)
            return null;

        Solution s = new Solution();
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        s.inorder(root , arr );

        return balance(arr,0,arr.size()-1);
    }
}
