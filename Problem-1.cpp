//taught by professor
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& v) {
        
        int i,k,j,n=v.size();
        vector<int> res(n,0);
        stack<int > s;
        s.push(n-1);
        for(i=n-2;i>=0;i--)
        {
            int temp  = v[s.top()];
           while(!s.empty() && temp<=v[i])
           {
               s.pop();
           }
           if(!s.empty())
           {
               res[i]=(s.top()-i);
           }
            s.push(i);
        }
        return res;
    }
};
