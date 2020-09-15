import java.util.Arrays;
import java.util.Stack;

/**************************Brute Force******************************/
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Next_Greater_Element_II_BruteForce {
	public int[] nextGreaterElements(int[] nums) {
		if(nums == null || nums.length == 0)
			return nums;
		int[] result = new int[nums.length];
		Arrays.fill(result, -1);
		for(int i=0; i<nums.length; i++){
			for(int j=1; j<nums.length; j++){
				if(nums[(i+j) % nums.length] > nums[i]){
					result[i] = nums[(i+j) % nums.length];
					break;
				}
			}
		}
		return result;
	}
}

/**************************Brute Force******************************/
//Time Complexity : O(3n),  length of nums(n) + circular array(n) + iterate through the stack (n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Next_Greater_Element_II_Stack {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;
        Stack<Integer> stack = new Stack<>();
        
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        
        for(int i=0; i< 2 * nums.length; i++){  // circular array
            while(!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]){  // till stack is not empty and we have a next greater element for the index at stack peek
                int index = stack.pop();
                result[index] = nums[i % nums.length];
            }
            if(i < nums.length) // push only once not for the second round
                stack.push(i);
        }
        return result;
    }
}