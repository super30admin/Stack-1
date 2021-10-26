// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];
        if(nums == null) return result;
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1);
        
        for(int i=0; i<2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int top = st.pop();
                result[top] = nums[i%n];
            }
            // only first iteration!
            if(i < n) st.push(i);
        }
        return result;
    }
}