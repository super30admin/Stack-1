using System;
using System.Collections.Generic;
using System.Text;

namespace Array1
{
    class NextGreaterElementII
    {
        /*
         * T.C: O(n) where n is no of element
         * S.C: O(n) where n is no of element in the stack
         * 
         */
        public int[] NextGreaterElements(int[] nums)
        {
            if (nums == null || nums.Length == 0) return new int[] { };



            int n = nums.Length;
            int[] result = new int[n];
            Stack<int> stack = new Stack<int>();
            Array.Fill(result, -1);
            
            for (int i = 0; i < 2 * n; i++)
            {
                while (stack.Count != 0 && nums[i % n] > nums[stack.Peek()])
                {
                    int top = stack.Pop();
                    result[top] = nums[i % n];
                }
                if (i < n)
                {
                    stack.Push(i);
                }
            }

            return result;
        }
    }
}
