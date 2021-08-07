class Solution
{
    public static void sort012(int arr[], int n)
    {
        //Arrays.sort(a); 
        
        //Solution 2
        // int count0 = 0;
        // int count1 = 0;
        // int count2 = 0;
        // for(int i = 0; i < n; i++) {
        //     if(a[i] == 0)
        //         count0++;
        //     else if(a[i] == 1)
        //         count1++;
        //     else
        //         count2++;
        // }
        // for(int i = 0; i < count0; i++)
        //     a[i] = 0;
        // for(int i = count0; i < count0 + count1; i++)
        //     a[i] = 1;
        // for(int i = count0 + count1; i < n; i++)
        //     a[i] = 2;
        
        //Solution 3
        int i = 0;
        int j = n - 1;
        int index = 0;
        while(i < j && index <= j) {
            if(arr[index] == 0) {
                arr[index] = arr[i];
                arr[i] = 0;
                i++;
                index++;
            }
            
            else if(arr[index] == 2) {
                arr[index] = arr[j];
                arr[j] = 2;
                j--;
            }
            
            else
                index++;
        }
    }
}
