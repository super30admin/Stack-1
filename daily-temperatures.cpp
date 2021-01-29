//Time - O(n)
//Space - O(n)

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        
        stack<int> st;
        vector<int> ans(T.size(),0);
        for(int i=0;i<T.size();i++){
            if(st.empty()){
                st.push(i);
            }else{
                while(!st.empty() && T[i]>T[st.top()]){
                    ans[st.top()] = i-st.top();
                    st.pop();
                }
                st.push(i);
            }
        }
        
        return ans;
        
        
    }
};