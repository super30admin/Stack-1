import java.util.Stack;

public class DailyTempratures {
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    /*
    Starting from start: Monotonic decreasing stack:
    We have to resolve, we have to find out that current element is resolving any of the previous numbers
    if it giving me a warmer day than any of the previous days
    [73,74,75,71,69,72,76,73]
    put index 0 in stack, whose value is 73
    check 74 (index = 1), it is greater than 73, i.e it resolves 73 
    so we put (index of current element element - previous smaller element = 1) in the resultant array
    put 74 in the stack, check 75, it is greater so it resolves 74, 2-1 =1
    put 75, check 71 no, put 71 in the stack as current element
    check 69 with top of stack, it's not greater, put it in the stack, 
    72 resolves 69 and 71 
    76 is greater than top of stack [75], so it resolves 75
   If all elements are in decreasing order except the last one, so stack will be full,
   last element would resolve all
    so worst case time complexity O(2n) space would be O(n)
    */
    /*
     Starting from end: Monotonic increasing stack
    */

    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures==null || temperatures.length ==0) return new int[0];
        int[] result = new int[temperatures.length];
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<temperatures.length;i++)
        {
            //current element is greater than top of the stack
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
            {
                int popped = stack.pop();
                //resolve the popped element
                result[popped] = i-popped;

            }
            stack.push(i);
        }
        
        return result;

    }


}