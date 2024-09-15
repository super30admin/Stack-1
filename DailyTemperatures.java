// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) { //reverse 
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop(); //pop till it empty or the current element is less than peek. Means, stack peek should always be greater than current for us to work.
            
            
            
            //Once done, current answer is the difference between stack peek's index and current index. 
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
