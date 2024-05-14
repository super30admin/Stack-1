// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        int top =-1;

        for(int i=0; i<2*n; i++){
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()]){
                top = st.pop();
                res[top] = nums[i%n];
            }
            st.push(i%n);
        }
        return res;
    }
}
