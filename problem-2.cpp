// https://leetcode.com/problems/next-greater-element-ii/description/
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public:
        vector<int> nextGreaterElements(vector<int>& nums) {
            int n = nums.size();
            stack<int> st;
            vector<int> ans(n,-1);
            for(int i=0; i<2*n; i++){
                while(!st.empty() && nums[i%n] > nums[st.top()]){
                    int temp = st.top();
                    ans[temp] = nums[i%n];
                    st.pop();
                }
                if(i < n){
                    st.push(i);
                }
            }
            return ans;
    
        }
    };