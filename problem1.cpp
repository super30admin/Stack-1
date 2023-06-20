// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// monotonic increasing stack concept

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int>res(n,0);
        stack<int>st;
        for(int i = 0;i<n;i++){
            while(!st.empty() && temperatures[st.top()] < temperatures[i]){
                int index = st.top();
                res[index] = i - index;
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
};

