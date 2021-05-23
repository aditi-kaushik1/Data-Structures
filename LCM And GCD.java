/* Given two numbers A and B. The task is to find out their LCM and GCD.
Example 1:

Input:
A = 5 , B = 10
Output:
10 5
Explanation:
LCM of 5 and 10 is 10, while
thier GCD is 5.
You don't need to read input or print anything. 
Your task is to complete the function lcmAndGcd() which takes an Integer N as input and returns a List of two Integers, the required LCM and GCD.
Expected Time Complexity: O(log(min(A, B))
Expected Auxiliary Space: O(1)
Constraints:
1 <= A,B <= 10^18 */

class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
        //Solution 1
        // Long res = 0L;
        // for(long i = 1; i <= Math.min(A,B); i++) {
        //     if(A % i == 0 && B % i == 0)
        //         res = i;
        // }
        // Long lcm = (A*B)/res;
        // return new Long[]{lcm,res};
        
        //Solution 2
    //     Long hcf = hcf(A, B);
    //     Long lcm = A*B/hcf;
    //     return new Long[]{lcm, hcf};
    // }
    
    // private static Long hcf(Long a, Long b) {
    //     if(a == 0)
    //         return b;
    //     if(b == 0)
    //         return a;
    //     if(a > b)
    //         return hcf(a-b,b);
    //     return hcf(a, b - a);
    
    //Solution 3
    Long hcf = hcf(A, B);
    Long lcm = A*B/hcf;
    return new Long[]{lcm, hcf};
    }
    
    private static Long hcf(Long a, Long b) {
        if(b == 0)
            return a;
        return hcf(b, a%b);
    }
}
