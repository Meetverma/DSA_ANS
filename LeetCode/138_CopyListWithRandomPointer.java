/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/* 

2 passes approach used:-

pass i.  make a copy if the nodes and store in hashmap by making the original node as key

pass ii. join the map nodes upon traversing the head node and similarly assign the random node to new copy node
return the new deep copy Linked list created in the hashMap 
Time Complexity: O(n);

*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node temp;
        // Node copyhead = new Node(0);
        temp = head;
        while(temp!=null){
            // copyhead.next  = new Node(temp.val);
            map.put(temp,new Node(temp.val));
            temp= temp.next;
        }
        temp = head;

        while(temp!=null){
            Node copyhead = map.get(temp);//
            copyhead.next = map.get(temp.next);
            copyhead.random = map.get(temp.random);
            temp=temp.next;
        }
    return map.get(head);
    }
}
