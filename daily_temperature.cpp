// Time Complexity : O(2n)
// Space Complexity : O(n)
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//1. Create stack and push the elements till the top most is always lesser than the previous elements
//2. Pop out of stack once a greater element is found
//3. Return results when all the elements in the input are completed

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& nums) {
                
        //edge
        if(nums.size()==NULL)
            return nums;
        
        //logic
        vector<int> result(nums.size(), 0);
        stack<int> num_st;
        num_st.push(0);
        for(int i=1; i<nums.size();i++){
            while(!num_st.empty()){
                int temp = nums[num_st.top()];
                if(nums[i]>temp){
                    result[num_st.top()] = i-num_st.top();
                    num_st.pop();
                }else{
                    break;
                }
            }
            num_st.push(i);
        }
        return result;
    }
};
