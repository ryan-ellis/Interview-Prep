/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    // Use of max variable for special case that root is leaf, therefore
    // the longest path would be 0 even though the height is 1.
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        aux(root);
        return max;
    }
    
    private int aux(TreeNode root){
        if(root == null) {
            return 0;
        } else{
            int left = aux(root.left);
            int right = aux(root.right);
            
            max = Math.max(max, left + right);
        
            return Math.max(left, right) + 1;
        }
    }
}
