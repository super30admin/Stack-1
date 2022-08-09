// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//739. Daily Temperatures
//https://leetcode.com/problems/daily-temperatures/

class Solution {
    //time:O(n)
    //space:O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        
        for(int i=0; i<n; i++){
            
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int idx = st.pop(); 
                result[idx] = i-idx;
            }
            
                st.push(i);
         
        }
       return result; 
    }
}