//time complexity:O(n)
//space complexity:O(w)
//executed on leetcode: yes
//approach:using stack
//any issues faced? yes

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        vector<int>res;
        stack<int>s;
        for(int i=T.size()-1; i>=0; i--)
        {
            while(!s.empty() && T[i]>=T[s.top()])
                s.pop();
            if(!s.empty())
                res.push_back(s.top()-i);
            else
                res.push_back(0);
            s.push(i);
        }
        reverse(res.begin(),res.end());
        return res;
    }
};