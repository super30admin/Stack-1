// TC - O(n)
// SC - O(n)

// LC - 739

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
		// Sanity check
        if(temperatures == null || temperatures.length == 0){
            return temperatures;
        }
		// Create a result array and a stack
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        // Iterate over input array and if the peek element is less than temperatures[i], we can pop and result[poppedVal] will be difference of curren idx and poppedVal
        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int val = stack.pop();
                result[val] = i - val;
            }
			// push current index onto stack
            stack.push(i);
        }
        return result;
    }
}n