// Time Complexity : O(2*n) for traversing through the array and also for traversing through the complete stack once
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        stack<int> mystack;
        
        int size = T.size();
        vector<int> result(size, 0);
        if(size == 0){
            return result;
        }
        
        for( int i = 0; i <size; i++){
            
            while(!mystack.empty() && T[i] > T[mystack.top()]){
                result[mystack.top()] =  i - mystack.top() ;
                
                mystack.pop();
                
            }
            
            mystack.push(i);
        }
        
        return result;
     
    }
};