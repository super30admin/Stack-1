/*
// Time Complexity : O(N): exact time complexity O(2N)
// Space Complexity :  O(N) maximum length of the stack when all the temperature are in decreasing order except last one.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
How to use monotonically decreasing stack.


// Your code here along with comments explaining your approach
You push idx of elements in the stack that are smaller than the top element or if the stack is empty.
If an element arrives that is bigger. Go back and pop each idx out of the stack and store the difference between the idx in the result, that will
give information of the next warmner weather. Do this untill the top is the largest or stack gets empty.
*/

#include<iostream>
#include<vector>
#include<stack>

using namespace std;

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        size_t sz = temperatures.size();
        vector<int> res(sz,0);
        stack<size_t> st{};
        for(size_t i{};i<sz;++i){
            while(st.empty() == false && temperatures.at(i)>temperatures.at(st.top())){
                size_t idx = st.top();
                st.pop();
                res.at(idx) = i - idx;
            }
            st.push(i);
        }
        return res;
    }
};