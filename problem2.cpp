/*
Time complexity: O(n)
Space complexity: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& a) {
        int n = a.size();
        vector<int>v(n,-1);

        stack<int>st;
        for(int i = 2*n - 1; i >= 0; i--)
        {

            while(!st.empty() && (a[i%n] >= st.top()))
            {
                st.pop();
            }
            if(!st.empty() && (i < n))
            {
                v[i] = st.top();
            }

            st.push(a[i%n]);
        }

        return v;
    }
};