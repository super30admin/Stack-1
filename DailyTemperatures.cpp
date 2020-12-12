class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        stack<int> stk;
        stk.push(0);
        vector<int> answer(T.size(),0);
        for (int i=1;i<T.size();i++) {
             if (!stk.empty() && T[i]>T[stk.top()] ) {
                while (!stk.empty() && T[i]>T[stk.top()]) {
                    answer[stk.top()]=i-stk.top();
                    stk.pop();
                }
             }
            stk.push(i);
        }
        return answer;
    }
};