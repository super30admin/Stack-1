// Time complexity - O(n)
// space complexity - O(n)
// Solved on leetcode - yes
// faced any issues - No
// Travesing util the greater elemnt is found and adding into the stack, if greater is found, pop an element and compare with each element in the stack and update the result
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        int currentIndex = 0;
        for(int i=0;i<temperatures.length;i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    result[stack.peek()] = i-stack.peek();
                    stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
