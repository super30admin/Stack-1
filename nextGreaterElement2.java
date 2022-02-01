// Time complexity = O(n)
// Space complexity = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We use a stack to keep the indexes of the numbers what still dont have a greater number, once we find a greater number we put the greater number in the stack indexes
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};

        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];

        Arrays.fill(result, -1);
        s.push(0);

        // We iterate the array twice to make sure we are covering all the possible spots, since the array is circular
        for (int i=1; i < 2*n; i++) {
            while (!s.isEmpty() && nums[i%n] > nums[s.peek()]) {
                int index = s.pop();
                result[index] = nums[i%n];
            }

            if(i<n) {
                s.push(i);
            }
        }

        return result;
    }
}