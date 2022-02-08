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
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<int> result(temperatures.size(),0);
        stack<int> indexStack;
        indexStack.push(0);
        int i=1;
        while(i<temperatures.size())
        {
            if(!indexStack.empty() && temperatures[i]>temperatures[indexStack.top()])
            {
                int index=indexStack.top();
                indexStack.pop();
                result[index]=i-index;
            }
            else
            {
                indexStack.push(i);
                i++;
            }
        }
        
        while(!indexStack.empty())
        {
            result[indexStack.top()]=0;
            indexStack.pop();
        }
        return result;
    }
};