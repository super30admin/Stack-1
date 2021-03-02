// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class DailyTemperature {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        //iterate through the array from right to left
        for(int i= T.length-1; i>=0; --i){
            //if stack is not empty, check if current element is less than peek of stack
            //if not pop from stack until warmer temp index found or stack empty
            while(!stack.isEmpty() && T[stack.peek()] <= T[i]){
                stack.pop();
            }
            //if stack empty, no warmer temp found hence put 0
            if(stack.isEmpty())
                result[i] = 0;
                //else warmer temp found
            else
                result[i] = stack.peek() - i;
            stack.push(i);
        }

        return result;
    }
}