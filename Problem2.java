// time complexity: O(N)
// Space complexity: O(N)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] resArr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i= 2*nums.length-1; i>=0; --i){
            while(!stack.empty() && nums[stack.peek()] <= nums[i%nums.length])             {
                stack.pop();    
            }
            resArr[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return resArr;
    }
}
