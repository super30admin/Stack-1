// Time Complexity - O(3n)
// Space Complexity - O(n)
// Approach
// Push numbers into stack. As soon as greater number appears, resolve peek and store the
// greater no at the idx of peek ele. The arr will run twice the len since its a circular array where
// the array needs to be revisited for comparisons and two passes will be able to give us decision for all numbers.
// Push no into stack while it is less than len since after that our top ele changes and the comparisons changes diverting us
// from the original comparison

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        if(nums == null || nums.length == 0) return result;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 2 * n; i++){
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]){
                int index = st.pop();
                result[index] = nums[i % n];
            }
            if(i < n) st.push(i % n);
        }
        return result;
    }
}