739. Daily Temperatures


TC - O(n)
SC - O(n)

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        if(temperatures.size() == 0) return {0};
        int n = temperatures.size();
        vector<int> result(n, 0);
        stack<int> st;
        for (int i=0; i<n; i++) {
            while(!st.empty() && (temperatures[i] > temperatures[st.top()])){
                int popped = st.top();
                st.pop();
                result[popped] = i-popped;
            }
            st.push(i);
        }
        return result;
    }
};

