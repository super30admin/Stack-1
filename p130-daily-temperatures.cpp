// Brute Force Solution
// Time Complexity: O(n^2) n = size of the T vector
// Space Complexity: O(1)
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        if(T.size() == 0) return {};
        vector<int> res(T.size(), 0);
        
        for(int i = 0; i < T.size(); i++) {
            for(int j = i+1; j < T.size(); j++) {
                if(T[i] < T[j]) {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }
};

// Next array
// Time Complexity: O(n) n = size of the T vector
// Space Complexity: O(1) res is returned and next vector is of fixed size 101
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        if(T.size() == 0) return {};
        
        vector<int> res(T.size(), 0);
        vector<int> next(101, INT_MAX);
        
        for(int i = T.size()-1; i >= 0; i--) { // O(n)
            int warmer_index = INT_MAX;
            for(int t = T[i]+1; t <= 100; t++) { // O(71) - 30 to 100 is the temp. range
                if(next[t] < warmer_index) {
                    warmer_index = next[t];
                }
            }
            if(warmer_index < INT_MAX) {
                res[i] = warmer_index-i;
            }
            next[T[i]] = i;
        }
        return res;
    }
};

// Using Stack
// Time Complexity: O(n) n = size of the T vector
// Space Complexity: O(n) max possible size of stack is n.
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        if(T.size() == 0) return {};
        vector<int> res(T.size(), 0);
        stack<int> st;
        
        for(int i = 0; i < T.size(); i++) {
            while(!st.empty() && T[i] > T[st.top()]) {
                res[st.top()] = i - st.top();
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
};
