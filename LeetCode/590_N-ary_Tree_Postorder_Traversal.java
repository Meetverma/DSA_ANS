// Time Complexity: O(N)
// Space Complexity: O(N)

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> lst = new ArrayList<>();
        if(root == null ){
            return lst;
        }
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            Node temp = stk.pop();
            lst.addFirst(temp.val);

            for(Node child: temp.children){
                if(child!=null){
                    stk.add(child);
                }
            }
        }

    return lst;
    }
}
