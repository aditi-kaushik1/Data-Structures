/* Given an array of distinct elements, print the closest greater element for every element. 
The closest greater element for an element x is the smallest element on the right side of x in array which is greater than x. 
Elements for which no greater element exist, consider next greater element as -1.

Examples:

Input: arr[] = {4, 5, 2, 25}
Output: 
Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1

Input: arr[] = {4, 10, 7}
Output: 
Element       NGE
   4       -->  7
   10      -->   -1
   7       -->   -1 */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    //Solution 1
	    //O(n^2) solution
// 		int[] arr = {4,10,7};
// 		int n = arr.length;
// 		int[] ans = new int[n];
		
// 		for(int i = 0; i < n; i++)
// 		    ans[i] = arr[i];
// 		for(int i = 0; i < n; i++) {
// 		    for(int j = i + 1; j < n; j++) {
// 		        if(arr[j] > arr[i] && ans[i] == arr[i])
// 		            ans[i] = arr[j];
// 		        else if(arr[j] > arr[i])
// 		            ans[i] = Math.min(arr[j], ans[i]);
// 		    }
// 		    if(ans[i] == arr[i])
// 		        ans[i] = -1;
// 		}
// 		System.out.println(Arrays.toString(ans));

        //Solution 2
        int[] arr = {4,5,2,25};
        int n = arr.length;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int x : arr)
            ts.add(x);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            if(ts.higher(arr[i]) == null)
                ans[i] = -1;
            else
                ans[i] = ts.higher(arr[i]);
            ts.remove(arr[i]);
        }
        System.out.println(Arrays.toString(ans));
	}
}
