//TC : O(N + N) === O(2N) === O(N) -- N = temperatures.length
//SC : O(1)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)    return new int[0];
        int[] res = new int[temperatures.length];
        
        Arrays.fill(res, 0);
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for(int i = 0; i< temperatures.length; i++){
            
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int top = stack.pop();               
                res[top] = i - top;
            }
            stack.push(i);
            
        }
        return res;
    }
}