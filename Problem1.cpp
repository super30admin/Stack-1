// Time Complexity : O(n) - 2N to be exact
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Daily Temperatures

#include<iostream>
#include<vector>
#include<stack>

using namespace std;

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        
        vector<int> res(temperatures.size(), 0);    // resultant array
        stack<int> s1;  // store the latest seen smaller element
        
        if(temperatures.empty())
            return {};
        
        for(int i = 0; i < temperatures.size(); i++){
            while(!s1.empty() && temperatures[s1.top()] < temperatures[i]){
                res[s1.top()] = i - s1.top();           // day here is the index 
                s1.pop();
            }
            s1.push(i);
        }
        return res;
    }
};