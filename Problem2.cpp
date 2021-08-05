// Time Complexity : O(n) - 4N to be exact
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Next Greater Element II

#include<iostream>
#include<vector>
#include<stack>

using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        
        int n = nums.size();
        
        stack<int> s1;
        
        vector<int> res(n, -1);
        
        if(nums.empty())
            return {};
        
        for(int i = 0; i < 2*n; i++){
            while(!s1.empty() && nums[i % n] > nums[s1.top()]){
                res[s1.top()] = nums[i % n];
                s1.pop();
            }
            
            if(i < n)
                s1.push(i);
        }
        return res;
    }
};