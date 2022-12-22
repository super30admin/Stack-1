// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/*
 * Can also be solved used monotonic decreasing stack, 
 * in this solution we keep track of hottest day and loop for the no of days from curr dayto the hottest day.
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1) return new int[]{0};
        int [] result = new int[n];
        int hottest=0;
        //iterate through array from the right
        for (int currDay = n-1; currDay >= 0 ; currDay--) {
            int currTemp = temperatures[currDay];
            //keep updating hottest 
            if (currTemp >= hottest) {
                hottest = currTemp;
                continue;
            }
            //when the value is less than hottest
            int days = 1;
            //count the no of days till you find the next hottest
            while(temperatures[currDay+days] <= currTemp){
                days+=result[currDay+days];
            } 
            //update the result
            result[currDay]=days;
        }
        return result; 
    }
}