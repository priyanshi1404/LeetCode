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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        
        // Step 1: Count the length of the list
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Step 2: Determine size of each part
        int partSize = length / k;
        int extra = length % k;  // the first 'extra' parts will have one more node

        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = curr;
            int size = partSize + (i < extra ? 1 : 0);

            // Advance to the end of this part
            for (int j = 0; j < size - 1; j++) {
                if (curr != null) curr = curr.next;
            }

            // Cut the current part
            if (curr != null) {
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }

            result[i] = partHead;
        }

        return result;
    }
}
