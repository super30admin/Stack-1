class Solution {

    // Time Complexity: O(n) -- O(3n)   (where n -> length of nums array)
    // Space Complexity: O(n)

    public int[] nextGreaterElements(int[] nums) {
        // Edge Case Checking
        if(nums == null || nums.length == 0)
            return new int[]{-1};
        
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        
//         for(int i = 0; i < n; i++){
//             while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
//                 int index = stack.peek();
//                 result[index] = nums[i];
//                 stack.pop();
//             }
//             stack.push(i);
//         }
        
//         for(int i = 0; i < n; i++){
//             while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
//                 int index = stack.pop();
//                 result[index] = nums[i];
//             }
//         }
        
        // Instead of doing the same thing twice - Run a single for loop for twice the length of the array
        for(int i = 0; i < 2*n; i++){
            // Calculating appropriate array index - to traverse twice
            int index = i % n;
            // If the current element is greater the element at stack peek - then update the next greater element for the stack peek element in the result array
            while(!stack.isEmpty() && nums[stack.peek()] < nums[index]){
                int idx = stack.pop();
                result[idx] = nums[index];
            }
            // We only push to the stack if we are traversing the array the first time
            if(i < n)
                stack.push(i);
        }
        
        return result;
    }
}