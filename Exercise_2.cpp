/* 
    Time Complexity                              :  O(2*N), in worst case it will iteratve over the array twice if the biggest element is the last element.
    Space Complexity                             :  O(N) store all the n-1 values in the stack if the nth value is the largest and all the other elements are in desecending or equal.
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/next-greater-element-ii/

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n,-1);
        stack<int> st;
        int i=0;
        while(i < 2*n) {
            int cur = nums[i%n];
            while(!st.empty() and nums[st.top()] < cur) {
                if(ans[st.top()] == -1) {
                    ans[st.top()] = cur;
                }
                st.pop();
            }
            if(!st.empty() and i%n == st.top()) {
                break;
            }
            if(ans[i%n] == -1)
                st.push(i%n);
            i++;
        }
        
        return ans;
    }
};