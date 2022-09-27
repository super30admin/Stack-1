import java.util.Arrays;
import java.util.Stack;

//Time Complexity : O(2*n) where n = length of nums array
//Space Complexity : O(n) where n = length of nums array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//503. Next Greater Element II (Medium) - https://leetcode.com/problems/next-greater-element-ii/
//Time Complexity : O(n*n) where n = length of nums array
//Space Complexity : O(1)
//class Solution {
// public int[] nextGreaterElements(int[] nums) {
//     int n = nums.length;
//     int[] result = new int[n];
//     
//     for (int i = 0; i < n; i++) { // O(n)
//         int j = i+1;
//         
//         while (j < n) { // O(n)
//             if (nums[j] > nums[i]) {
//                 result[i] = nums[j];
//                 break;
//             }
//             j++;
//         }
//         
//         if (j == n) {
//             j = 0;
//         }
//         
//         while (j < n) {
//             if (nums[j] > nums[i]) {
//                 result[i] = nums[j];
//                 break;
//             } else if (j == i) {
//                 result[i] = -1;
//                 break;
//             }
//             j++;
//         }
//     }
//     
//     return result;
// }
//}

// Time Complexity : O(2*n) where n = length of nums array
// Space Complexity : O(n) where n = length of nums array
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < 2*n; i++) { // O(2*n)
            while (!stack.isEmpty() && nums[i%n] > nums[stack.peek()]) {
                int popped = stack.pop();
                result[popped] = nums[i%n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        
        return result;
    }
}