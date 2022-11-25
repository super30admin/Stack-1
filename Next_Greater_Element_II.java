// TC : O(n)
// SC : O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[]{};
        
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < 2 * n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
                    int num = st.pop();
                    result[num] = nums[i%n];
            }
            if(i < n)
                st.push(i);
        }
        return result;
    }
}
