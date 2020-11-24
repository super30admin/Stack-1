// Time Complexity: O(N)
// Space Complexity: O(N)
// Passed Leetcode

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (stack.size() > 0 && T[i] > T[stack.peek()]) {
                int temp = stack.pop();
                result[temp] = i - temp;
            }
            stack.add(i);
            
        }
        return result;
        
    }
}