//TC: O(2n)
//SC: O(n)

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        
        stack<int> st;
        vector<int> res(nums.size(), -1);
        
        //need to iterate over the array twice since this is circular.
        for(int x=0; x<2*nums.size(); x++){
            int i = x%nums.size();
            
            //check in the stack if a) it is empty, and b) the top stack element is lesser than the current element. If it is, then we set the current element as the value in the top element index in the result array. 
            while(!st.empty() && nums[i] > nums[st.top()]){
                int idx = st.top();
                st.pop();
                res[idx] = nums[i];
            }
            
            //if we are going over the original array (length n), insert this into stack
            if(x < nums.size()){
                st.push(i);
            }
        }
        
        return res;
        
    }
};