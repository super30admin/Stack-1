// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // return empty array if input array is null or its length is 0
        if(nums == null || nums.length == 0) return new int[nums.length];
        int n = nums.length;
        // intialize the result array and fill it with -1
        int[] result = new int[n];
        Arrays.fill(result, -1);
        // intialize stack and push the first index of inside the stack
        Stack<Integer> st = new Stack<>();
        st.push(0);
        // iterate twice through the array since the array is circular
        for(int i = 0; i < n * 2; i++){
            // if the current element is greater than element at index which is at top of stack
            // pop the top most index from stack and at that index, store the current element
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]) result[st.pop()] = nums[i % n];
            // keep pushing index inside the stack during the first pass
            if(i < n) st.push(i);
        }
        // return the result array
        return result;
    }
}