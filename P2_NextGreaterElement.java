/*
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);
        for(int i=0 ; i<nums.length * 2; i++) {
            int idx = i % nums.length;
            while(!st.empty() && nums[idx] > nums[st.peek()]) {
                answer[st.peek()] = nums[idx];
                st.pop();
            }
            if(i < nums.length) {
                st.push(idx);
            }
        }
        return answer;
    }
}