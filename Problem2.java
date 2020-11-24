// Time Complexity: O(N)
// Space Complexity: O(N)
// Passed Leetcode

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        
        Stack<Integer> stack = new Stack<>();
        
        int[] output = new int[nums.length];
        
        Arrays.fill(output, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            int index = i % nums.length; 
            
            while(stack.size() > 0 && nums[index] > nums[stack.peek()]) {
                
                int currIndex = stack.pop();
                output[currIndex] = nums[index];
            }
            stack.add(index);
        }
        
        return output;
        
    }
}