/* Time Complexity : O(2n^2) ~ O(n^2)
 *   n - length of array - nums  */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Brute Force

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i = 0; i < n; i++){
            for(int j = i; j < 2*n; j++){
                int temp =  j % n;
                if(res[i] == -1 && nums[temp] > nums[i]){
                    res[i] = nums[temp];
                    break;
                }
            }
        }
        return res;
    }
}