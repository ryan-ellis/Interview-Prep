class Solution {
    // For this problem we will use inorder traversal on the tree in order to validate it
    public boolean isValidBST(TreeNode root) {
        // As with most of our iterative approaches we will be using a stack
        Stack<TreeNode> stack = new Stack<>();
        // For this problem specifically we need to keep track of the previous node directly
        // because we are going to compare the current node with the node that acts as it's parent.
        // Remember that for inorder traversal's we follow the following form: (left -> visit node -> right)
        TreeNode previous = null;
        // Same for loop conditions as per usual with inorder iterative traversal
        while(root != null || !stack.isEmpty()){
            // Adding all children of the left subtree
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            // This is basically the only part of the inorder traversal that is changed in order to accomodate
            // this problem. Instead of adding the current node to a list, this is where we compare the current
            // node with the previous node that we initiated earlier. The reason why this works for comparing the key
            // with both the left and right subtrees is because we are using the property of inorder traversal which
            // was mentioned above (left -> visit -> right). This means that when we are comparing the left most node, previous will
            // be null so nothing is compared. When we are comparing the parent node the previous node will be our left node. Then when
            // we are comparing the right node our previous node will be the parent node. Thus the same comparison statement works for
            // all cases.
            if(previous != null && root.val <= previous.val){
                return false;
            }
            previous = root;
            root = root.right;
        }
        // After traversing through the tree if we reach the end then the tree meets our criteria.
        return true;
    }
}