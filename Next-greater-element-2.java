// Time Complexity : O(3N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using a decresing monotonic stack to check if the next element is greater
// resolve it and push it in with 2-passes as it a cicular array.

// 503. Next Greater Element II

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int popped = st.pop();
                res[popped] = nums[i%n];
            }
            if(i < n){
                st.push(i);
            }
        }
        return res; 
    }
}
