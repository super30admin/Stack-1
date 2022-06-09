class Solution {

    // Time Complexity : 0(n) where n is the length of the nums array
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0 || nums == null){
            return new int[]{};
        }
        int n = nums.length;
        int [] result = new int[n];
        Arrays.fill(result, -1);    //we initially fill the array with -1 as if there is no greater element thatn the current index then we are supposed to return -1
        Stack <Integer> s = new Stack<>();
        for(int i = 0; i < 2*n; i++){   //we do i%n later because the indexes run from 0 to n-1 but we are traversing the array twice as it is a circular array
            while(!s.isEmpty() && nums[i%n] > nums[s.peek()]){ //we check if the stack is empty or not and also compare the current nums with the nums at top of the stack. If the current nums is greater than we
                int temp = s.pop(); //pop the top of the stack
                result[temp] = nums[i%n];   //and store the greater no int result array in the index to which it initially existed in nums array
            }
            if(i < n){  //we are only adding elements in our stack at 1st traversal from 0 to n as if we enter again, then we will have duplicates
                s.push(i);
            }
        }
        return result;
    }
}