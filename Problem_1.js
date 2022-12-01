// Problem1 Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function (temperatures) {
    if (temperatures === null || temperatures.length === 0) {
        return [];
    }
    let n = temperatures.length;
    let result = new Array(n);
    result.fill(0)
    // Add to stack the indexes, inc temp order top to bottom
    let stack = [];
    for (let i = 0; i < n; i++) {
        while (stack.length > 0 && temperatures[i] > temperatures[stack[stack.length - 1]]) {
            // For all temp, less than the new one, store result.
            let index = stack.pop();
            result[index] = i - index;
        }
        stack.push(i)
    }
    return result;
};
