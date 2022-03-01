// Time Complexity : Add : O(N)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        dailyTemperatures(temperatures);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        int max = temperatures[n-1];  // last element as the warmest day

        for(int i=n-2; i>=0; i--){    // T.C - O(N)  , S.C - O(1)
            int j = i+1;  //  check the next warmer day

            if(temperatures[i] >= max){  // if current day is warmest, assign it to max
                max = temperatures[i];
                continue;
            }

            while(j != n-1 && temperatures[i] >= temperatures[j]){  // loop until it finds the warmest day
                j += result[j];
            }

            result[i] = j-i;  // diff between the index
        }

        return result;
    }
}

