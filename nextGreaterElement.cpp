/*
Intuition: Use a stack to store unresolved indexes. 
Once an index is resolved see if I can resolve it with other greather values.
//////////////////////////////////////////
Time Complexity: O(N), N = Length of array
Space Complexity: O(N), N = size of stack
//////////////////////////////////////////
*/

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> result(nums.size(), -1);
        stack<int> stack;
        int n = nums.size();
        for ( auto el: result) cout<<el<<" ";
        for ( int i = 0; i < 2*n; i++){

            while ( stack.size() !=0 and nums[i%n] > nums[stack.top()] ){
                int index = stack.top();
                stack.pop();
                result[index] = nums[i%n];
                
            }
            if ( i < n) stack.push(i);
            

        }
        return result;
    }
};