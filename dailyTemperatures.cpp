// Time Complexity : O(n) => O(n+n) cauae of the for looop
// Space Complexity : O(n) all elements can go into the satck
// Did this code successfully run on Leetcode : Yes

/*
Add the elemets to the stack 
When does an operation happen? When the element is bigger than the previous one, so push all the smaller numbers into the stack

Once we see a bigger element, pop it and update the result with index of top - i 
Keep doing this till we see a number smaller, and then just psuh it 
*/


class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        stack<int> stack;
        int size = temperatures.size();
        vector<int> result(size, 0);
        for(int i=0; i<size; i++){
            while(!stack.empty() && temperatures[i] > temperatures[stack.top()]) {
                result[stack.top()] = i - stack.top();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
};