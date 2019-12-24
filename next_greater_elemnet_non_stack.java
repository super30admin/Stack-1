//Time Complexity: O(n^2)
//Space Complexity: O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        for(int i=0;i<nums.length;i++){
            for (int j = 1; j < nums.length; j++) {
                int k=nums[(i + j) % nums.length];
                if (k > nums[i]) {
                    dp[i] = k;
                    break;
                }
            }
        }
        return dp;
    }    
}
