/* Given an infinite sorted array consisting 0s and 1s. The problem is to find the index of first ‘1’ in that array. 
As the array is infinite, therefore it is guaranteed that number ‘1’ will be present in the array.

Examples:
Input : arr[] = {0, 0, 1, 1, 1, 1} 
Output : 2
Input : arr[] = {1, 1, 1, 1,, 1, 1}
Output : 0 */

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(findFirst1(arr));
    }
    
    public static int findFirst1(int[] arr) {
        int left = 0;
        int right = 1;
        while(arr[right] == 0) {
            left = right;
            right *= 2;
        }
        return findFirstOccurence(arr,left,right);
    }
    
    public static int findFirstOccurence(int[] arr, int left, int right) {
        int res = right;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] == 1) {
                res = mid;
                right = mid - 1;
            }
            else if(arr[mid] == 0)
                left = mid + 1;
        }
        return res;
    }
}
