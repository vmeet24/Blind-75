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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fistPtr = dummy;
        ListNode secondPtr = dummy;
        
        for(int i=0; i<n;i++){
            fistPtr = fistPtr.next;
        }
        
        while(fistPtr.next!=null){
            fistPtr = fistPtr.next;
            secondPtr = secondPtr.next;
        }
        secondPtr.next = secondPtr.next.next;
        return dummy.next;
    }
}
