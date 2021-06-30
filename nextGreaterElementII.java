// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for(int i = 0 ; i < 2 * n ; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int idx = st.pop();
                result[idx] = nums[i%n];
            }
            if(i < n) st.push(i);
        }
        return result;
    }
}
