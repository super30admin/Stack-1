# Stack-1 problems

Problem 1:
(https://leetcode.com/problems/daily-temperatures/)
// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No  
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[T.length];
        if(T==null || T.length==0) return arr;

        for(int i=0;i<T.length;i++){
            while(!st.isEmpty() && T[i]>T[st.peek()]){
                int index=st.pop();
                arr[index] = i-index;
            }
            st.push(i);
        }
        return arr;
    }
}