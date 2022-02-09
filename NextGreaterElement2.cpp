//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n= nums.size();
        vector<int> result(n,-1);
        stack<int> s;
        for(int i=0;i<n*2;i++)
        {
            while(!s.empty() && nums[i%n]>nums[s.top()])
            {
                result[s.top()]=nums[i%n];
                s.pop();
            }
            if(i<n)
            {
                s.push(i%n);
            }
        }
        return result;
    }
};