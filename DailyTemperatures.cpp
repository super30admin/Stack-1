// Time Complexity -> O(n)
// Space Complexity -> O(n) for the stack.
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> answer(n);
        stack<int> st;
        
        for(int i = 0; i < n; i++){
            while(!st.empty() && temperatures[st.top()] < temperatures[i]){
                int idx = st.top(); st.pop();
                answer[idx] = i - idx;
            }
            st.push(i);
        }
        return answer;
    }
};