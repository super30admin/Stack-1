// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[temperatures.length];
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
         for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
             stack.push(i);
        }
        return result;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        for(int i = 0 ; i < 2 * nums.length; i++) {
            while(!stack.isEmpty() && nums[i%nums.length] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i%nums.length];
            }
            if(i < nums.length) {
                stack.push(i);
            }
        }
        return result;
    }
}

//Extra Problem taught (Valid Parantheses)
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValid(String s) {
        
        if(s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack();
        
       for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if (current == '(' || current == '{' || current == '[')
                stack.push(current);
            
            else if (stack.isEmpty())
                return false;
            
            else if (current == ')' && stack.pop() != '(')
                return false;
            
            else if (current == ']' && stack.pop() != '[')
                return false;
            
            else if (current == '}' && stack.pop() != '{')
                return false;
        }
        
        return stack.isEmpty();
    }
}