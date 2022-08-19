// Time Complexity -> O(3n)
// Space Complexity -> O(n) for the stack.
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> answer(n, -1);
        stack<int> st;
        
        for(int i = 0; i < 2*n; i++){
            while(!st.empty() && nums[st.top()] < nums[i%n]){
                int idx = st.top(); st.pop();
                answer[idx] = nums[i%n];
            }
            if(i < n)
                st.push(i);
        }
        return answer;
    }
};