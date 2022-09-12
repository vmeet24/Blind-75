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
        int carry = 0;
        ListNode l3 = new ListNode();
        ListNode temp = l3;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            int unit = 0;
            if (sum > 9) {
                unit = sum % 10;
                carry = sum / 10;
            } else {
                carry = 0;
                unit = sum;
            }
            ListNode t = new ListNode(unit);
            temp.next = t;
            temp = temp.next;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry);
        }

        return l3.next;
    }
}