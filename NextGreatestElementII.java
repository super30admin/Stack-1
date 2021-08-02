class Solution {
    public int[] nextGreaterElements(int[] nums) {

        //Was not sure how to implement this, will come back to update
        Stack<Integer> nums = new Stack<>();

        for (int i=0; i<nums.length; i++) {

            nums.add(nums[i]);

        }

        while (!nums.isEmpty()) {

            nums.pop();

        }

    }
}