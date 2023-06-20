// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// TC: O(n);
// SC: O(n);

// This problem uses a monotonic increasing stack.
// we push the indices into the stack , before pushing we check if any element in the stack
// are smaller. if they are smaller , we go their index in answer array and place the greater value;
// we need to traverse 2 times to completely update answer for all the elements as we should
// consider it as a circular list.

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int>res(n,-1);
        stack<int>st;
        for(int i = 0;i< 2*n;i++){
            while(!st.empty() && nums[st.top()] < nums[i%n])
            {
                res[st.top()] = nums[i%n];
                st.pop();
            }
            if(i<n){
                st.push(i);
            }
        }
        return res;
    }
};

