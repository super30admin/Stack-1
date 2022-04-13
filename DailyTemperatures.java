// Time Complexity : O(n) n - temperatures present
// Space Complexity : O(n) n - temperatures; stack size will be n; if all in decreasing no greater elem is present
// Did this code successfully run on Leetcode : Yes;(https://leetcode.com/submissions/detail/679841231/)
// Any problem you faced while coding this : No;
// My Notes : IF elem greater than found; then update the previous one and push the curr one till the top is greater or all decreasing elems
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        
        // Iterate the nums array and check if greater elem found
        for(int i=0;i<temperatures.length;i++){
            // If greater elem found; then pop and update after what index position it is found
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[1]){
                    int[] prevElem = stack.pop();
                    result[prevElem[0]] = i - prevElem[0];
            }
            stack.push(new int[]{i,temperatures[i]});
        }
        
        // remaining elems in stack are already 0; so you can ignore the stack
        // while(!stack.isEmpty()){
        //     result[stack.pop()[0]] = 0;
        // }
        return result;
    }
}