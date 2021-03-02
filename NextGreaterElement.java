// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;

        //iterate through the array twice
        //double iteration is required as array is circular
        //hence will use current index as i % n
        for(int i=2*n-1; i>=0 ; i--){
            //if stack is not empty, check if current element is less than peek of stack
            //if not pop from stack until greater element is found
            while(!stack.isEmpty() && nums[i % n] >= nums[stack.peek()]){
                stack.pop();
            }
            //if greater element is not found till stack empty put -1
            if(stack.isEmpty())
                result[i % n] = -1;
                //else put stack peek
            else
                result[i % n] = nums[stack.peek()];
            //push current element
            stack.push(i % n);
        }

        return result;
    }
}