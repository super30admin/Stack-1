//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        
        vector<int> ans(T.size(),0);
        stack<int> st;
        st.push(T.size()-1);
        
        for(int i=T.size()-2;i>=0;i--){
            while(!st.empty() && T[st.top()]<=T[i]){
                st.pop();
            }
            if(st.empty()){
                st.push(i);
                continue;
            }
            ans[i]=st.top()-i;
            st.push(i);
        }
        
        return ans;
    }
};