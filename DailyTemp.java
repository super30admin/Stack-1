/*
  Time:O(n)
  Space:O(n)
  Run on LeetCode: Yes
*/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stk = new Stack<>();
        int ret[] = new int[T.length];
        for(int i = 0 ; i < T.length; i++){
            while(!stk.isEmpty() && T[i] > T[stk.peek()]){
                int top = stk.pop();
                ret[top] = i-top;
            }
            stk.push(i);
        }
        return ret;
    }
}
