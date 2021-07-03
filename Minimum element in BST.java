/* Given a Binary Search Tree. The task is to find the minimum element in this given BST. */

class Tree
{
    int minValue(Node root)
    {
//         if(root == null)
//             return -1;
//         if(root.left == null)
//             return root.data;
//         return minValue(root.left);
      
        Stack<Integer> stack = new Stack<>();
        Node curr = root;
        
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr.data);
                curr = curr.left;
            }
            return stack.pop();
        }
        return -1;
    }
}
