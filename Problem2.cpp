class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> result(n, -1);
        stack<int> st;

        for(int i = 0; i < 2 * n; i++) {
            while(!st.empty() && nums[st.top()] < nums[i % n]) {
                int popped = st.top();
                st.pop();
                result[popped] = nums[i % n];
            }
            if(i < n) {
                st.push(i);
            }
        }

        return result;
    }
};