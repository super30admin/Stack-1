//Time Complexity : O(n)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length==0){
            return new int[]{ };
        }
        int result[] = new int[nums.length];
        Arrays.fill(result,-1);//initially fill the result array with -1
        //use stack to keep track of indexes of numbers who are yet to find the next greter number
        Stack<Integer> stack = new Stack<>();
        stack.push(0);//initially push the first index
        for(int i=1;i<2*nums.length;i++){
            //i<2*nums.length is used as the nums array is cyclic and at max the array will be iterated twice the length of the array
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%nums.length]){
                //i%nums.length (as i< 2*nums.length)is used to get the correct value of the index and to avoid out of bound exception
                int idx = stack.pop();
                result[idx] = nums[i % nums.length];
            }
            //otherwise just push in stack
            if(i < nums.length){
                //here we just push the first pass elements hence not i%nums.length
                stack.push(i);
            }
        }
        return result;
    }
}