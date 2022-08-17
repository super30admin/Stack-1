// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Create a stack to store index of i/p vector and result vector to store answer.
 * Iterate over i/p vector, if top element of stack is less than the current element then
 * update stack top element in result vector by current element.
 * Repeat the above step until stack is empty or greater element in stack is encountered.
 * Return result vector at the end.  
 */

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        if (nums.size() == 0)
            return {};
        
        int n = nums.size();
        vector<int> result(n, -1);
        stack<int> stk;
        
        for (int i = 0; i < n * 2; i++)
        {
            while (!stk.empty() && nums[i % n] > nums[stk.top()]) 
            {
                result[stk.top()] = nums[i % n];
                stk.pop();
            }

            // Avoid duplicate insertions in stack.
            if (i < n)
            {
                stk.push(i);
            }
        }
        
        return result;
    }
};