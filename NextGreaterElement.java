// Time Complexity : O(2N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Using Monotonic increasing stack

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1);
        for(int i=0;i < 2*n;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int pop = st.pop();
                result[pop]= nums[i%n];
            }
            st.push(i%n);
        }
        return result;
    }
}