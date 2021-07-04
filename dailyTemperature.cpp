// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(s)  size of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        vector<int> ans(T.size(),0);
        stack<int> st;
        for(int i = 0; i < T.size(); i++){
            while(!st.empty() && T[st.top()] < T[i]){
                ans[st.top()] = i - st.top();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
};