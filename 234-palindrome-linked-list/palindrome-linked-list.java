class Solution {
    // This variable is used to track the current node from the front of the list
    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head; // Initialize left pointer to the head of the list
        return helper(head); // Start the recursion with the head node
    }

    // Helper function that does the actual recursion with the right pointer
    private boolean helper(ListNode right) {
        // Base case: If right pointer reaches null, we've checked all nodes
        if (right == null) {
            return true;
        }

        // Recursively call helper on the next node (move right pointer)
        boolean isPalindrome = helper(right.next);

        // If at any point the list is found not to be a palindrome, return false
        if (!isPalindrome) {
            return false;
        }

        // Compare the current left and right values
        boolean result = (left.val == right.val);

        // Move the left pointer forward after comparison
        left = left.next;

        return result;  // Return true if both values match, otherwise false
    }
}
