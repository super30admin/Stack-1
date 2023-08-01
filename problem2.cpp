/*
// Time Complexity : O(N) will take 3n times. 2n times array traversal and stack traversal n times.
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
You store the idx in stack if the stack is empty or the next element is smaller than the top element of the stack.
If a larger value than st.top() is encountered. Pop the idx and store the value of current array number at the popped idx
Do it until the top is larger or the st is empty.

*/

#include<iostream>
#include<vector>
#include<stack>

using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        size_t sz = nums.size();
        vector<int> res(sz,-1);
        stack<int> st{};
        for(size_t i{};i<2*sz;++i){
            while(st.empty()==false && nums.at(st.top())<nums.at(i%sz)){
                size_t idx = st.top();
                st.pop();
                res.at(idx) = nums.at(i%sz);
            }
            if(i<sz){
                st.push(i);
            }
        }
        return res;
    }
};