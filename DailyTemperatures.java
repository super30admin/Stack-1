// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {

        int n = T.length;
        int[] output = new int[n];

        for(int i=n-2;i>=0;i--){

            int index = i+1;

            while(true){
                // if the next greater element is found
                if(T[index] > T[i]){
                    output[i] = index-i;
                    break;
                }
                // zero represents no next greater
                else if(output[index] == 0){
                    break;
                }
                // move the index to next position
                else{
                    index += output[index];
                }
            }
        }
        return output;
    }
}
