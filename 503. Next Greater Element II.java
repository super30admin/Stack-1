// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[] {};
        if(nums.length == 1){
            return new int[] {-1};
        }
        
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for(int i = 0; i < 2 * n; i++){
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]){
                int idx = s.pop();
                result[idx] = nums[i % n];
            }
            if(i < n){
                s.push(i);
            }
            if(i > n && i % n > s.peek()){
                break;
            }
        }
        return result;
    }
}