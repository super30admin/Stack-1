//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        stack<int> st;
        vector<int> res;
        if(nums.size()==0) return res;
        for(int i=0; i<nums.size(); i++){
            res.push_back(-1);
        }
         
        for(int i=0; i<(2*nums.size()); i++){
            while(st.empty()==false && nums[i%nums.size()]>nums[st.top()]){
                res[st.top()]=nums[i%nums.size()];
                st.pop();
            }
            if(i<nums.size())
                st.push(i);
        }
        
        return res;
    }
};