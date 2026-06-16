class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        stack<int> st;
        int n =nums.size();
        vector<int> results(n, -1);

        for(int i=0;i<2*n;i++)
        {
            while(!st.empty() and nums[i%n]>nums[st.top()])
            {
                int popped= st.top(); st.pop();
                results[popped]=nums[i%n];
            }
            if(i<n)
                st.push(i);
        }
        return results;
    }
};
