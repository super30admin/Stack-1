// Problem2 Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take a stack and array result fill array with -1. Iterate from 0 to 2* end of nums and when stack is not empty and nums[i] > nums[st.peek()]
 * the pop the top element and add result[poppedIdx] = nums[i % nums.length];; After loop add i if its less than nums.length to the stack and finally
 * return result
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int []result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 2 * nums.length; i++){
            while(!st.isEmpty() && nums[i % nums.length] > nums[st.peek()]){
                int poppedIdx = st.pop();
                result[poppedIdx] = nums[i % nums.length];
            }
            if(i < nums.length){
                st.push(i);
            }
        }
        return result;
    }
}