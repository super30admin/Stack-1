// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int topIndex = stack.pop();
                result[topIndex] = i - topIndex;
            }
            stack.add(i);
        }
        return result;
    }
}


// Time Complexity : O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Yes, it was a bit hard to understand

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] outputArray = new int[n];
        Arrays.fill(outputArray, -1);
        
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < n*2; i++)
        {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n])
            {
                outputArray[stack.pop()] = nums[i%n];
            }
            if(i < n)
            {
                stack.push(i);
            }
        }
        return outputArray;
        
    }
}