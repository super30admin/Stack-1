//TC = O(N)
//SC = O(N)
/*
 * We are using monotonic stack to solve this problem. 
 */

import java.util.*;

public class DailyTemperatures{

    public static int[] dailyTemp(int[] temp)
    {
        if(temp == null || temp.length == 0) return new int[]{};

        Stack<Integer> s = new Stack<>();
        int[] result = new int[temp.length];

        for(int i =0;i<temp.length;i++)
        {
            while(!s.isEmpty() && temp[i]>temp[s.peek()])
            {
                int top = s.pop();
                result[top] = i - top;
            }
            s.push(i);
        }

        return result;
    }

    public static void main(String args[])
    {
        int[] temp = {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemp(temp);

        for(int i:ans)
        {
            System.out.print(i+" ");
        }
    }
}