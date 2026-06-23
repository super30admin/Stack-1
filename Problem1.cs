// Time Complexity : O(n)
// Space Complexity : O(n) space for monotonic decreasing stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
I use a monotonic decreasing stack wherein I store indices of the temperatures array. I traverse through the temperatures array and
while the stack is not empty and current temperature is greater than temperature on the top of the stack, I update the ith element
of result array with number of days to wait till the next warmer day. At the end, I push the current index to the stack.
*/

public class Solution
{
    public int[] DailyTemperatures(int[] temperatures)
    {
        Stack<int> st = new();
        int size = temperatures.Length;
        int[] result = new int[size];

        for (int i = 0; i < size; i++)
        {
            while (st.Count > 0 && temperatures[st.Peek()] < temperatures[i])
            {
                int current = st.Pop();
                result[current] = i - current;
            }

            st.Push(i);
        }

        return result;
    }
}