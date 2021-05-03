class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //Sanity check
        if(nums == null || nums.length == 0){
            return nums;
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        
        Arrays.fill(result, -1);

        //In the first iteration, if the condition satisfies, 
        //the elemets are poped from stack and appropriate value is added to the result array at the index position
        //and psuh current index onto stack
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        
        //In the second iteration for all the elemets we cant find in the 1st iteration, 
        //if the condiation satisfies, update the value in result array
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                result[stack.pop()] = nums[i];
            }
        }
        
        //return the result array
        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)