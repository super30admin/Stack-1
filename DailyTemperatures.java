//https://leetcode.com/problems/daily-temperatures/
// Time Complexity :O(n)  
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int[] dailyTemperatures(int[] t) {
        int[] result=new int[t.length];
        Stack<Integer> st = new Stack<>();
        //Monotonic increasing stack method 
        //if you can not resolve the peek element you can not resolve elements under it
        //in this case we maintain the indexes
        for(int i=0;i<t.length;i++)
        {
            while(!st.isEmpty() && t[i]>t[st.peek()])
            {
                int peek=st.pop();
                result[peek]=i-peek;
            }
            st.push(i);
        }
        return result;
        
        
    }
    private int[] bruteforce(int[] temperatures)
    {
        int[] result=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++)
        {
            result[i]=nextwarm(temperatures,i);
        }
        return result;
    }
    private int nextwarm(int[] nums, int i) 
    {
        int temp=nums[i]; 
        int k=i; 
        i++; 
        while(i<nums.length && temp>=nums[i])
        {
            i++; 
        }
        if(i==nums.length)
            return 0;
        return i-k;
        
    }
}