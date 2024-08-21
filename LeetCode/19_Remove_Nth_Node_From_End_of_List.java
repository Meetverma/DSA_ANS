// Time Complexity: O(N)
// Space Complexity: O(N)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null ){
            ListNode temp = null;
            return temp;
        }
        
        ListNode temp = head;
        ArrayList<Integer> lst = new ArrayList<>();

        while(temp.next!=null){
            lst.add(temp.val);
            temp=temp.next;
        }
        lst.add(temp.val);
        
        int len = lst.size();

        lst.remove(len-n);

        ListNode ans = new ListNode();
        ListNode temp2 = ans;

        for(int i=0;i<len-1;i++){
            ans.val = lst.get(i);
            if(i < len-2){
            ans.next = new ListNode();
            ans=ans.next;
            }
        }

    return temp2;
    }
}
