/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        int extraNode = cnt % k;
        int minNode = cnt / k;

        temp = head;
        ListNode res[] = new ListNode[k];

        for (int i = 0; i < k; i++) {
            ListNode parthead = temp;
            ListNode prev = null;

            int curSize = minNode + (extraNode > 0 ? 1 : 0 );
            extraNode--;

            for(int j=0;j<curSize;j++){
                prev = temp;
                temp= temp.next;
            }
            if(prev != null){
                prev.next = null;
            }
            res[i] = parthead;
        }
    return res;
    }
}
