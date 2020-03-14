#include<iostream>
#include <bits/stdc++.h>
#include<algorithm>
#include<stack>
#include<vector>
using namespace std;

// Time Complexity : O(N^2) for Brute Force,O(N) for Stack
// Space Complexity : O(1) for Brute Force,O(N) for Stack
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
// Your code here along with comments explaining your approach


vector<int> dailyTemperatures(vector<int>& T) {
    int size = T.size();
    stack<int> s;
    vector<int> output(size);
    int count = 0;
    for(int i =0; i < size; i++){
        int curr = T[i];
        while(!s.empty() && curr > T[s.top()]){
            int top = s.top();
            output[top] = i - top;
            s.pop();
        }   
        s.push(i);
    }    
    return output;    
}

vector<int> bruteForce(vector<int>& T){
    vector<int> result(T.size());

    int size = T.size();

    int j = 1, i = 0;
		while (i < size - 1) {
			if (T[i] < T[j]) {
				result[i] = j - i;
				i++;
				j = i + 1;
			} else if (j == size - 1) {
				i++;
				j = i + 1;
			} else {
				j++;
			}
		}
		return result;
}
int main(){
    vector<int> T = {73, 74, 75, 71, 69, 72, 76, 73};
    vector<int> output(T.size());

    output = dailyTemperatures(T);

    for(int i =0; i < output.size(); i++){
        cout<<output[i]<<"\t";
    }

    output = bruteForce(T);
    
    cout<<endl;
    for(int i =0; i < output.size(); i++){
        cout<<output[i]<<"\t";
    }
}