/**
 * @Time Complexity:
 * O(N) where N is the size of the given array
 * 
 */

/**
 * @Space Complexity:
 * O(N) where n is the size of the given array
 * 
 */

/**
 * @Approach:
 * This is a classic example of monotonically
 * increasing stack. We have to llok for the next warmer day.
 * So if we iterate over the given array, we have to compare the values
 * with the previous values. So to store these previous values
 * we use stack. 
 * 
 */



// The code ran perfectly on leetcode

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        if(temperatures.empty() || temperatures.size() == 0) return {};
        stack<int> st;
        vector<int> result(temperatures.size());
        for(int i = 0; i<temperatures.size(); i++){
            while(!st.empty() && temperatures[i] > temperatures[st.top()]){
                int popped = st.top();
                st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }
};