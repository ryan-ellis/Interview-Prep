/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode newListHead = newList;

        // Continue comparing values in both lists until one list is empty
        // Code could be reduced potentially by using Math.max() calls
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                newList.next = new ListNode(l1.val);
                newList = newList.next;
                l1 = l1.next;
            } else{
                newList.next = new ListNode(l2.val);
                newList = newList.next;
                l2 = l2.next;
            }
        }
        
        // If list 2 has been exhausted then add the remainder of list 1
        while(l1 != null){
            newList.next = new ListNode(l1.val);
            newList = newList.next;
            l1 = l1.next;
        }
        
        // If list 1 has been exhausted then add the remainder of list 2
        while(l2 != null){
            newList.next = new ListNode(l2.val);
            newList = newList.next;
            l2 = l2.next;
        }
        
        // Return the head of the next list, skipping the first value used to
        // initialize the list.
        return newListHead.next;
    }
}