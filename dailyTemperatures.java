/**
TC: O(n) n: total no. elements of in temperatures[]
SC: O(1) 
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        int hottest = 0;

        for(int i = n-1; i>=0; i--){
            int currTemp = temperatures[i];

            if(currTemp >= hottest){
                hottest = currTemp;
                answer[i] = 0;
                continue;
            }

            int days = 1;

            while(temperatures[i + days] <= currTemp){
                days += answer[i+days];
            }

            answer[i] = days;
        }
    return answer;
    }
}