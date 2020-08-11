// Time Complexity : O(N*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 /* 
 Bruteforce
 1. For each temperature, check untill a warmer day is found.
 */

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return new int[0];
        int[] result = new int[T.length];
        for(int i=0;i<T.length-1;i++){
            for(int j=i+1;j<T.length;j++){
                if(T[i]<T[j]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }
}


// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 /* 
 Stack
 1. Check if peek is less than incoming and if true peek elements ans = pop .
 2. Push all elements.
 3. Instead of elements push index, so that e can keep track of difference of temperature days.
 */

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return new int[0];
        int[] result = new int[T.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<T.length;i++){
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int index = st.pop();
                result[index] = (i-index);
            }
            st.push(i);
        }
        
        return result;
    }
}