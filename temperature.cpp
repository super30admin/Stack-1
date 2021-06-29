// Time complexity-O(n)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// iterating over the array
// compare the current with the next element
// if its greater calculate the distance and return it
// else push the next element into the stack and repeat this process until you get to the end of the array

#include<algorithm>
#include<iostream>
#include<vector>
#include<stack>
using namespace std;

/*****************************************************using stacks***********************************************/
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
         stack<int> st;
        vector<int >results(temperatures.size());
        if(temperatures.size()==0){
            return results;
        }
        
        for(int i=0;i<temperatures.size();i++){
            while(!st.empty() && temperatures[i] > temperatures[st.top()]){
                int idx= st.top();
                st.pop();
                results[idx]= i -idx;
            }
            st.push(i);
        }
        return results;
    }
};

/*****************************************using arrays****************************************************/
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
         vector<int> st(temperatures.size());
        vector<int >results(temperatures.size());
        if(temperatures.size()==0){
            return results;
        }
        int top = -1;
        
        for(int i=0;i<temperatures.size();i++){
            while(top >-1 && temperatures[i] > temperatures[st[top]]   ){
                int idx= st[top];
                top--;
                results[idx]= i -idx;
            }
            top++;
            st[top]=i;
        }
        return results;
    }
};

// class Solution {
// public:
//     vector<int> dailyTemperatures(vector<int>& temperatures) {
//          stack<int> st;
//         vector<int >results(temperatures.size());
//         if(temperatures.size()==0){
//             return results;
//         }
        
//         for(int i=0;i<temperatures.size();i++){
//             while(!st.empty() && temperatures[i] > temperatures[st.top()]){
//                 int idx= st.top();
//                 st.pop();
//                 results[idx]= i -idx;
//             }
//             st.push(i);
//         }
//         return results;
//     }
// };

/*****************************************using arrays****************************************************/
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
         vector<int> st(temperatures.size());
        vector<int >results(temperatures.size());
        if(temperatures.size()==0){
            return results;
        }
        int top = -1;
        
        for(int i=0;i<temperatures.size();i++){
            while(top >-1 && temperatures[i] > temperatures[st[top]]   ){
                int idx= st[top];
                top--;
                results[idx]= i -idx;
            }
            top++;
            st[top]=i;
        }
        return results;
    }
};
