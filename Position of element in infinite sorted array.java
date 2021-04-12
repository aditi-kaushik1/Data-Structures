/* Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
Source: Amazon Interview Experience.

Since array is sorted, the first thing clicks into mind is binary search, but the problem here is that we don’t know size of array.
If the array is infinite, that means we don’t have proper bounds to apply binary search. 
So in order to find position of key, first we find bounds and then apply binary search algorithm.

Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
->if it is greater than high index element then copy high index in low index and double the high index.
->if it is smaller, then apply binary search on high and low indices found. */

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println(findElementInInfiniteSortedArray(arr,0));
    }
    
    public static int findElementInInfiniteSortedArray(int[] arr, int target) {
        int left = 0;
        int right = 1;
        while(true) {
        if(target > arr[right]) {
            left = right;
            right *= 2;
        }
        else if(target == arr[right])
            return right;
        else if(target < arr[right])
            return binarySearch(arr, left, right, target);
        }
    }
    
    public static int binarySearch(int[] arr, int left, int right, int target) {
        int mid;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(arr[mid] == target)
                return mid;
            else if(target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
