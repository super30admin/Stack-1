//TC: O(n)
//SC: O(n) for the stack

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        
        if(T.empty())
            return vector<int>();
        
        stack<int> s;
        
        int n = T.size();
        vector<int> ans(n, 0);
        
        //iterate through the array
        for(int i=0; i<T.size(); i++){
            
            //Make use of the monotonic stack. While the stack is not empty and the current element is greater than the top of the stack, assign ans[idx] to the difference between the current element and the top of the stack 
            while(!s.empty() && T[i] > T[s.top()]){
                int idx = s.top();
                s.pop();
                ans[idx] = i - idx;
            }
            
            //push the indices to the stack
            s.push(i);
            
        }
        
        
        return ans;
        
                
    }
};