/* Uses a monotonic stack, in this problem the items are in ascending order from 
   bottom to the top of the stack

   Time Complexity: O(n)
   Space Complexity: O(n)
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
    	// base check
    	if(nums == null || nums.length == 0) return new int[]{};

    	int n = nums.length;
    	int[] result = new int[n];
    	Arrays.fill(result, -1);

    	Stack<Integer> stack = new Stack<>();

    	for(int index = 0; index < 2 * n; index++) {
    		while(!stack.isEmpty() && nums[index%n] > nums[stack.peek()]) {
    			int priorIndex = stack.pop();
    			result[priorIndex] = nums[index%n];
    		}

    		if(index < n) stack.push(index%n);
    	}

    	return result;
        
    }
}