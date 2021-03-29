// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> s = new Stack();
        int ans[] = new int[nums.length];
        
        // Do first iteration till end
        for(int i = 0;i<nums.length;i++) {
            
            while(!s.isEmpty() && nums[s.peek()]<nums[i]) {
                ans[s.pop()] = nums[i];
            }
            s.push(i);
            
        }
        
        // Do second iteration for circular array
        for(int i = 0;i<nums.length;i++) {
            if(s.isEmpty()) break;
            while(!s.isEmpty() && nums[s.peek()]<nums[i]) {
                ans[s.pop()] = nums[i];
            }
            
        }
        
        // set left values to -1
        while(!s.isEmpty()) {
                ans[s.pop()] = -1;
        }
        
        return ans;
        
    }
}
