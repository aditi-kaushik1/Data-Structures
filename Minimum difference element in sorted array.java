/*Given a sorted array, find the element in the array which has minimum difference with the given number. */
  
  public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,8,10,12,15};
        System.out.println(minimumDifferenceElement(arr,12));
    }
    
    //Solution 1
    //Shorter Method
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

//Solution 2
//Find ceil and floor and then calculate absolute differences.
//public class Main {
//     public static void main(String[] args) {
//         System.out.println(minimumDifferenceElement(arr,8));
//     }
    
//     public static int minimumDifferenceElement(int[] arr, int target) {
//         int floor = floor(arr,target);
//         int ceil = ceil(arr,target);
//         if(Math.abs(ceil - target) > Math.abs(floor - target))
//             return floor;
//         else
//             return ceil;
//     }
    
//     static int[] arr = new int[]{1,2,3,4,5,6,9,10};
//     static int left = 0;
//     static int right = arr.length - 1;
//     static int mid;
    
//     public static int ceil(int[] arr, int target) {
//         int res = -1;
//         left = 0;
//         right = arr.length - 1;
//         while(left <= right) {
//             mid = left + (right - left)/2;
//             if(arr[mid] == target)
//                 return target;
//             else if(target < arr[mid]) {
//                 res = arr[mid];
//                 right = mid - 1;
//             }
//             else
//                 left = mid + 1;
//         }
//         return res;
//     }
    
//     public static int floor(int[] arr, int target) {
//         int res = -1;
//         while(left <= right) {
//             mid = left + (right - left)/2;
//             if(arr[mid] == target)
//                 return target;
//             else if(target > arr[mid]) {
//                 res = arr[mid];
//                 left = mid + 1;
//             }
//             else
//                 right = mid - 1;
//         }
//         return res;
//     }
// }
