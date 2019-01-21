public List<Integer> inorderTraversal(TreeNode root) {
    // Creating list to contain node values
    List<Integer> list = new ArrayList<>();

    // First check if the root is null, if so then return the empty list
    if(root == null) return list;

    // Using a stack to keep track of nodes (remember when we do recursive calls we are basically adding items to a stack)
    Stack<TreeNode> stack = new Stack<>();

    // First we will check if the root is empty
    // We are making our code more concise by reusing the root node that
    // was originally passed in the parameters. Thus we will keep updating
    // it's value so when it's empty we know we have traversed the entire graph.
    while(root != null || !stack.empty()){

        // Adding all left children of the current node
        while(root != null){
            // This is what could be replaced with a recursive call
            stack.push(root);
            // Reusing our root node to set it to the left child
            root = root.left;
        }
        // After the left children have been exhausted we want to retrieve the last
        // left node we reached. This is the end of the left subtree of the graph.
        root = stack.pop();

        // Since the left has been completely traversed we now add our value to the list.
        list.add(root.val);

        // Now we update the root so the next iteration of the while loop will be able to traverse
        // the left subtree of the next right child. *IMPORTANT* remember that all of the left children
        // are still in the stack so they will continue to be popped and added to the list even though the root
        // node has been set to the right child.

        // Ok so I got stuck on this for a while because if the right child was null then how would we be able to iterate
        // through the rest of the nodes in the graph? I finally realized that on line 15 we are saying while the stack is NOT empty.
        // Thus we will keep iterating through the stack until it has been emptied thus allowing us to reach all of the nodes. 
        root = root.right;
        
    }

    // Now we simply return the list
    return list;
}