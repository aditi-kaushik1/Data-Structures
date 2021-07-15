import java.util.*;
public class Main
{
    public static void main(String[] args) {
        int[] arr = {4,2,1,7,6,4};
        int n = arr.length;
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if(arr.length < 2)
            return;
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;
        int m = left.length;
        int n = right.length;

        while(i < m && j < n) {
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while(i < m)
            arr[k++] = left[i++];
        while(j < n)
            arr[k++] = right[j++];
    }
}

import java.util.*;
// public class Main
// {
// 	public static void main(String[] args) {
// 		int[] arr = {5,3,1,23,5,89,2};
// 		sort(arr);
// 		System.out.println(Arrays.toString(arr));
// 	}
	
// 	public static void sort(int[] arr) {
// 	   if(arr.length < 2)
// 	        return;
// 	   int middle = arr.length/2;
// 	   int[] left = new int[middle];
// 	   for(int i = 0; i < middle; i++)
// 	        left[i] = arr[i];
// 	   int[] right = new int[arr.length - middle];
// 	   for(int i = middle; i < arr.length; i++)
// 	        right[i - middle] = arr[i];
// 	   sort(left);
// 	   sort(right);
// 	   merge(arr, left, right);
// 	}
	
// 	public static void merge(int[] arr, int[] left, int[] right) {
// 	    int i = 0;
// 	    int j = 0;
// 	    int k = 0;
// 	    int m = left.length;
// 	    int n = right.length;
	    
// 	    while(i < m && j < n) {
// 	        if(left[i] <= right[j])
// 	            arr[k++] = left[i++];
// 	        else
// 	            arr[k++] = right[j++];
// 	    }
	    
// 	    while(i < m)
// 	        arr[k++] = left[i++];
// 	    while(j < n)
// 	        arr[k++] = right[j++];
// 	}
// }
