// Time Complexity : O(3n) i.e. O(n) since loop goes till 2n and we can visit some element twice
// Space Complexity : O(n)
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Since it is a cyclic array, we'll iterate from 0 to 2n and set idx to be i%n
// 2. Maintain a stack of indices of all unresolved numbers; it will always contain unresolved numbers in descending order
// 2. Iterate through array and if curr index num > top of stack num then add curr index num to result
// 3. Else keep adding the curr index to stack till it resolves any top of stack temp

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n=nums.size();
        vector<int> result(n,-1);
        if(n==0)
            return result;
        stack<int> st;
        st.push(0);
        for(int i=1; i<2*n;i++){
            int idx = i%n;
            while(!st.empty() && nums[idx]>nums[st.top()]){
                result[st.top()] = nums[idx];
                st.pop();
            }
            if(i<n)
                st.push(i);
        }
        return result;
    }
};