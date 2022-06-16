// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public int[] NextGreaterElements(int[] nums) {
    if(nums == null || nums.Length == 0)
        return new int[0];
    
    int n = nums.Length;
    int[] result = new int[n];
    for(int i = 0; i < n; i++)
    {
        result[i] = -1;
    }
    
    Stack<int> numsStack = new Stack<int>();
    //run loo twice because of circular array
    for(int i = 0; i < n * 2; i++)
    {
        //If new element is greater than top of stack element
        //Pop it, replaces the value at poped index from stack with bigger element in result array
        //it goes in circular array, we need to to mod with n, so that i always lies inside n
        while(numsStack.Count > 0 && nums[i%n] > nums[numsStack.Peek()])
        {
            int top = numsStack.Pop();
            result[top] = nums[i%n];
        }
        //in second iteration, we dont need to push anything inside stack
        //becaus of circular array, there will be element in end which might have bigger element before it. 
        if(i < n)
            numsStack.Push(i);
    }
    
    return result;
}