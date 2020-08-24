//Time Complexity = O(N)
//Space Complexity = O(N)
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        if(nums.size() == 0){
            return vector<int>{};
        }
        int n = nums.size();
        vector<int> result(n,-1);
        stack<int> st;
        for(int i = 0; i<2*n; i++){
            while(!st.empty() && nums[i%n]>nums[st.top()]){
                int idx = st.top();
                st.pop();
                result[idx] = nums[i%n];
            }
            if(i<n){
                st.push(i%n);    
            }
        }
        return result;
    }
};