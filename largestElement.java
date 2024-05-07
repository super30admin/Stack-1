// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i< 2*n; i++){
            if(!st.isEmpty() && (i%n) == st.peek()) break;
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i < n){
                st.push(i);
            }
        }
        return result;
    }
}