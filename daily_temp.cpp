class Solution {
public:
//TC: O(n)
//SC: O(n)
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        stack<int> st;
        vector<int> result(temperatures.size(), 0);

        for(int i=0;i<temperatures.size();i++)
        {
          
            while(!st.empty() and temperatures[i]>temperatures[st.top()])
            {   
                int popped=st.top(); st.pop();
                result[popped]=i-popped;
            }
            st.push(i);
        }

        return result;
    }
};
