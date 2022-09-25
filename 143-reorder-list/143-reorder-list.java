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

    public void reorderList(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        ListNode midRev = reverseLst(slowPtr);
        ListNode res = new ListNode();
        ListNode temp = res;
        while (head != null && midRev != null) {
            temp.next = head;
            head = head.next;
            if (temp.next != midRev) {
                temp.next.next = midRev;
            }
            midRev = midRev.next;
            temp = temp.next.next;
        }

        System.out.print(res.next);
    }

    private ListNode reverseLst(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
