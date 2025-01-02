# Stack-1

## Problem1 Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)
## Time Complexity:O(2n) Space Complexity:O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int n=temperatures.length;
        int[] result=new int[n];
        st.push(0);

        for(int i=1;i<n;i++)
        {
           
          while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()])
          {
            int popped=st.pop();
            result[popped]=i-popped;

          }
          st.push(i);
         

        }
        return result;
    }
}
## Problem2 Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)
## Time Complexity:O(2n) Space Complexity:O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        Stack<Integer> st=new Stack<>();
        Arrays.fill(result,-1);
        for(int i=0;i<(2*n);i++)
        {
           

            while(!st.isEmpty() && nums[i%n]>nums[st.peek()])
            {
                int popped=st.pop();
                result[popped]=nums[i%n];
            }
            st.push(i%n);
            
        }
        return result;
    }
}