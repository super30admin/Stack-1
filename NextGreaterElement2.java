// Time Complexity : O(n) --> where n is the number of elements in the input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (503): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // edge case
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];
        Arrays.fill(result, -1);
        
        for (int i = 0; i < 2*n; i++) {
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]) { // if it is able to resolve the top element of the stack
                int index = st.pop();
                result[index] = nums[i%n];
            }
            st.push(i%n);
        }
        
        return result;
    }
}