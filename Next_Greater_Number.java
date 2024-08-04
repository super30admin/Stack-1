// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[nums.length];
        int n = nums.length;
        Arrays.fill(res, -1);

        for(int i=0; i<2 *n ; i++){
            while(!s.isEmpty() && nums[i %n] > nums[s.peek()]){
                int popped = s.pop();
                res[popped] = nums[i % n];
            }
            if(i<n){
                s.push(i);
            }
        }
        return res;
    }
}