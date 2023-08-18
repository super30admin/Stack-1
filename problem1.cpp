/*
Time complexity: O(n)
Space complexity: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/


class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        
        int n = temperatures.size();
        vector<int>nge(n, 0); 
        stack<int>st{};

        for(int i = n-1; i>=0; --i){
            while(!st.empty() && temperatures[st.top()] <= temperatures[i])
                st.pop();

            if(!st.empty())
                nge[i] = st.top()-i;
            st.push(i);
        }
        
        return nge;
    }
};