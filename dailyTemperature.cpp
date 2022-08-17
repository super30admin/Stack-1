// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Create a stack to store index of i/p vector and result vector to store answer.
 * Iterate over i/p vector, if top element of stack is less than the current element then
 * update current index in result vector by subtracting stack top element from current index.
 * Repeat the above step until stack is empty or greater element in stack is encountered.
 * Return result vector at the end.  
 */

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        if (temperatures.size() <= 0)
        {
            return {};
        }
        
        stack<int> stk;
        vector<int> result(temperatures.size(), 0);
        
        for (int i = 0; i < temperatures.size(); i++)
        {
            while (!stk.empty() && temperatures[stk.top()] < temperatures[i])
            {
                result[stk.top()] = i - stk.top();
                stk.pop();
            }
            
            stk.push(i);
        }
        
        return result;
    }
};