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
    int getLength(ListNode head){
        int length=0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }
    ListNode getKthNode(ListNode head, int k){
        k=k-1;
        while(head != null && k>0){
            head = head.next;
            k--;
        }
        return head;
    }
    ListNode reverse(ListNode head){
        ListNode cur= head;
        ListNode prev=null;

        while(cur!= null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==1){
            return head;
        }
        int length=getLength(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while(length >= k){
            ListNode start = cur;
            ListNode end= getKthNode(cur,k);
            if(end == null){
                break;
            }
            ListNode nextNode=end.next;
            end.next = null;
            prev.next = reverse(start);

            start.next = nextNode;
            prev = start;
            cur = nextNode;
            length-=k;
        }
        return dummy.next;
    }

}