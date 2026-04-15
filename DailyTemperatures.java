// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We maintain a variable to record the hottest temperature in the entire input array. Whenever we find a new
hottest temperature we just continue.If not, we try to get the nearby hotter temperature by using already
precomputed results and jump indices accordingly instead of going through each index's value comparison.
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] re = new int[n];
        int hottest = 0;

        for(int i = n - 1 ; i >= 0 ; i--) {
            if(temperatures[i] >= hottest) {
                hottest = temperatures[i];
                continue;
            }
            int days = 1;
            while(temperatures[i + days] <= temperatures[i]) {
                days += re[i + days];
            }
            re[i] = days;
        }
        return re;
    }
}