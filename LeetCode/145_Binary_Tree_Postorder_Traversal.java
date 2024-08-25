// Time Complexity: O(N)
// Space Complexity: O(N)

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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        if(root == null)
            return new ArrayList<Integer>();
        List<Integer> lst = new ArrayList<>();

        stk.add(root);

        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            lst.addFirst(node.val);
            if(node.left!=null){
                stk.push(node.left);
            }
            if(node.right!=null){
                stk.push(node.right);
            }
        }
        
    return lst;
    }
}
