/**
 *  Idea: The key for this problem is finding a clever way to handle the
 *        carry over value, in this case sum /= 10.
 * 
 *  Run Time: O(n), depends on how many total numbers there are.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(-1);
        ListNode head = curr;
        int sum = 0;
        
        // Iterate until both lists are empty
        while(l1 != null || l2 != null){

            // This is a very clever way to keep track of the carry
            // over without having to use a seperate value that would
            // have to be reset after each time it is used.
            sum /= 10;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            // Setting the next to the mod of 10 insures that
            // we are only adding the one's digit.
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        } 
        
        // Important edge case to check for, if after both lists are empty
        // there is still one carry over we need to add the final remainder.
        if(sum / 10 == 1){
            curr.next = new ListNode(1);
        }
    
        // Returning the next node in the head because the actual head node is
        // set to -1 initially.
        return head.next;
    }
}