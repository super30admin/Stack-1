// https://leetcode.com/problems/daily-temperatures/
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<temperatures.length;i++)
        {
            
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
            {
                int n=stack.pop();
                temperatures[n]=i-n;
            }
            stack.push(i);

        }
        while(!stack.isEmpty())
        {
            temperatures[stack.pop()]=0;
        }
        return temperatures;   
    }
}



// Your code here along with comments explaining your approach

// https://leetcode.com/problems/next-greater-element-ii/
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int res[]=new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<2*n;i++)
        {
            while(!stack.isEmpty() && nums[i%n]>nums[stack.peek()])
            {
                int pos=stack.pop();
                res[pos]=nums[i%n];
            }
            if(i<n)
                stack.push(i);
        }
        return res;
    }
}
