using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(N) 
    // Space Complexity :O(N) 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No 
    public class DailyTemperatures
    {
        public int[] DailyTemperaturesProb(int[] temperatures)
        {
            int[] result = new int[temperatures.Length];
            if (temperatures == null || temperatures.Length == 0) return result;
            Stack<int> st = new Stack<int>();
            st.Push(0);
            for (int i = 1; i < temperatures.Length; i++)
            {
                while (st.Count != 0 && temperatures[i] > temperatures[st.Peek()])
                {
                    int curr = st.Pop();
                    result[curr] = i - curr;
                }
                st.Push(i);
            }
            return result;

        }
    }
}
