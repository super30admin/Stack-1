// Time Complexity : O(2 * n)
// Space Complexity : O(1)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if(nums == null || nums.length == 0)
            return res;
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 2 * nums.length; i++){
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]){
                int idx = st.pop();
                res[idx] = nums[i % n];
            }
            if(i < n)
                st.push(i);
        }
        return res;
    }
}