// Time Complexity : O(2n) => O(n) n -  length of the input nums array
// Space Complexity : O(n) => stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                res[st.peek()] = nums[i];
                st.pop();
            }
            st.push(i);
        }
        // case 1: either last elements remain in the array
        // case 2: highest value elements remain in the array
        // have to consider also if the first element is higher or next to that is higher
        
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                res[st.peek()] = nums[i];
                st.pop();
            }
        }
        
        while(!st.isEmpty()){
            res[st.pop()] = -1;
        }
        return res;
    }
}
