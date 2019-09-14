//Time Complexity: O(n) -> We iterate once through all the elements
//Space Complexity: O(n) -> solutionVector takes O(N) space

//Does it work on LeetCode?: Yes

//Logic: 

//1. Initialize empty result vector to the size of all temperatures.
//2. Keep adding elements' indices to the stack that are less than their next values
//3. Whenever the next value is greater than top value in stack, pop it
//   & place difference between indices at the top value index of result vector 


#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution{

    public:
        vector<int> dailyTemperatures(vector<int>&T)
        {
            vector<int>solutionVector(T.size(), 0);
            stack<int> myStack;

            for(int i = 0; i<T.size(); i++)
            {
                while(!myStack.empty() && T[i] > T[myStack.top()])
                {
                    int popped = myStack.top();
                    myStack.pop();
                    solutionVector[popped] = i - popped; //difference between indices is the number of days until warmer temp
                }

                myStack.push(i); //keep pushing until next warmer day
            }


            return solutionVector;
        }


};