import java.util.Stack;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length==0 || temperatures==null)
        {
            return new int[]{};
        }
        int[] res= new int[temperatures.length];
        Stack<Integer> s= new Stack();
        for(int i=0;i<temperatures.length; i++)
        {
            while(!s.isEmpty() && temperatures[i]> temperatures[s.peek()])
            {
                int popped=s.pop();
                res[popped]=i-popped;

            }
            s.push(i);
        } 
        return res;
    }
}