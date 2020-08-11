// Time Complexity : O(3n)
// Space Complexity : O(n)
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. Create stack for finding next greater value
//2. Pop the data from stack when value is found and go through the loop again to get final values of all the elements
//3. Return result

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        
        //edge
        if(nums.size()==NULL)
            return nums;
        
        //logic
        vector<int> result(nums.size(), -1);
        stack<int> num_st;
        int n = nums.size();
        num_st.push(0);
        for(int i=1; i<2*n;i++){
            
            while(!num_st.empty()){
                int temp = nums[num_st.top()];
                if(nums[i%n]>temp){
                    result[num_st.top()] = nums[i%n];
                    num_st.pop();
                }else{
                    break;
                }
            }
            if(i<n)
              num_st.push(i);      
        }
        
        return result;
    }
};
