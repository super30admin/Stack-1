// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 1 brute force
    public static int[] dailyTemperatures1(int[] temperatures) {
        // null case
        if (temperatures == null || temperatures.length == 0)
            return new int[] {};
        int n = temperatures.length;
        // result array
        int[] result = new int[n];
        // first I will select one daty and get it warmer day by checking all the next
        // days
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    // approch 2 using stack
    public static int[] dailyTemperatures2(int[] temperatures) {
        // null case
        if (temperatures == null || temperatures.length == 0)
            return new int[] {};
        int n = temperatures.length;
        // result array
        int[] result = new int[n];
        // stack for checking nearest greater temperature
        Stack<Integer> st = new Stack<>();
        // for loop for adding index of all elements in the stack
        // and whenever we found any element that is greater than stack
        // pop from the stack and add diffrence of index in result
        // array
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int idx = st.pop();
                result[idx] = i - idx;
            }

            // push into stack
            st.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(dailyTemperatures1(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures2(temperatures)));
    }
}