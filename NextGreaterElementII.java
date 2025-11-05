/*
* Approach:
    - Similar to daily temperatures but the catch is this is a circular integer array
    - So, we need to iterate the array twice in order to get the next greater element for every element possible
    - Idea is to fill the array with -1 as there can be duplicates in the array
    - Iterate over the nums arrays twice but add elements to the stack only during the first iteration and as soon as the index at the peek matches the current index that can only happen in the second round, we can break the loop and return the result
    - TC: O(n) -> 2n for iterating over the array twice and n for removing the elements from the stack
    - SC: O(n) -> at max n size stack space
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[n];
        Arrays.fill(res, -1);

        for(int i = 0; i < 2*n; i++){
            while(!stack.isEmpty() && nums[i%n] > nums[stack.peek()]){
                int poppedIdx = stack.pop();
                res[poppedIdx] = nums[i%n];
            }
            if(!stack.isEmpty() && stack.peek() == i%n)
                break;
            if(i < n)
                stack.push(i%n);
        }
        return res;
    }
}