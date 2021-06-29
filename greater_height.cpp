// Time complexity-O(2n)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// initiaze your result array to -1
// iterate over the array twice to make sure you are able to process all elements including the last one
// compare the current with the next element
// if its greater just put it in the result array
// else push the  index next element into the stack and repeat this process until you get to the end of the array
// if a particular element has been processed dont push it into the stack during the second iteration

#include<algorithm>
#include<iostream>
#include<vector>
#include<stack>
using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        stack<int>st;
        
        vector<int>results(n,-1);
        if(nums.size()==0){
            return results;
        }
        
        for(int i=0;i<2*n;i++){
            
            while(!st.empty() && nums[i%n] > nums[st.top()] ){
                
                results[st.top()] = nums[i%n];
                st.pop();
                
            }
            if(results[i%n] == -1){
                st.push(i%n);
            }

        }
        return results;
    }
};