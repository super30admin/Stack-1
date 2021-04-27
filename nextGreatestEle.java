//TC: O(2*n)
//SC: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length==0)
            return nums;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for(int i=0;i<2*nums.length;i++)       // Traversing twice the length of array so that upon reaching the end we can traverse from index 0 as it is given, it is a circular array
        {
            int x = i%nums.length;      //So we add all the eleements to stack at first and upon finding greater element than the element on top of stack.
            while(!stack.isEmpty() && nums[stack.peek()]<nums[x])
            {
                res[stack.pop()] = nums[x];
            }
            if(i<nums.length)
                stack.add(x);
        }
        return res;
    }
}