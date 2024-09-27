// Brute Force
// Time Complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1 ; j < (2 * nums.length); j++) {
                int k = j % nums.length;
                if(nums[k] > nums[i]) {
                    res[i] = nums[k];
                    break;
                }
            }
        }
        return res;
    }
}

// Time COmplexity: O(n)
// Space Complexity: O(n)
 class Solution {
     public int[] nextGreaterElements(int[] nums) {
         int[] res = new int[nums.length];
         Arrays.fill(res, -1);
         Stack<Integer> stack = new Stack<>();

         for(int i = 0; i < (2 * nums.length); i++) {
             int k = i % nums.length;
             while(!stack.isEmpty() && nums[stack.peek()] < nums[k]) {
                 int popped = stack.pop();
                 res[popped] = nums[k];
             }
             if(res[k] == -1) {
                 stack.push(k);
             }
         }

         return res;
     }
 }