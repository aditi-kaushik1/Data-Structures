/* Given a binary tree of size N, you have to count number of nodes in it. */

class Tree
{
	public static int getSize(Node root)
	{
        // if(root == null)
        //     return 0;
        // return 1 + getSize(root.left) + getSize(root.right);
        
        Queue<Node> q= new LinkedList<>();
        if(root == null)
            return 0;
        q.add(root);
        int count = 0;
        
        while(!q.isEmpty()) {
            Node temp = q.remove();
            count++;
            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null)
                q.add(temp.right);
        }
        return count;
    }
}
