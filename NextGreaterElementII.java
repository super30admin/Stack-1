// Time Complexity : O(3n) => O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We iterate twice over the nums array to have the cyclic comparison for each element
// 2: To avoid having integer out of bounds exception, we use [i%n] to always stay within the bounds of the array
// 3: We make sure to only push elements during the first iteration through the array, as the second iteration is purely for comparison
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<2*n; i++){
            // pop
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(!st.isEmpty() && i%n == st.peek()) break;
            // first iteration
            if(i<n){
                st.push(i);
            }
        }
        return result;
    }
}