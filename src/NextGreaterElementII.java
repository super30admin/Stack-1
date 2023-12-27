// Time Complexity:  O(n)
// Space Complexity: O(n)
// where n is length of given array

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<2*n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]) {      // if incoming number is greater than top element
                result[stack.pop()] = nums[i%n];                             // then update "result" according to the top element index
            }
            if(i<n) {
                stack.push(i);                                               // push iff index is less than length of array
            }                                                  
        }
        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;                                        // last element would be the greatest among the all
        }
        return result;
    }
}
