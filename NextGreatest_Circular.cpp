//time complexity: O(n) -> we iterate through the circular array twice so it's 2n which is n asymptotically
//space complexity: O(n) -> solutionVector space is n 

// Did it run on Leetcode: Yes 

//logic:

//1. Iterate through the array in the first iteration pushing elements' indices in stack until next great val when we pop & add it to solution vector
//2. In the second iteration don't push anything. Try to find bigger values in the array that can pop out anything remaining the stack


#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution {
    public:
        vector<int> nextGreaterElements(vector<int>& inputVal)
        {
            vector<int> solutionVector(inputVal.size(), -1);
            stack<int> myStack;

            for(int i = 0; i< 2*inputVal.size(); i++)
            {   
                int index = i % inputVal.size(); //reset i to 0 after i goes past size

                while(!myStack.empty() && inputVal[myStack.top()] < inputVal[index])
                {
                    int popped = myStack.top();
                    myStack.pop();

                    solutionVector[popped] = inputVal[index]; 
                }

                if(i < inputVal.size()) //push only in the first iteration
                    myStack.push(i);        
            }

            return solutionVector;
        }
};