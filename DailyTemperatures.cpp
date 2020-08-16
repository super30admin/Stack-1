// Time Complexity : O(N) where N=Number of anagrams each having length K
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Next greater element is tracked using stack.

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        stack<int> st;
        vector<int> res(T.size(),0);
        
        for(int i=0;i<T.size();i++){
            while(!st.empty() && T[i]>T[st.top()]){
                res[st.top()] = i - st.top();
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
};
