// Uisng iterative inorder approach
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        // Count will help us keep track of the i-th position we are at so we know when to return
        // once we reach the k-th position
        int count = 0;
        // Same for loop conditinos that we use for inorder iterative traversal
        while(root != null || !stack.isEmpty()){
            // Adding all children of the left subtree
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            // After each time that we pop we increase our count (i.e. our i-th position)
            // Since we are using inorder our stack will traverse the tree in an ascending order
            // thus once our count equals k we know that we have the smallest number in that position
            count++;
            if(count == k){
                return root.val;
            }
            root = root.right;
        }
        
        // If we traverse through the whole tree without reaching the k-th position then we will throw an error
        // or in this case we simply return the minimum integer value. Depends on what the problem calls for.
        return Integer.MIN_VALUE;
    }
}