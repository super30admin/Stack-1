// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int n=nums.length;
       int [] result = new int[n];
       Arrays.fill(result,-1);
       Stack<Integer> st = new Stack<>();
       if(nums.length == 0) return result;
       for(int i=0;i<2*n;i++){
           while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
               int top = st.pop();
               result[top] = nums[i%n];
           }
           if(i<n)st.push(i);
       }
        return result;
    }
}