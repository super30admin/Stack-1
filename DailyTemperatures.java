import java.util.Stack;

//Time Complexity : O(n) where n = length of temperatures array
//Space Complexity : O(n) where n = length of temperatures array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//739. Daily Temperatures (Medium) - https://leetcode.com/problems/daily-temperatures/
// Time Complexity : O(n*n) where n = length of temperatures array
//class Solution {
//    public int[] dailyTemperatures(int[] temperatures) {
//        int n = temperatures.length;
//        int[] result = new int[n];
//        
//        for (int i = 0; i < n-1; i++) { // O(n)
//            for (int j = i+1; j < n; j++) { // O(n)
//                if (temperatures[j] > temperatures[i]) {
//                    result[i] = j-i;
//                    break;
//                }
//            }
//        }
//        
//        result[n-1] = 0;
//        
//        return result;
//    }
//}

// Time Complexity : O(n) where n = length of temperatures array
// Space Complexity : O(n) where n = length of temperatures array
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        if (temperatures == null || temperatures.length == 0) return new int[0];
        
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // O(n)  
        
        for (int i = 0; i < n; i++) { // O(n)
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int popped = stack.pop();
                result[popped] = i - popped;
            }
            
            stack.push(i);
        }
        
        return result;
    }
}