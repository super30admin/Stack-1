class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        stack<int> stk;
        //stk.push(0);
        vector<int> answer(nums.size(),-1);
        
        for (int i=0;i<2*nums.size();i++) {
            int temp=i%nums.size();
            while (!stk.empty() && nums[temp]>nums[stk.top()]) {
                answer[stk.top()]=nums[temp];
                stk.pop();
            }
            stk.push(temp);
        }
        return answer;
    }
};