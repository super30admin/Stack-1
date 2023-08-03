// Time Complexity :O(N), where N is the number of elements in the input array T.
// Space Complexity : O(N), where N is the number of elements in the input array T.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// We employ a stack-based approach to efficiently track the indices of temperatures that are yet to find a warmer day. The algo iterates through the input array of temperatures, and for each temperature, it checks if the stack is non-empty and the current temperature is greater than the temperature at the index stored at the top of the stack. If this condition is met, it means a warmer temperature has been found for the temperature at the top of the stack. The algorithm then pops the index from the stack, calculates the difference in days between the current index and the popped index (indicating the number of days until a warmer temperature), and stores this information in the result array at the index of the popped temperature.Subsequently, the current index is pushed onto the stack since it still needs to find a warmer temperature. This process continues for each temperature in the input array. After the loop completes, the algorithm returns the result array, which contains the calculated days until a warmer temperature for each corresponding day.

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        // Handle edge cases: if T is null or empty, return an empty array
        if (T == null || T.length == 0)
            return new int[0];
        Stack<Integer> st = new Stack<>();
        int[] result = new int[T.length];
        // Traverse through Array
        for (int i = 0; i < T.length; i++) {

            while (!st.isEmpty() && T[i] > T[st.peek()]) {
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();

        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = dailyTemperatures.dailyTemperatures(temperatures);

        System.out.println("Original Temperatures: " + Arrays.toString(temperatures));
        System.out.println("Days until warmer temperature: " + Arrays.toString(result));
    }
}