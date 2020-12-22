// Time Complexity : o(2n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class DailyTemp {
    public int[] dailyTemperatures(int[] T) {
        
        if(null == T || T.length == 0) return new int[0];
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<T.length; i++){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
