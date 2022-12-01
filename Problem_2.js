// ## Problem2 Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// TC: O(n)
// SC: O(n)
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElements = function (nums) {
    if (nums === null || nums.length === 0) {
        return [];
    }
    let stack = [];
    stack.push(0);
    let result = new Array(nums.length);
    result.fill(-1);
    // Push the index in monotonic increasing stack
    for (let i = 1; i < nums.length; i++) {
        // If incoming number is higher, add stack values which are lower to the result
        while (stack.length > 0 && nums[i] > nums[stack[stack.length - 1]]) {
            result[stack.pop()] = nums[i];
        }
        stack.push(i);
    }
    for (let i = 0; i < nums.length; i++) {
        // Repeat till 1 left, this will be largest number
        while (stack.length > 1 && nums[i] > nums[stack[stack.length - 1]]) {
            result[stack.pop()] = nums[i];
        }
    }
    return result;
};
