// time complexity - O(2n)
// Space - O(n) stack
public class Solution
{
    public int[] DailyTemperatures(int[] temperatures)
    {
        int n = temperatures.Length;
        int[] res = new int[n];
        res[n - 1] = 0;
        Stack<int> st = new Stack<int>();

        for (int i = 0; i < n; i++)
        {
            while (st.Count != 0 && temperatures[i] > temperatures[st.Peek()])
            {
                int popped = st.Pop();
                res[popped] = i - popped;
            }
            st.Push(i);
        }
        return res;
        // brute force n^2
        // res[n-1]=0;
        // for(int i=0;i<n-1;i++)
        // {
        //     int j=i+1;
        //     while(j<n-1 && temperatures[i]>=temperatures[j])
        //     {               
        //         j++;
        //     }
        //     if(temperatures[i]<temperatures[j])
        //     {
        //         res[i]= j-i;
        //     }
        //     else
        //     {
        //         res[i]=0;
        //     }
        // }
        // return res;
    }
}