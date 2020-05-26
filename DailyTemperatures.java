// Brute Force
// Time COmplexity: O(n)
// Space Complexity considering space for resultant array: O(n)
 class Solution {
     public int[] dailyTemperatures(int[] T) {
         int[] res = new int[T.length];

         for(int i = 0; i < T.length; i++) {
             for(int j = i + 1; j < T.length; j++) {
                 if(T[j] > T[i]) {
                     res[i] = j - i;
                     break;
                 }
             }
         }
         return res;
     }
 }

// Time COmplexity: O(n)
// Space COmplexity: O(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        for(int i = T.length - 1; i>=0; i--) {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}