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
    ListNode reverse(ListNode head){
        if(head == null || head.next==null){
            return head;
        }
        ListNode cur=head;
        ListNode prev=null;

        while(cur!=null){
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
    
        if(head==null || head.next == null){
            return head;
        }
         int count=1;
         ListNode cur=head;
         ListNode prev=null;
         ListNode next=null;

         while(count<left){
            prev=cur;
            cur=cur.next;
            count++;
         }
         ListNode start = cur;
         while(count!= right){
            cur=cur.next;
            count++;
         }
         next = cur.next;
         cur.next=null;

         ListNode newHead = reverse (start);
         if(prev!= null){
            prev.next= newHead;
         }
         start.next = next;
         if(left == 1){
            return newHead;
         }
         return head;
    }
}