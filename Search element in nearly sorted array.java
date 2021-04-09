/* Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, 
i.e., arr[i] may be present at arr[i+1] or arr[i-1]. 
Write an efficient function to search an element in this array. 
Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.*/

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{5,10,30,20,40};
        System.out.println(searchElementNearlySortedArray(arr,20));
    }
    
    public static int searchElementNearlySortedArray(int[] arr, int target) {
        int left = 0;
        int n = arr.length;
        int right = n - 1;
        int mid;
        
        while(left <= right) {
            mid = left + (right - left)/2;
            if(arr[mid] == target)
                return mid;
            else if(mid - 1 >= 0 && arr[mid - 1] == target)
                return mid - 1;
            else if(mid + 1 <= n - 1 && arr[mid + 1] == target)
                return mid + 1;
            else if(arr[mid] < target)
                if(mid + 2 <= n - 1)
                left = mid + 2;
            else if(arr[mid] > target)
                if(mid - 2 >= 0)
                right = mid - 2;
        }
        return -1;
    }
}
