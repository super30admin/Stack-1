// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++){
            int temp = temperatures[i];
            while(!stk.isEmpty() && temperatures[stk.peek()] < temp){
                int cur = stk.pop();
                result[cur] += i - cur;
            }
            stk.push(i);
        }

        return result;
    }
}