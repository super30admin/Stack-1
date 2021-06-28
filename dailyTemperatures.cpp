/*
Intuition: Use a stack to store unresolved temperature indexes. Once an index is resolved see if I can resolve it with other temperatures.
//////////////////////////////////////////
Time Complexity: O(N), N = Length of array
Space Complexity: O(N), N = size of stack
//////////////////////////////////////////
*/

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<int> result(temperatures.size());
        stack<int> stack;
        for ( int i =0; i < temperatures.size(); i++){
            while ( stack.size() != 0 and temperatures[i] > temperatures[stack.top()]){
                int index = stack.top();
                stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
};