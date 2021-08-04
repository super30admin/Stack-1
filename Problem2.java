// Time Complexity : O(4n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int[] result = new int[n];
        if(nums == null || n == 0) return result;
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i< 2*nums.length; i++){
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]){
                int idx = st.pop();
                result[idx] = nums[i % n];
            }
            if(i<n) st.push(i);
        }
        return result;
    }
}