// Time Complexity: O(N)
// Space Complexity: O(M) : M is nums size

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums){
            set.add(ele);
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        ListNode cur = head;

        while(cur!=null){
            if(set.contains(cur.val)){
                prev.next = cur.next;
            }
            else{
                prev = cur;
            }
            cur = cur.next;
        }
    return temp.next;

    }
}   
