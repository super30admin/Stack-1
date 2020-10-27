// Time Complexity : O(2*n) for traversing through the array twice and also for traversing through the complete stack once
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning



class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int size = nums.size();
        
        vector<int> result(size,-1);
        
        if(size == 0){
            return result;
        }
        
        stack<int> mystack;
        
        for ( int i = 0; i  < size*2; i++){
            
            int temp = i%(size);
            
            while( !mystack.empty() && nums[temp] > nums[mystack.top()]){
                
                result[mystack.top()] = nums[temp];
                
                mystack.pop();
            }
            mystack.push(temp);
            
        }
        return result;
    }
};