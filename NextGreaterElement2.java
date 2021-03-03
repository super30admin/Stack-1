// Time Complexity : O(2n) ~ O(n)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Add elements to stack if the value is less than the top
//Else resolve as many elements as we can from top


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        if(nums == null || nums.length == 0) return result;

        Stack<Integer> st = new Stack();
        st.push(0);


        Arrays.fill(result,-1);
        int n = nums.length;

        for(int i = 0; i < 2*n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]) {
                result[st.pop()] = nums[i%n];
            }
            if(i < nums.length) {
                st.push(i);
            }
        }

        return result;

    }
}
