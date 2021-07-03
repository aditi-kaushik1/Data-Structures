class Tree
{
    int countLeaves(Node root) 
    {
        // if(root == null)
        //     return 0;
        // if(root.left == null && root.right == null)
        //     return 1;
        // return countLeaves(root.left) + countLeaves(root.right);
        
        Queue<Node> q = new LinkedList<>();
        if(root == null)
            return 0;
        q.add(root);
        int count = 0;
        while(!q.isEmpty()) {
            Node temp = q.remove();
            if(temp.left == null && temp.right == null)
                count++;
            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null)
                q.add(temp.right);
        }
        return count;
    }
}
