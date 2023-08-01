/*
// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (runtime error)
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Find all the subarray , multiply the min with the length.
*/

#include<iostream>
#include<vector>
#include<stack>

using namespace std;


class Solution_1 {
    //brute force solution
public:
    int largestRectangleArea(vector<int>& heights) {
        //max length of the array wiht minimum to the length of the array is maximum.
        int max_val{};
        size_t sz{heights.size()};
        for(int i{};i<sz;++i){
            int min_arr{10001};
            for(int j{i};j<sz;++j){
                min_arr = min(min_arr,heights.at(j));
                max_val = max(max_val,min_arr*(j-i+1));
            }
        }
        return max_val;
    }
};

/*
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
Taking care of the left wall pointer along with the right wall pointer


// Your code here along with comments explaining your approach
First push -1 into the stack of int.
As you iteratre through the values, push them into stack untill increasing.
If a decreasing value is found than top , then pop the indexes at the top until the value of top is smaller than the current value
or the index reaches -1.
With each value popped multiply it with the difference between the st.top() which is the left wall and curr_val idx, which is the 
right wall.
The best part is this algorihtm takes care of the left wall such that even if intermediate values are popped the values behind that current idx
will be greater than the curr_val hence that minimum is maintained.
*/

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int max_val{};
        stack<int> st{};
        st.push(-1);
        size_t sz{heights.size()};
        int i{};
        for(;i<sz;++i){
            while(st.top()!=-1 && heights.at(st.top())>heights.at(i)){
                int idx = st.top();
                st.pop();
                max_val = max(max_val,heights.at(idx)*(i-1-st.top()));
            }
            st.push(i);
        }
        while(st.top()!=-1){
            int idx = st.top();
            //cout<<idx<<" ";
            st.pop();
            max_val = max(max_val,heights.at(idx)*(i-1-st.top()));
        }
        return max_val;
    }
};