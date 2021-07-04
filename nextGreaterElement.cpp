// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> ans(nums.size(), -1);
        stack<int> st;
        int n = nums.size();
        for(int i = 0; i < 2*n; i++){
            while(!st.empty() && nums[st.top()] < nums[i % n]){
                ans[st.top()] = nums[i%n];
                st.pop();
            }
            if(i < n) st.push(i);
        }
        return ans;
    }
};