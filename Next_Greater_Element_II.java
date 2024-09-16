//503 == https://leetcode.com/problems/next-greater-element-ii/

/* Time: O(n) -> iterating over the whole array twice
   Space: O(n) -> at max we can have all the elemnts in that array if the first element is the largest one.
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return new int[]{};
        
        int n = nums.length;
        int[] result = new int[n];
        /* For the largest element in an array, we will not get next largest so,
           initializing tha array by -1 */
        Arrays.fill(result, -1);
        
        Stack<Integer> stk = new Stack<>();
        
        /* Since the array is a circular array for the last element we have to traverse twice
            thats why consider 2* n here */
        for(int index = 0; index < n * 2; index++)
        {
            /* we are doing index%n to return back to the first element from last element*/
            while(!stk.isEmpty() && nums[index%n] > nums[stk.peek()])
            {
                result[stk.pop()] = nums[index%n];
            }
            
            /* We just want to push all ements in stack only once and not in the second pass */
            if(index < n) stk.push(index%n);
        }
        
        return result;
    }
}
