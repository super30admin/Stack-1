/*
Time: O(n)
Space: O(n)

Build monotonic stack and find the closest next greater element
But we need cyclic greater if available, so just traverse the array two times (i.e. from (0 to 2n-1) % n)
*/

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        //monotonic stack
        int n = nums.size();
        vector<int> nxt_grt(n, -1);

        stack<int> st;

        for(int i=0;i<2*n;i++){
            int idx = i%n; // mod means cyclic traverse
            while(!st.empty() && nums[st.top()] < nums[idx]){
                //nxt_grt[st.top()] != -1 means we got greater element even before cyclic rotation
                //so don't overwrite
                if(nxt_grt[st.top()] == -1){
                    nxt_grt[st.top()] = idx;
                }

                st.pop();
            }

            st.push(idx);
        }

        vector<int> ret(n,-1);
        for(int i=0;i<n;i++){
            if(nxt_grt[i] != -1)  ret[i] = nums[nxt_grt[i]];
        }

        return ret;
    }
};
