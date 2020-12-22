package Dec21;

import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        
        // Space complexity = O(n) when we get all colder days as we progress in the array and largest element is at the end of the stack
       // When putting all elements in stack => O(n)
       // When resolving elements in stack => O(n)
       // So, O(n) + O(n) ~= O(n)
        // Time complexity = O(n) 
        
        /* Approach:
            Use a stack because last in will be resolved first compared to first in.
            
            Steps:
            Step 1: Store unresolved index of current input array element in the stack.
            Step 2: Move the pointer to next element in the array and compare if element at pointer index > element at stack peek index
            Step 3: If yes, i.e. element at pointer index > element at stack peek index - then index inside stack is resolved now. a) We have got a warmer day for the index inside stack, so pop this from the stack. b) Add in result array: ptr - stackpeek
            Step 4: If no, dont pop from stack and move the pointer to next element in the array and compare if element at pointer index > element at stack peek index. 
                    Keep comparing if ptr indexed element > stackpeek index element. 
                    If yes, do prev step, i.e. pop from stack and add in result array. 
                    Don't move the pointer and compare ptr array to new stackpeek indexed element.   
        */
        
        // edge
        if (T == null || T.length == 0)  {
            return new int[]{};
        }
        
        int[] result = new int[T.length];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < T.length; i++) {
            while (!st.isEmpty() && T[i] > T[st.peek()]) {
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        
        
        return result;
    }
}