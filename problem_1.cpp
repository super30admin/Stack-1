//Time Complexity = O(N)
//Space Complexity = O(N)
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        if(T.size()==0) return vector<int>{0};
        stack<int> st;
        vector<int> result(T.size(),0);
        for(int i = 0; i<T.size(); i++){
            while(!st.empty() && T[i]>T[st.top()]){
                int idx = st.top();
                st.pop();
                result[idx] = i-idx;
            }
            st.push(i);
        }
        return result;
    }
};