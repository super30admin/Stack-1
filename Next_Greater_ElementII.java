//Time Complexity-O(2n+n)
//Space Complexity-O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length==0||nums==null)
        {
            return new int[0];
        }
        int[]output=new int[nums.length];
        Arrays.fill(output,-1);
        Stack<Integer>stack=new Stack();
        for(int i=0;i<nums.length*2;i++)
        {
            int x=i%nums.length;
            while(!stack.isEmpty()&&
                 nums[x]>nums[stack.peek()])
            {
                int index=stack.pop();
                output[index]=nums[x];
            }
            if(output[x]==-1)
            {
                stack.push(x);
            }
        }
        return output;
    }
}