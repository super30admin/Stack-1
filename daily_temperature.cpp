//Time Complexity-O(n)
//Space Complexity-O(n)
//Ran succesfully on leetcode

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        if (T.empty())
            return {};
        stack<pair<int, int>> s;
        //Pushing the last element
        s.push(make_pair(T.back(),0));        
        vector<int>result(T.size(),0);        
		//Starting from the back
        for (int i=T.size()-2;i>=0;i--)
        {
            int counter=1;
            while (!s.empty()&&T[i]>=s.top().first)
            {
                counter+=s.top().second;
                s.pop();
            }
            if (s.empty())
                s.push(make_pair(T[i],0));
            else
            {
                s.push(make_pair(T[i],counter));
                result[i]=counter;
            }
        }        
        return result;
    }
};