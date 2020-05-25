// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DailyTemperatures {
    // Brute Force
    public int[] dailyTemperatures(int[] T) {
        int[] output = new int[T.length];
        for(int i = 0; i < T.length; i++){
            int j = i + 1;
            int count = 0;
            while(j < T.length){
                count++;
                if(T[i] < T[j]){
                    break;
                } else if(T[i] >= T[j] && j == T.length - 1){
                    count = 0;
                    break;
                } else {
                    j++;
                }
            }

            output[i] = count;
        }

        return output;
    }
}
