/**
 * @Time Complexity:
 * O(3N) where N is the size of the given array.
 * 
 */


/**
 * @Space Complexity:
 * O(N) for the size of the stack hwere n is the size of the given array
 * 
 */


/**
 * @Approach:
 * Here the next greater number can be obtained
 * by going again to the start of the array and look
 * for it. So, we have to run the for loop
 * for twice the size of the given array. We are using
 * stack here and we kkep comparing the values at the
 * top of the stack with the current value and if the 
 * current value is greater than the top value of the stack
 * we pop the top which is index and at this index in the
 * result vector we store the current value. Then again
 * we compare the current with the next top. If the earlier condition
 * holds we repeat the same process. Otherwise, we push the
 * current value to the stack which means we have to find
 * it's next greater value first, then others which
 * are below in the stack will be solved.
 * 
 * We are using monotonically increasing stack
 * 
 */

// The code ran perfectly on leetcode

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        if(nums.empty() || nums.size() == 0) return {};
        
        vector<int> result(nums.size(), -1);
        stack<int> st;
        int n = nums.size();
        for(int i = 0; i<2*n; i++){
            while(st.empty() == false && nums[i%n] > nums[st.top()]){
                int idx = st.top();
                st.pop();
                result[idx] = nums[i%n];
            }
            st.push(i%n);
        }
        
        return result;
        
    }
};