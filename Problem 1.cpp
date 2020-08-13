//Time Complexity : O(2n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    //O(2n) solution
    vector<int> dailyTemperatures(vector<int>& T) {
        stack<int> st;
        vector<int> res;
        if(T.size()==0) return res;
        for(int i=0; i<T.size(); i++){
            res.push_back(0);
        }
        //put indices in stack which are unsresolved
        st.push(0);
        for(int i=1; i<T.size(); i++){
            while(st.empty()==false && T[i]>T[st.top()]){
                res[st.top()]=i-st.top();
                st.pop();
            }
            st.push(i);
        }
        
        return res;
    }
};