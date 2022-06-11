using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class DailyTemp
    {
        /*
         * T.C: O(N) : where N is number of temeperatures
         * S.C: O(N) : where number of items in the stack
         * 
         */
        public int[] DailyTemperatures(int[] temperatures)
        {
            if (temperatures == null || temperatures.Length == 0) return new int[] { };

            Stack<int> stack = new Stack<int>();
            int[] result = new int[temperatures.Length];


            for (int i = 0; i < temperatures.Length; i++)
            {
                while (stack.Count != 0 && temperatures[i] > temperatures[stack.Peek()])
                {
                    int top = stack.Pop();
                    result[top] = i - top;
                }

                stack.Push(i);
            }

            return result;
        }
    }
}
