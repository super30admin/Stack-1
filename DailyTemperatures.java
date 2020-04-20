//o(n) time and space
//passed all leetcode cases
//used monotonic stack approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for(int i=0;i<T.length;i++){
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int prior = stack.pop();
                result[prior] = i - prior;
            }
            stack.push(i);
        }
        return result;
    }
}