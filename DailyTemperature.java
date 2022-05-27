// O(n) time: in worst case, every element pushed and popped once = O(2n) = O(n)
// O(n) space for stack, n elements

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // stack for indexes of temperatures
        
        for (int currDay = 0; currDay < n; currDay++){
            int currTemp = temperatures[currDay];
            
            // pop until current day's temp is not warmer than temp at top of stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < currTemp){
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            
            stack.push(currDay);
        }
        return answer;
    }
}