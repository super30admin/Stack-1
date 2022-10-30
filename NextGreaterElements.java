import java.util.Arrays;
import java.util.Stack;

/*
## Problem 2: Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)

Time Complexity :   O (n) 
Space Complexity :  O (n)
Did this code successfully run on Leetcode :    Yes (503. Next Greater Element II)
Any problem you faced while coding this :       No
 */
// Input: nums = [1,2,1]
// Output: [2,-1,2]

class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i< n*2; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int curr = st.pop();
                result[curr] = nums[i%n];
            }
            if(i < n)
                st.push(i%n);
        }
        return result;
    }
}