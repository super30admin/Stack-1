// Problem 1 - Daily Temperatures
// Time Complexity : O(n + n) where n = length of array
// Space Complexity : O(n) -> for stack

// Your code here along with comments explaining your approach
// 1 - loop over array
// 2 - while condition, until stack is empty and current number is greater than element at peek index
// 3 - pop the index from stack
// 4 - output is current index - popped index
// 5 - end while condition
// 6 - push the current index to stack
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[]{0};
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        // 1
        for (int i=0; i<T.length; i++) {
            // 2
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int popped = stack.pop(); // 3
                result[popped] = i - popped; // 4
            } // 5
          
            // 6
            stack.push(i);
        }
        
        return result;
    }
}

// Problem 2 - Next Greater Element II
// Time Complexity : O(2n) where n = length of array
// Space Complexity : O(n) -> for stack

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        
        Arrays.fill(result, -1);
        
        for (int i=0; i<nums.length * 2; i++) {
            int index = i % nums.length;
            
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                int popped = stack.pop();
                result[popped] = nums[index];
            }
            
            if (result[index] == -1) {
                stack.push(index);
            }
        }
        
        return result;
    }
}
