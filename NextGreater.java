// Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. 
// TC O(N) SC O(1)
// Loop through all the elements max twice to find an element greateer than the current. If current element is greater than top of stack, then add the current element to the result at the index of the popped element
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int [] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stk = new Stack<Integer>();
        int n = nums.length;
        for (int i = 0; i< 2* n; i++) {
             while (!stk.isEmpty() && nums[i%n] > nums[stk.peek()]) {
                int index = stk.pop();
                res[index] = nums[i%n];
            }
            
            stk.push(i%n);
        }
        return res;
    }
}
