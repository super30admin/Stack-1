// Time complexity: O(N) 
// Space complexity: O(w) where w is the number of allowed values for T[i]

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for(int i = T.length-1; i >= 0; --i ){
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() -i;
            stack.push();
        }
        return ans;
    }
}
