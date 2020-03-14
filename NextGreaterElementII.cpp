#include<iostream>
#include<stack>
#include<algorithm>
#include<vector>
using namespace std;

// Time Complexity : O(N) for Stack
// Space Complexity : O(N) for Stack
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
// Your code here along with comments explaining your approach



vector<int> nextGreaterElements(vector<int>& nums) {
    vector<int> output(nums.size());

    fill(output.begin(),output.end(),-1);
    int size = nums.size();

    stack<int> st;
    int doubleSize = 2 * size;
    for(int index = 0; index < doubleSize; index++){
        while(!st.empty() && nums[index % size] > nums[st.top()]){
            output[st.top()] = nums[index % size];
            st.pop();
        }
        if(index < size){
                st.push(index);
        }
    }
    return output;

}

int main(){
    vector<int> nums = {1,2,1};
    vector<int> output(nums.size());

    output = nextGreaterElements(nums);
    for(int i =0; i < output.size(); i++){
        cout<<output[i]<<"\t";
    }

}