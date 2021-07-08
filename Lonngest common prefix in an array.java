class Solution{
    String longestCommonPrefix(String arr[], int n){
        String ans = arr[0];
        
        for(int i = 1; i < arr.length; i++)
            ans = helper(ans, arr[i]);
        if(ans == "")
            return "-1";
        return ans;
    }
    
    String helper(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        String res = "";
        
        for(int i = 0, j = 0; i < n1 && j < n2; i++, j++) {
            if(s1.charAt(i) != s2.charAt(j))
                break;
            res += s1.charAt(i);
        }
        return res;
    }
}
