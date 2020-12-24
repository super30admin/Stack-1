// Time Complexity :  O(N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for(int i = 0; i < n * 2; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int index = st.pop();
                res[index] = nums[i%n]; 
            }
            st.push(i%n);
        }
        return res;
    }
}