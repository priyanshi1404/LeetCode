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
    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left=head;
        return helper(head);
    }

    public boolean helper(ListNode right){
        if(right==null){
            return true; //reached at the last of the list
        }
        boolean isPalindrome=helper(right.next);

        if(!isPalindrome){
            return false;  //list is not PALINDROME
        }
        boolean result=(left.val==right.val);

        left=left.next;

        return result;
    }
}