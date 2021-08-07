// Time Complexity : O(n*n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - Need to optimize with Stack approach

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        
        int i, j, k;
        
        int len = nums.size();
        vector<int> ret_vect(len, -1);
        
        for(i = 0; i < len; i++)
        {
            k = i+1;
            // Traverse through the list to find
            // the next greater element
            for(j = 0; j < len-1; j++)
            {
                if(k == len)
                    k = 0;
                
                // Found the next greater element
                if(nums[k] > nums[i])
                {
                    ret_vect[i] = nums[k];
                    break;
                }
                k++;
            }
        }
        return ret_vect;
    }
};