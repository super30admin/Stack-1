// Time Complexity : O(n*n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: Need to optimize with Stack approach

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        
        int i, j;
        int count;
        int len = temperatures.size();

        vector<int> ret_vect(len, 0);

        for(i = 0; i < len; i++)
        {
            count = 1;
            // Traverse and Find the next Greater temperature
            for(j = i+1; j < len; j++)
            {
                // Found a warmer day
                if(temperatures[j] > temperatures[i])
                {
                    ret_vect[i] = count;
                    break;
                }
                count++;
            }
        }
        
        return ret_vect;
    }
};