// Using Stack
// Time Complexity: O(n) n = size of nums vector
// Space Complexity: O(n)
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        if(nums.size() == 0) return {};
        int n = nums.size();
        vector<int> res(nums.size(), -1);
        stack<int> st;
        for(int i = 0; i < 2*n; i++) {
            while(!st.empty() && nums[i%n] > nums[st.top()]) {
                res[st.top()] = nums[i%n];
                st.pop();
            }
            if(i < n)
                st.push(i);
        }
        return res;
    }
};
