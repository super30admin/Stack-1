//Time Complexity = O(2N)
// Space Complexity = O(N) for the result
// Used Monotonic decreasing stack, so when ever we encounter a larger temperature than stack.peek we will pop and process it in the result.
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stk = new Stack<>();
        for(int i =0; i<temperatures.length; i++ ){
            while(!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]){
                result[stk.peek()] = i - stk.pop();
            }
            stk.add(i);
        }
        return result;
    }
}