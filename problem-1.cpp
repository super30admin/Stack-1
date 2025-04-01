// https://leetcode.com/problems/daily-temperatures/description/
// Time Complexity: O(n)
// Space Complexity: O(n)


class Solution {
    public:
        vector<int> dailyTemperatures(vector<int>& temperatures) {
            int n = temperatures.size();
            stack<int> st;
            vector<int> ans(n,0);
            for(int i=0; i<n; i++){
                int curr = temperatures[i];
                while(!st.empty() && temperatures[i] > temperatures[st.top()]){
                    int temp = st.top();
                    st.pop();
                    ans[temp] = i - temp;
                }
                st.push(i);
            }
            return ans;
        }
    };