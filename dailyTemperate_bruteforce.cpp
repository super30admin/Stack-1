//Time Complexity: O(n^2) 
//Space Complexity: O(n)

//Does it work on LeetCode?: Passes 36/37 test cases. Run Time error on last test

//Logic: Check the first larger value for all values in vector T & return them


#include <iostream>
#include <vector>

using namespace std;


class Solution {
    public:
        vector<int> dailyTemperatures(vector<int>&T)
        {
            vector<int>SolutionVector(T.size(), 0);

            for(int i = 0; i<T.size(); i++)
            {
                for(int j = i + 1; j<T.size(); j++)
                {
                    if(T[j] > T[i])
                    {
                        SolutionVector[i] = j-i;
                        break;
                    }
                }
            }

            return SolutionVector;
        }


};
