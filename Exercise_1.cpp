/* 
    Time Complexity                              :  O(2*N) ~ O(N). In the worst case, push all the n-1 elements in the stack and then n th temperature is the highest. 
                                                    So pop everything out from the stack operation is going to be done.
    Space Complexity                             :  O(N) - Store the n-1 indices in the stack.
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/daily-temperatures/submissions/


class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        stack<int> st;
        st.push(0);
        int n = temperatures.size();
        vector<int> ans(n,0);
       for(int i=1;i<n;i++) {
           int cur_temp = temperatures[i];
           while(!st.empty() and cur_temp > temperatures[st.top()]) {
                ans[st.top()] = i - st.top();
                st.pop();
           }
           st.push(i);
       }
        return ans;
    }
};