//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        
        stack<int> st;
        vector<int> ans(nums.size(),-1);
        
        for(int i=nums.size()-1;i>=0;i--){
            
            while(!st.empty() && st.top()<=nums[i]){
                st.pop();
            }
            
            if(st.empty()){
                ans[i]=-1;
            }
            else{
                ans[i]=st.top();
            }
            st.push(nums[i]);
        }
        
        for(int i=nums.size()-1;i>=0;i--){
            
            if(ans[i]==-1){
                while(!st.empty() && st.top()<=nums[i]){
                    st.pop();
                }

                if(st.empty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=st.top();
                }
            }
            st.push(nums[i]);
        }
        return ans;
    }
};