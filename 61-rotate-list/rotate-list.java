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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Count the length of the list
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            length++;
            curr = curr.next;
        }

        // Step 2: Connect the tail to head to form a circle
        curr.next = head;

        // Step 3: Find new tail and new head
        k = k % length;
        int stepsToNewHead = length - k;
        ListNode newTail = curr;

        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
