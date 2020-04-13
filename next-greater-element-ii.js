// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElements = function(nums) {
    if (!nums || !nums.length) return [];
    
    const result = new Array(nums.length);
    const st = [];
    for (let i = 2 * nums.length - 1; i >= 0; i--) {
        while (st.length > 0 && nums[st[st.length - 1]] <= nums[i % nums.length]) {
            st.pop();
        }
        result[i % nums.length] = st.length == 0 ? -1 : nums[st[st.length - 1]];
        st.push(i % nums.length);
    }
    
    return result;
};
