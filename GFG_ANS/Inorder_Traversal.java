class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        res.addAll(inOrder(root.left));
        res.add(root.data);
        res.addAll(inOrder(root.right));
        return res;
    }
}
