// Time Complexity : O(3n) 2n for travelling array twice + n for stack pop
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : nopes
class SolutionTwo {
    public int[] nextGreaterElements(int[] nums)
    {
        if(nums==null || nums.length == 0)
            return new int[0];

        int[] result = new int[nums.length];

        Stack<Integer> stack = new Stack();


        int no = nums.length;

        Arrays.fill(result,-1);

        //we are running in circular motion twice
        for(int i=0;i<2*no;i++)
        {
            //here we take module because we are travelling array twice and it will go out of bounds
            while(!stack.isEmpty() && nums[i%no]>nums[stack.peek()])
            {
                result[stack.pop()] = nums[i%no];
            }
            //We are pushing on while travelling first time, we are not pushing anything while travelling next time
            if(i<no)
                stack.push(i);
        }

        return result;
    }
}