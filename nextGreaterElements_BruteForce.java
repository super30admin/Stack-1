// Time Complexity : O(n^2) where n is the length of array nums
// Space Complexity : O(n) where n is the length of array nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Your code here along with comments explaining your approach
// Brute force: searching thru i+1 to end and 0 to i-1 for max element for every element in nums

class nextGreaterElements_BruteForce {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        if (nums.length == 0) return ans;
        Arrays.fill(ans, -1);
        for (int i = 0; i < ans.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < ans.length; j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int k = 0; k < i; k++) {
                    if (nums[k] > nums[i]) {
                        ans[i] = nums[k];
                        break;
                    }
                }
            }
        }
        return ans;
    }
}