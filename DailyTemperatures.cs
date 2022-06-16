// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

 public int[] DailyTemperatures(int[] temperatures) {    
    if(temperatures == null || temperatures.Length == 0)
        return new int[0];
    
    int[] result = new int[temperatures.Length];
    
    Stack<int> tempStack = new Stack<int>();
    for(int i = 0; i < temperatures.Length; i++)
    {
        //compare the top of stack with new element
        //If new element is greater than top of stack element
        //Pop it, take difference of index and put in result array
        while(tempStack.Count > 0 && temperatures[i] > temperatures[tempStack.Peek()])
        {
            int top = tempStack.Pop();
            result[top] = i - top;
        }
        tempStack.Push(i);
    }
    
    return result;
}