//Time - O(n)
//Space - O(n)

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        stack<int> st;
        vector<int> ans(nums.size(),-1);
        for(int i=0;i<nums.size()*2;i++){
            if(st.empty()){
                st.push(i%nums.size());
            }else{
                while(!st.empty() && nums[i%nums.size()]>nums[st.top()]){
                    ans[st.top()] = nums[i%nums.size()];
                    st.pop();
                }
                st.push(i%nums.size());
            }
        }

        
        return ans;
    }
};