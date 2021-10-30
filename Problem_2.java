// Time Complexity : O(2n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Using monotonic increasing stack, we maintain a stack of the highest value index and pop if we get max value for that index
// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1);
        for( int i = 0; i < 2*n; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int top = st.pop();
                result[top] = nums[i%n];
            }
            if(i < n) st.push(i);
        }
        return result;
    }
}