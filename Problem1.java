//time o(n)
//space o(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int top = stack.pop();
                res[top] = i-top;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
        
    }
}
