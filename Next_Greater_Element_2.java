
class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int []result = new int[nums.length];
       Stack<Integer> stack = new Stack<>();
       for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
        }
       for(int i =0; i<2*nums.length;i++) {

           while(!stack.isEmpty() && nums[i%nums.length] > nums[stack.peek()]) {
               int value = stack.pop();
               result[value] = nums[i%nums.length];
           }
           if(i < nums.length) {
            stack.push(i);
           }
       }
       return result;
    }
}