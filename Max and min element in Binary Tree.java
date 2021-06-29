/* Given a Binary Tree, find maximum and minimum elements in it. */

class Solution{
    public static int findMax(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root == null)
            return Integer.MIN_VALUE;
        q.add(root);
        
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            Node temp = q.remove();
            max = Math.max(max, temp.data);
            
            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null)
                q.add(temp.right);
        }
        return max;
    }
    
    public static int findMin(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root == null)
            return Integer.MIN_VALUE;
        q.add(root);
        
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Node temp = q.remove();
            min = Math.min(min, temp.data);
            
            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null)
                q.add(temp.right);
        }
        return min;
    }
}
