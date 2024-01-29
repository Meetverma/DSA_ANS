class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode n1 = new ListNode();
        ListNode temp = n1;
        int i = 0,j=0;  
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1=list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp=temp.next;
        }
        if(list1!=null){
            temp.next = list1;
            list1=list1.next;
        }
        if(list2!=null){
            temp.next= list2;
            list2=list2.next;
        }

return n1.next;

    }
}
