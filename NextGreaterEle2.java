// Time Complexity : O(3n) where n is the number of elements in the array
// Space Complexity : O(n) where n is the number of elements in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Push the numbers in the stack. As soon as a greater number appears, resolve the peek
and store the greater number at the index of the peek element. The array will run twice the length since its a circular array where the array needs
to be revisited for comparisons and two passes will be able to give us a decision for all the numbers. Push the number in the stack while it is less
than length since after that our top element changes and the comparisons changes diverting us from the original comparison (number that was needed to be compared).
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);                                                                            // Index will not be filled if the number doesnt have a next greater element
        if(nums == null || nums.length == 0){return result;}
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < 2 * n; i++){                                                                     // Circular array
            while(!stk.isEmpty() && nums[i % n] > nums[stk.peek()]){
                int index = stk.pop();                                                                  // Incoming element is the next greater element
                result[index] = nums[i % n];                                                            // Store the incoming number at peek element's index
            }
            if(i < n){stk.push(i % n);}                                                                         // Till n, fill the stack
        }
        return result;
    }
}