// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        deque<pair<int,int>> dq; 
        vector<int> result(nums.size(), -1);

        dq.push_back({nums[0], 0});

        int i = 1;

        for(int i = 0; i < 2*nums.size(); i++) {
            int currentNumber = nums[i%nums.size()];
            while(!dq.empty() && currentNumber > dq.back().first) {
                result[dq.back().second] = currentNumber; 
                dq.pop_back(); 
            }
            if(i < nums.size()) dq.push_back({currentNumber, i});
        } 

        return result; 

    }
};