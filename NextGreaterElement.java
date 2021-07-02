// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the array linearly couple of times
//Space Complexity: O(1) since we are not taking any extra space except result array
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1; i < nums.length; i++){
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                int idx = st.pop();
                res[idx] = nums[i];
            }
            st.push(i);
        }
        
        if(!st.isEmpty()){
           for(int ele : nums){
             while(!st.isEmpty() && ele > nums[st.peek()]){
                int k = st.pop();
                res[k] = ele;
             }
            }   
        }
        
        
        return res;
    }
}