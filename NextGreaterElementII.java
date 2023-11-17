// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1); //O(n)
        for(int i=0 ;i<2*n;i++) //O(2n)
        {
            if(i>n && st.peek()== i%n){  //i%n to get actual index in second traverse
                // in the second iteration stop till that index
                break;
            }
            while(!st.isEmpty() && nums[st.peek()]< nums[i%n]){ //O(n)
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i<n){
                st.push(i);
                // only push till n because next is second time tracing
                //array and they are already processed
            }
        }
        return result;

    }
}