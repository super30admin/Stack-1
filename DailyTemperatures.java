// TC: O(n)
// SC: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }
        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for(int i = temperatures.length - 1; i >= 0; i--) {
            while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            if(!s.isEmpty()) {
                result[i] = s.peek() - i;
            }
            s.push(i);
        }
        return result;
    }
}