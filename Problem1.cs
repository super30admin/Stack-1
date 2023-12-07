public class Solution
	{
        // Time Complexity : O(n)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int[] DailyTemperatures(int[] temperatures)
        {
            if (temperatures == null || temperatures.Length == 0)
                return new int[0];
            int n = temperatures.Length;
            int[] result = new int[n];
            Stack<int> st = new Stack<int>();
            for (int i = 0; i < n; i++)
            {
                while (st.Count > 0 && temperatures[i] > temperatures[st.Peek()])
                {
                    int popped = st.Pop();
                    result[popped] = i - popped;
                }
                st.Push(i);
            }
            return result;
        }
    }
