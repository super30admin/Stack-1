//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;
import java.util.Stack;
class Daily_Temperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0)
            return new int[0];
        Stack<Integer> st = new Stack<>();
        int[] result = new int[T.length];
        int index;
        for(int i = 0; i < T.length; i++)
        {
            while(!st.isEmpty() && T[i] > T[st.peek()])
            {
                index = st.pop();
                result[index] = i - index;
            }
            st.push(i);
        }
        return result;
    }
    public static void main(String[] args)
    {
    	int[] arr = {73,74,75,71,69,72,76,73};
    	int n = arr.length;
    	Daily_Temperatures_739 temperature = new Daily_Temperatures_739();
    	int[] result = new int[n];
    	result = temperature.dailyTemperatures(arr);
    	for(int i : result)
    		System.out.print(i + " ");
    }
}
