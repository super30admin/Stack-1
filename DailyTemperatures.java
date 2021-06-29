/* Approach:
1. The trick here is to use a stack. 
2. Keep adding the indexes of the elements that are smaller than their next element, 
the moment you find an element that is greater, start going back in the array checking all other elements are smaller too (and they should be).

Time complexity: Worst case : O(2N) : [73,72,71,70,69,74], first N to reach to 74, second N cause we will go back in stack till 73.

Space complexity: Worst case: O(N)
*/

import java.util.*;
class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i< temperatures.length-1; i++)
        {
            if(temperatures[i]<temperatures[i+1])
            {
                results[i] = 1;
                while(!stack.isEmpty() && temperatures[i+1] > temperatures[stack.peek()])
                {
                    results[stack.peek()] = i+1-stack.pop();
                }
            }
            else
                stack.push(i);
        }
        return results;
    }
}