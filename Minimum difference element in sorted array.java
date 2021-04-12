/*Given a sorted array, find the element in the array which has minimum difference with the given number. */
  
  public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,8,10,12,15};
        System.out.println(minimumDifferenceElement(arr,12));
    }
    
    public static int minimumDifferenceElement(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        
        while(left <= right) {
            mid = left + (right - left)/2;
            if(arr[mid] == target)
                return target;
            else if(target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        if((arr[left] - target) > (target - arr[right]))
            return arr[right];
        else
            return arr[left];
    }
}
