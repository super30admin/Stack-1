// Uses a monotonic stack, meaning the stack is ordered in ascending or descending order
// In this case the higher temperature indices are on top

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] dailyTemperatures(int[] T) {
    	Stack<Integer> stack = new Stack<>();
    	int[] result = new int[T.length];

    	for(int index = 0; index < T.length; index++) {
    		while(!stack.isEmpty() && T[index] > T[stack.peek()]) {
    			int priorIndex = stack.pop();
    			result[priorIndex] = index - priorIndex;
    		}
    		stack.push(index);
    	}

    	return result;
        
    }
}