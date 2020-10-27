//Daily Temperatures
// Time Complexity :0(n+n)
// Space Complexity :0(n) for stack
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T.length==0 || T==null)
            return new int[0];
        Stack<Integer> stack= new Stack<>();
        int[] output=new int[T.length];
        for(int i=0;i<T.length;i++)
        {
            while(!stack.isEmpty() && T[stack.peek()]<T[i])
            {
                int top=stack.pop();
                output[top]=i-top;
            }
            stack.push(i);
        }
        return output;
    }
}

//Next Greater Element II
// Time Complexity :0(n+n)
// Space Complexity :0(n) for stack
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0)
            return new int[0];
        int[] output= new int[nums.length];
        Arrays.fill(output,-1);
        Stack<Integer> stack= new Stack<>();
        for(int x=0;x<nums.length*2;x++)
        {
            int i= x%nums.length;
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i])
            {
                int top=stack.pop();
                output[top]=nums[i];
            }
            if(output[i]==-1)
                stack.push(i);
        }
        return output;
    }
}
