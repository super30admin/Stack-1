// Time Complexity : O(N)
// Space Complexity : O(I) where I represents the increasing temperatures
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} T
 * @return {number[]}
 */
var dailyTemperatures = function(T) {
    if (!T || !T.length) return [];
    
    const result = new Array(T.length);
    const st = [];
    
    for (let i = T.length - 1; i >= 0; i--) {
        while (st.length > 0 && T[i] >= T[st[st.length - 1]]) st.pop();
        result[i] = st.length == 0 ? 0 : st[st.length - 1] - i;
        st.push(i);
    }
    
    return result;
};
