// Time Complexity : O(n) => O(n+n) cauae of the for looop
// Space Complexity : O(n) all elements can go into the satck
// Did this code successfully run on Leetcode : Yes


/*
Monotonic stacks
- Everytime you see a number bigger than the stack.top(), update the result 
- Go over the array twice to capture the greatest circularly
- Don't add the element one the second iteration of the array since the result has already been ipdated 
*/

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        if(nums.size() == 0) return nums;
        int n = nums.size();
        // initalise with -1
        vector<int> result (n, -1);

        stack<int> st;
        // iterating over the array twice
        for(int i = 0; i < 2 * n; i++){
            // If you see a new number bigger than the current top, keep updatating the result
            while(!st.empty() && nums[i%n] > nums[st.top()]) {
                result[st.top()] = nums[i%n];
                st.pop();
            }

            // if its the first iteration. push the number to the stack
            if(i < n)
                st.push(i);
        }
        return result;
    }
};