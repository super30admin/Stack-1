// 503. Next Greater Element II
// https://leetcode.com/problems/next-greater-element-ii/description/

// Time Complexity: O(n)
// Space Complexity: O(n)


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        
        Arrays.fill(ans, -1);

        for(int i = 0 ; i < 2 * n ; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i % n]){
                ans[st.peek()] = nums[i % n];
                st.pop();
            }

            if(i < n){
                st.push(i);
            }

        }

        return ans;
    }
}