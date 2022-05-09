// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    //Increasing monotonically stack
    //TC: O(3n) SC: O(n)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        boolean flag = false;
        Stack<Integer>
 st = new Stack<>();
        for(int i=0;i<2*n;i++){ // 2 times traversal as at last stack doesnt remain empty or stack still have otems to be resolved
            if(i>n-1 && i%n == st.peek())flag=true;
            while(!flag && !st.isEmpty() && nums[i%n]>nums[st.peek()]){
                result[st.pop()] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
            
        }
        return result;
    }
}