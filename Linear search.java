/* Time complexity:
Best case: O(1)
Worst case: O(n) */

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,3,6,5};
        Main search = new Main();
        System.out.println(search.linearSearch(arr,70));
    }
    
    public int linearSearch(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x)
                return i;
        }
        return -1;
    }
}
