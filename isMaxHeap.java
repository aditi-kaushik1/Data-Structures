import java .util.*;
public class Main
{
  public static boolean isMaxHeap(int[] arr) {
        for(int i = arr.length/2 - 1; i >= 0; i--) {
            if(leftChildIndex(i) < arr.length && arr[i] < arr[leftChildIndex(i)])
                return false;
            if(rightChildIndex(i) < arr.length && arr[i] < arr[rightChildIndex(i)])
                return false;
        }
        return true;
  }


    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 9, 1, 2};
        System.out.println(isMaxHeap(arr));
        heapify(arr);
        System.out.println(isMaxHeap(arr));
        System.out.println(Arrays.toString(arr));
    }
}
