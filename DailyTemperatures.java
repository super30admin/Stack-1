/*
The time complexity is O(N) where N is number of elements in the array and the space complexity is O(1) if we dont consider the ret array.

The intuition is to start from the back of the array and for each index have a pointer which moves through the processed part to find the
answer. For ex if we know that T[j] (j>i) is not our highest value we move to j's highest value (T[j+ret[j]]) since we know that the
middel values will will be less than T[j].

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;

        //Index processed will be stored in ret array.
        int[] ret = new int[length];

        //Loop through T
        for(int i=length-1;i>=0;i--){

            //Start from j = i+1;
            int j = i+1; int currTemp = T[i];

            //Make sure that j is less than T.length
            while(j<=length-1){

                //If found enter the value into ret array.
                if(T[j]>currTemp){
                    ret[i] = j-i;
                    break;
                }
                else if(ret[j]==0){
                    break;
                }
                else{

                    //Not found move to the next canditate of j.
                    j = j+ret[j];
                }
            }
        }

        return ret;
    }
}