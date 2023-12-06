// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for(int i = 0 ; i < 2*n; i++){
            int curr = nums[i%n];
            while(!stk.isEmpty() && curr > nums[stk.peek()]){
                int popped = stk.pop();
                res[popped] = curr;
            }
            if(i < n)
                stk.push(i);
        }
        return res;
    }
}