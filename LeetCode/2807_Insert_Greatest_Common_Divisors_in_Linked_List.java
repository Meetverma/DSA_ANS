// TIme Complexity: O(N)
// Space Complexit: O(1)

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
    private int gcd(int a,int b){
        int temp = 0,gcd = 0;
        while(b!=0){
            temp = b;
            b=a%b;
            a = temp;
        }
        gcd = a;
        return gcd;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode second ;
        ListNode first = head;
        ListNode third = first.next;
        
        while(third!=null){
            second = new ListNode(0);
            second.val = gcd(first.val,third.val);
            // connect second node
            second.next = third;
            first.next = second;
            
            first= third;
            third = third.next;
        }
        return head;
    }
}
