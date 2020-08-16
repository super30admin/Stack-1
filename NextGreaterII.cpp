// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Next greater element is found using stack

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n= nums.size();
        vector<int> res(n,-1);
        stack<int> st;
        
        for(int i=0;i<2*n;i++){
            while(!st.empty() && nums[i%n]>nums[st.top()]){
                res[st.top()] = nums[i%n];
                st.pop();
            }
            if(i<n)
                st.push(i);
            
        }
        return res;
    }
};
