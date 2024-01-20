/*
 * Apperoach: 
 * take a curr poointer, and loop through the entire array ffrom next pointer till end. 
 * if never fund the value, than reset the next pointer at 0; and run till curr pointer. 
 * 
 * worst case scenarios : 
 * TC: O(n*n)
 * sc: O(1)
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // base case
        if (nums == null)
            return result;

        Arrays.fill(result, -1);

        boolean found = false;

        for (int i = 0; i < n; i++) {
            found = false;
            int curr = nums[i];
            int j = i + 1;

            while (!found && j < n) {
                if (nums[i] < nums[j]) {
                    result[i] = nums[j];
                    found = true;
                    break;
                }
                j++;
            }

            j = 0;
            while (!found && i > j) {
                if (nums[i] < nums[j]) {
                    result[i] = nums[j];
                    found = true;
                    break;
                }
                j++;
            }
        }

        return result;
    }
}
