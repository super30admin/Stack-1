// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        if(nums == null || nums.length == 0)
            return new int[]{0};

        int n = nums.length;
        Stack<Integer> stack = new Stack();

        int[] result = new int[n];
        Arrays.fill(result, -1);

        boolean flag = false; //flag to check if stack top is eqaul to index of incoming element - we then need to stop

        //we have to go over the array twice
        for(int i=0; i<2*n; i++) {

            if(flag)
                break;

            // % so that we don't go out of bounds of array
            while(!flag && !stack.isEmpty() && nums[i%n] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i%n];

                //we are in second iteration of array and top index = incoming index
                if(i > n && i%n == stack.peek())
                    flag = true;
            }

            //incoming element is smaller than stack top
            stack.push(i%n);
        }
       return result;
    }
}
