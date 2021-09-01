// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length==0||nums==null)
            return new int[]{};
        
        Stack<Integer> stack=new Stack<>();
        
        int n=nums.length;
        
        int[] result=new int[n];
        
        Arrays.fill(result,-1);
        
        for(int i=0;i<2*n;i++)
        {
            while(!stack.isEmpty() && nums[i%n]>nums[stack.peek()])
            {
                int item=stack.pop();
                result[item]=nums[i%n];
            }
            
            if(i<n)
                stack.push(i);
        }
        return result;
    }
}
