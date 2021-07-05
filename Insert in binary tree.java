public class Main {
    public static void insert(int data) {
	    //Iterative method
// 	    Queue<Node> = new LinkedList<>();
// 	    if(root == null) {
// 	        root = new Node(data);
// 	        return;
// 	    }
// 	    q.add(root);
// 	    while(!q.isEmpty()) {
// 	        Node temp = q.pop();
// 	        if(temp.left == null) {
// 	            temp.left = new Node(data);
// 	            return;
// 	        }
// 	        else
// 	            q.add(temp.left);
// 	        if(temp.right == null) {
// 	            temp.right = new Node(data);
// 	            return;
// 	        }
// 	        else
// 	            q.add(temp.right);
// 	    }
	    
	   //Recursive method
	   root = helper(root, data);
    }
	public TreeNode helper(TreeNode node, val) {
		if(node == null)
			return new TreeNode(val);
		if(val < node.left)
			node.left = helper(node.left, val);
		else
			node.right = helper(node.right);
		return node;
		
	}
}
