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
    

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode answer = new ListNode(0);
        ListNode cur = answer;
        int carry = 0;

        while(l1!=null || l2!=null ){
            int temp1 = (l1!=null) ? l1.val:0;
            int temp2= (l2!=null) ? l2.val:0;

            int sum = temp1 + temp2 + carry ;
            carry = sum/10;     // get the msb 
            cur.next = new ListNode(sum%10); //get the lsb 
            // ListNode temp 
            // cur.next = temp;
            // cur.val= carry ;

            if(l1!= null)   l1=l1.next;
            if(l2!= null)   l2=l2.next;
            cur = cur.next;
        }
    if (carry > 0) {
        cur.next = new ListNode(carry);
    }
    return answer.next;
    }

}
