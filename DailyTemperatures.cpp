// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        deque<pair<int,int>> dq; 
        vector<int> result(temperatures.size(), 0); 

        dq.push_back({temperatures[0], 0});

        for(int i = 1; i < temperatures.size(); i++) {
            int currentTemperature = temperatures[i];
            while(!dq.empty() && currentTemperature > dq.back().first) {
                int temp = dq.back().first; 
                int index = dq.back().second;
                dq.pop_back();

                result[index] = i - index;  
            }

            dq.push_back({currentTemperature, i});
        }

        return result; 
                 
    }
};