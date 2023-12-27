// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            int temp = temperatures[i];                                        // take temperature one by one
            while(!stack.isEmpty() && temperatures[stack.peek()] < temp) {     // remove all temperature less than this one
                int ind = stack.pop();                           
                res[ind] = i-ind;                                              // put difference of indexes in result
            }
            stack.push(i);
        }
        return res;
    }
}
