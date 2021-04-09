//A sorted array is given, which may be in ascending or descendding order.
//We need to find an element in it.
//Check if it is in ascending order or descending order, then apply if-else condition for both.
class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{20,17,15,14,13,12,10,9,8,4};
        System.out.println(ordeerAgnosticSearch(arr,4));
    }
    
    public static int ordeerAgnosticSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        if(arr.length == 1 && arr[0] == target)
            return 0;
        if(arr.length == 1 && arr[0] != target)
        	return -1;
        if(arr[0] < arr[1]) {
            while(left <= right) {
            int middle = left + ((right - left)/ 2);
            if(arr[middle] == target)
                return middle;
            else if(target < arr[middle])
                right = middle - 1;
            else
                left = middle + 1;
            }
        }
        else {
            while(left <= right) {
                int middle = left + ((right - left)/2);
                if(arr[middle] == target)
                    return middle;
                else if(target < arr[middle]) 
                    left = middle + 1;
                else
                    right = middle - 1;
            }
        }
        return -1;
    } 
}
