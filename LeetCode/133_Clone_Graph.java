/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;

        Map<Node,Node> map = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        
        //making a root's clone
        Node rootClone = new Node(node.val);
        map.put(node,rootClone); // setting the original node to clone in map 
        que.add(node);
        //start bfs;

        while(!que.isEmpty()){
            Node currentNode = que.poll();

            for(Node neighbor: currentNode.neighbors){
                if(!map.containsKey(neighbor)){
                    Node temp = new Node(neighbor.val);
                    map.put(neighbor,temp);
                    que.add(neighbor);
                }
                map.get(currentNode).neighbors.add(map.get(neighbor));
            }
        }
    return rootClone;
    }

}
