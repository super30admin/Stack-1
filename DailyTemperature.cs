using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Stack
{
    internal class DailyTemperaturesLC
    {

        //TC: O(n)
        //SC: O(1)
        public int[] DailyTemparatures(int[] temperatures)
        {
            if (temperatures == null || temperatures.Length == 0)
            {
                return new int[] { };
            }
            int n = temperatures.Length;
            int[] result = new int[n];
            Stack<int> s = new Stack<int>();
            for (int i = 0; i < n; i++)
            {
                while (s.Count != 0 && temperatures[i] > temperatures[s.Peek()])
                {
                    int idx = s.Pop();
                    result[idx] = i - idx;
                }
                s.Push(i);
            }
            return result;
        }
    }
}
