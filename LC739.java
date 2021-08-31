class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int[] output = new int[T.length];
        
        if(T.length == 0 || T == null){
            return output;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < T.length; i++){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int pop = stack.pop();
                output[pop] = i - pop;
            }
            stack.push(i);
        }
        
        return output;
    }
}

//Time : O(n)
//Space : O(n)