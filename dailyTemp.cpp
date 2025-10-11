#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We go backwards and track the hottest temperature seen so far.
If current day is cooler, we jump forward by already computed values to skip unnecessary checks.
This helps us quickly find how many days until a warmer one shows up.
*/
class Solution{
public:
    vector<int> dailyTemperature(vector<int>& temperatures){
        vector<int> result(temperatures.size());
        int hottest = 0;
        int i = temperatures.size() - 1;
        while(i >= 0){
            if(temperatures[i] >= hottest){
                hottest = temperatures[i];
                i--;
                continue;
            }
            int days = 1;
            while(temperatures[i+days] <= temperatures[i]){
                days += result[i+days];
            }
            result[i] = days;
            i--;
        }
        return result;
    }
};
