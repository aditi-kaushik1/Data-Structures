/* Given a Binary Tree and a target key, you need to find all the ancestors of the given target key.

              1
            /   \
          2      3
        /  \
      4     5
     /
    7
Key: 7
Ancestor: 4 2 1 */

class Solution
{
    
    public static ArrayList<Integer> Ancestors(Node root, int target)
    {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, target, list);
        return list;
    }
    
    public static boolean helper(Node root, int target, ArrayList<Integer> list) {
        if(root == null)
            return false;
        if(root.data == target)
            return true;
            
        if(helper(root.left, target, list) || helper(root.right, target, list)) {
            list.add(root.data);
            return true;
        }
        return false;
    }
}
