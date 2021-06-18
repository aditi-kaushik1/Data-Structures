/* Given a Binary Tree of size N, your task is to complete the function sumBt(), that should return the sum of all the nodes of the given binary tree. */

class BinaryTree
{
    static int sumBT(Node root){
        // if(root == null)
        //     return 0;
        // Queue<Node> q = new LinkedList<>();
        // q.add(root);
        // int sum = 0;
        // while(!q.isEmpty()) {
        //     Node temp = q.remove();
        //     sum += temp.data;
        //     if(temp.left != null)
        //         q.add(temp.left);
        //     if(temp.right != null)
        //         q.add(temp.right);
        // }
        // return sum;
        
        if(root == null)
            return 0;
        return root.data + sumBT(root.left) + sumBT(root.right);
    }
}
