//Time Complexity: O(Nodes);
//Space Complexity: O(Nodes or Height); //recurssion stack

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
    int freq[] ;
    int count = 0;
    public void dfs(TreeNode node){
        // int odd = 0;

        if(node== null)
            return ;
    
    freq[node.val]++;

        if(node.left == null && node.right== null){
            if(isPalin())
                count++;
        }
        dfs(node.left);
        dfs(node.right);
        freq[node.val]--;
    }
    public boolean isPalin(){
        int ans=0;
        for(int i =1;i<10;i++){
            if(freq[i]%2 == 1){
                ans++;
            }
        }
        if(ans>1)
            return false;
        return true;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        freq= new int[10];
        dfs(root);
        return count;
    }
}
