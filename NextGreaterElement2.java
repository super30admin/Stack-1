// TC - O(n)
// SC - O(n)

// LC - 503

class Solution {
    public int[] nextGreaterElements(int[] nums) {
		// Sanity check
        if(nums == null || nums.length == 0){
            return nums;
        }
        // Create a result array and a stack
        Stack<Integer> stack = new Stack<>();
        
        int[] result = new int[nums.length];
		// Fill elements of result array to -1
        Arrays.fill(result, -1);
		// We traverse two times in the array
        for(int x=0; x<2*nums.length; x++){
            int i = x % nums.length;
			// Iterate over input array and if the peek element is less than nums[i], we can pop and result[poppedVal] will be difference of curren idx and poppedVal
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int val = stack.pop();
                result[val] = nums[i];
            }
            if(x < nums.length){
                stack.push(i);   
            }
        }
        
        return result;
    }
}