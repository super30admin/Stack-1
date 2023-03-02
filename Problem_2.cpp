503. Next Greater Element II

TC - O(n)
SC - O(n)

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> result(n, -1);

        if (nums.size() == 0) return {0};
        stack<int> st;
        for (int i=0; i< 2*n; i++) {
            while(!st.empty() && nums[i%n] > nums[st.top()]) {
                int popped = st.top();
                st.pop();
                result[popped] = nums[i%n];
            }
            if (i < n) 
                st.push(i);
        }
        return result;
    }
};
