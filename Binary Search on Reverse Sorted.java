class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{20,17,15,14,13,12,10,9,8,4};
        System.out.println(decreasingOrderBinarySearch(arr,4));
    }
    
    public static int decreasingOrderBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int middle = left + ((right - left)/2);
            if(arr[middle] == target)
                return middle;
            else if(target < arr[middle])
                left = middle + 1;
            else
                right = middle - 1;
        }
        return -1;
    } 
}
