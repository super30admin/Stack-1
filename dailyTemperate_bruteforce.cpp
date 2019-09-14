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
