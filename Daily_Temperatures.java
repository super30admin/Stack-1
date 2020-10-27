//Time Complexity-O(n+n)
//Space Complexity-O(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T.length==0||T==null)
        {
            return new int[0];
        }
        int[]output=new int[T.length];
        Stack<Integer>stack=new Stack();
        for(int i=0;i<T.length;i++)
        {
            while(!stack.isEmpty()&&
                 T[i]>T[stack.peek()])
            {
                int pop=stack.pop();
                output[pop]=i-pop;
            }
            stack.push(i);
        }
        return output;
    }
}