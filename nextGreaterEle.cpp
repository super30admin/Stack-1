#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
So we go through the array twice to simulate the circular nature.
For each number, we use a stack to track the next greater element efficiently.
As soon as we find a bigger one, we update and move on, skipping repeated work.
*/
class Solution{
public:
    vector<int> nextGreaterElement(vector<int>& nums){
        int n = nums.size();
        vector<int> result(n, -1);
        stack<int> st;
        for(int i = 0; i < 2*n; i++){
            while(!st.empty() && nums[st.top()] <  nums[i%n]){
                int popped = st.top(); st.pop();
                result[popped] = nums[i%n];
            }
            if(i < n) st.push(i);
            else if(!st.empty() && i%n == st.top()) break;
        }
        return result;
    }
};
