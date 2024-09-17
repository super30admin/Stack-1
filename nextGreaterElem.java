// Time Complexity : O(N)
// Space Complexity : O(N), result array and stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Circular array was problem


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //In: {4, 6, 5, 4, 2, 3, 4, 9, 8, 1}
     //Out:   {6, 9, 9, 9, 3, 4, 9, -1, 9, 9}
        
        int n = nums.length;
        int largest = -1;
        
        int[] result = new int[n];
        
        if(nums == null || nums.length == 0) return result;
        
        Stack<Integer> s = new Stack<>();
        s.push(0);
        
        for(int i=1; i<n; i++){
            while(!s.isEmpty() && nums[i] > nums[s.peek()]){
                result[s.peek()] = nums[i];
                s.pop();
            }
            s.push(i);
        }
        
        for(int i=0; i<n;i++){
           while(!s.isEmpty() && nums[i] > nums[s.peek()]){
                result[s.peek()] = nums[i];
                s.pop();
            } 
        }
        
        while(!s.isEmpty()){
            result[s.peek()] = -1;
            s.pop();
        } 
        
        
        return result;
    }
}
