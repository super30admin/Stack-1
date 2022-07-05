// Time Complexity :O(n) worstcase-O(n+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length==0){
            return new int[0];
        }
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for(int i=0;i<nums.length*2;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%nums.length]){
                int curr = st.pop();
                result[curr] = nums[i%nums.length];
            }
            if(i<nums.length) st.push(i);
        }
        return result;
    }
}