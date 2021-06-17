public class Main
{
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.Root("A");
		tree.setRight("C",0);
		tree.setLeft("D",1);
		tree.setRight("E",1);
		tree.setLeft("F",2);
		tree.printTree();
	}
}

public class Tree {
    Tree() {
        String[] arr = new String[10];
    }
    
    public void Root(String str) {
        arrr[0] = str;
    }
    
    public void setLeft(String str, int parent) {
        if(arr[parent] == null)
            System.out.println("Cannot find parent!");
        else {
            int left = (2 * parent) + 1;
            arr[left] = str;
        }
    }
    
    public void setRight(String str, int parent) {
        if(arr[parent] == null)
            System.out.println("Cannot find parent");
        else {
            int right = (2 * parent) + 2;
            arr[right] = str;
        }
    }
    
    public void printTree() {
        for(String x : arr) {
            if(x == null)
                System.out.print("-");
            else
                System.out.print(x);
        }
    }
}
