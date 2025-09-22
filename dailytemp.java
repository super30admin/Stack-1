// Time Complexity: O(n) — single right-to-left pass; the inner while uses amortized O(1) jumps via precomputed distances.
// Space Complexity: O(1).

// Traverse from right to left tracking hottest; if temperatures[i] ≥ hottest, update hottest and continue.
// Otherwise set days = 1 and, while temperatures[i + days] ≤ temperatures[i], jump forward with days += result[i + days] to skip cooler/equal days.
// Set result[i] = days; after finishing the pass, return result.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        int hottest = 0;

        for(int i = n - 1; i >= 0; i--) {
            if(temperatures[i] >= hottest) {
                hottest = temperatures[i];
                continue;
            }

            int days = 1;
            while(temperatures[i + days] <= temperatures[i]) {
                days += result[i + days];
            }

            result[i] = days;
        }

        return result;
    }
}
