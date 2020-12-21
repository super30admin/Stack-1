// Time Complexity : O(n^2), where n is the size of the array
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach in plain English
//1. for each day in the array, search the next warmer day in the array ahead
//2. if you get the next warmer day, add the difference of the days in the result array, break the loop and move forward to find the 
        //next warmer day for the next day in the array
//3. return the result in the end

// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        //result array
        int[] result = new int[T.length];
        //edge case
        if(T == null || T.length == 0) return result;
        //Iterate over the array, and for each day search for the next warmer day ahead
        for(int i=0; i<T.length-1; i++){
            for(int j=i+1; j<T.length; j++){
                //if it the next warmer, calculate the number of days (diff)
                if(T[i] < T[j]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }
}