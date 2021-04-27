//TC: O(2*n)
//SC:O(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[T.length];
        stack.add(0);
        for(int i=1;i<T.length;i++)     //Adding all the index to stack at first,
        {                               //Upon finding the next greatest value, finding the difference between index on top of stack and present element index and adding it to result array.
            while(!stack.isEmpty()&&T[stack.peek()]<T[i])
            {
                output[stack.peek()] = i-stack.pop();
            }
            stack.add(i);
        }
        return output;
    }
}