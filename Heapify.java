import java.util.*;
public class Main
{
    public static void main(String[] args) {
        int[] arr = {5,3,8,4,1,2};
        heapify(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapify(int[] arr) {
        var lastParentIndex = (arr.length/2) - 1;
        for(int i = lastParentIndex; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    public static void heapify(int[] arr, int index) {
        var largerIndex = index;

        if(leftChildIndex(index) < arr.length && arr[index] < arr[leftChildIndex(index)])
            largerIndex = leftChildIndex(index);

        if(rightChildIndex(index) < arr.length && arr[rightChildIndex(index)] > arr[largerIndex])
            largerIndex = rightChildIndex(index);

        if(index == largerIndex)
            return;

        swap(arr, index, largerIndex);

        heapify(arr, largerIndex);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    public static int rightChildIndex(int index) {
        return 2 * index + 2;
    }
}
