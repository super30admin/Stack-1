// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        if(T.size()==0){
            return {};
        }
        vector<int> result(T.size());
        stack<int> s;
        for(int i=0;i<T.size();i++){
            while(!s.empty() && T[i]>T[s.top()]){
                int index = s.top();
                result[index] = i-index;
                s.pop();
            }
            s.push(i);
        }
        return result;
    }
};
