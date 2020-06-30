// Brute Force - TLE
// Time Complexity : O(n^2) 
// Space Complexity : O(1)
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Maintain 2 pointers - left at current element and right to find next greater temperature
// 2. If temperature at right > left then increment both else keep incrementing right till condition satisfied
// 3. In the latter case, set right to left+1 and take care of cases where right crosses array for some element  

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        vector<int> result;
        if(T.size()==0)
            return result;
        if(T.size()==1)
            return {1}; 
        int left=0, right=1, count=0;
        while(left<T.size()-1){
            if(right>=T.size()){
                result.emplace_back(0);
                left++; right=left+1;
                count=0;
            }
            else{
                count++;
                if (T[right]>T[left]){
                    result.emplace_back(count);
                    count=0;
                    left++; right=left+1;
                }
                else
                    right++;
                
            }
        }
        
        for(int i=result.size(); i<T.size(); i++)
            result.emplace_back(0);
        return result;
    }
};

// Stack solution
// Time Complexity : O(2n) i.e. O(n) 
// Space Complexity : O(n)
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Maintain a stack of indices of all unresolved numbers; it will always contain unresolved temperatures in descending order
// 2. Iterate through array and if curr index temp > top of stack temp then add difference of indices to result
// 3. Else keep adding the curr index to stack till it resolves any top of stack temp; Add 0s to all elements left in stack at the end

// Consider an eg: [73,74,75,71,69,72,76,73]
// Queue will not help in unresolved cases since itll contain 75,71,69; when 72 comes it'll check from 75-71-69 it'll resolve 71 n 69 but we lose 75  


class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        vector<int> result(T.size());
        if(T.size()==0)
            return result;
        stack<int> st;
        st.push(0);
        for(int i=1;i<T.size();i++){
            while(!st.empty() && T[i] > T[st.top()]){
                int num = st.top();
                result[num] = i-num;
                st.pop();
            }
            st.push(i);
        }
        while(!st.empty()){
            int num = st.top();
            result[num] = 0;
            st.pop();
        }
        return result;
    }
};
