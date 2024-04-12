//t-c: n
//s-c: n
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> result(nums.size(), -1);
        stack<int> st;
        for(int i = 0; i < nums.size(); i++){
            while(!st.empty() && nums[i] > nums[st.top()]){
                result[st.top()] = nums[i];
                st.pop();
            }
            st.push(i);
        }
        int i = 0;
        while(i < st.top()){
            while(!st.empty() && nums[i] > nums[st.top()]){
                result[st.top()] = nums[i];
                st.pop();
            }
            i++;
        }
        return result;
    }
};
