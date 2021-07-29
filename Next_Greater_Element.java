class Solution {
    //Time O(N)
    //Space O(N)
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return nums;
        }
        int n = nums.length , j = 0;
        int[] ans = new int[n];
        Arrays.fill(ans , -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < 2*n ; i++)
        {
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek()])
            {
                ans[stack.pop()] = nums[i % n];
            }
            if(i < n)
            {
                stack.push(i);
            }
        }
        return ans;
    }
}