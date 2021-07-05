/* Given an array A of positive integers. Your task is to find the leaders in the array. 
An element of array is leader if it is greater than or equal to all the elements to its right side. 
The rightmost element is always a leader */

class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[n - 1]);
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);
        
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] >= stack.peek()) {
                list.add(arr[i]);
                stack.push(arr[i]);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
