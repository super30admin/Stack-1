// time complexity - O(4n)
//Space Complexity - O(n)
public class Solution
{
    public int[] NextGreaterElements(int[] nums)
    {
        int n = nums.Length;
        int[] res = new int[n];
        Array.Fill(res, -1); //O(n)
        Stack<int> st = new Stack<int>();
        for (int i = 0; i < 2 * n; i++) //(O2n)
        {
            while (st.Count != 0 && nums[i % n] > nums[st.Peek()]) //O(n)
            {
                int popped = st.Pop();
                res[popped] = nums[i % n];
            }
            if (i < n)
            {
                st.Push(i);
            }
        }
        return res;
    }
}