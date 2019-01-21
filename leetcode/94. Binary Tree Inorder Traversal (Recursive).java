// Essentially the same idea as the iterative approach. Though this solution is defintely more elegant.
public List<Integer> inorderTraversal(TreeNode root) {
	// Again we are using an arraylist to keep track of our values
    ArrayList<Integer> list = new ArrayList<>();
        
    // Checking if the head is null, if so then we don't bother with the recursive call
	if(root != null){
		inorderAux(root, list);
	}
    
    // Finally we return the list
    return list;
}

// While in the iterative approach we used a stack now we are going to rely on the recursive call
// itself to act as our stack (since memory actually uses a stack for recursion)
private void inorderAux(TreeNode node, ArrayList<Integer> list){
	// Very basic inorder approach
	if(node != null){
		inorderAux(node.left, list);
		list.add(node.val);
		inorderAux(node.right, list);
	} else{
		return;
	}
	// While this approach is obviously more concise and cleaner you don't get to quite see how the implementation
	// works as you do when using the iterative approach utilizing the stack directly.
}