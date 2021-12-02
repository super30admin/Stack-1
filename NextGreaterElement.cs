using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Stack
{
    internal class NextGreaterElementII
    {
        //TC: O(n)
        //SC:O(1)
        public int[] NextGreaterElements(int[] nums)
        {
            if (nums == null || nums.Length == 0) return new int[] { };
            int n = nums.Length;
            int[] result = new int[n];
            Array.Fill(result, -1);
            Stack<int> s = new Stack<int>();
            for (int i = 0; i < 2 * n; i++)
            {
                while (s.Count != 0 && nums[i % n] > nums[s.Peek()])
                {
                    int idx = s.Pop();
                    result[idx] = nums[i % n];
                }
                if (i < n)
                {
                    s.Push(i);
                }
            }
            return result;
        }
    }
}
